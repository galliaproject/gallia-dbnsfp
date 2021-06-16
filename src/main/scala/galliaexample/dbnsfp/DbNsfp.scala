package galliaexample.dbnsfp

import aptus.{Anything_, String_, Seq_}
import aptus.FilePath
import gallia._

// ===========================================================================
object DbNsfp {
  import DbNsfpConstants._
  import DbNsfpInputFields._
  import DbNsfpOutputFields._

  // ===========================================================================
  def apply
      (in  : FilePath,
       out : FilePath) =
    in

      .stream { _.tsv.noInferring.iteratorMode }
      .logProgress(100)

      // ===========================================================================
      // handle trivially missing values

      // so gets picked up by next removal (only fields with dash instead of dot (eg for 1:986633))
      .translate(MutPred_score, MutPred_Top5features).using("-" -> MainMissingValue)

      // leave more complex ones untouched for now
      .forAllKeys(_.removeIfValueFor(_).is(MainMissingValue))

      .convert(ref, alt).toRequired // TODO: more here

      // ===========================================================================
      .rename(
           hg19_chr           ~> chr,
          `hg19_pos(1-based)` ~> pos)

      // ---------------------------------------------------------------------------
      .filterBy(
            _.string_(pos),
            _.string (ref),
            _.string (alt))
          .matches {
        (pos, ref, alt) =>
          pos.nonEmpty &&
          ref != alt }

      .convert(chr, pos).toRequired

       // ---------------------------------------------------------------------------
       // add shorthand (to act as ID)

       .generate(shorthand).from(
            _.string(chr),
            _.string(pos),
            _.string(ref),
            _.string(alt))
          .using { (chr, pos, ref, alt) =>
            assert(BasicNucleotideSet.contains(ref))
            assert(BasicNucleotideSet.contains(alt))

            assert( chr != MainMissingValue)

            s"${chr}:${pos.toLong};${ref}>${alt}" }

      // ---------------------------------------------------------------------------
      .map(rejig(_))

      // ---------------------------------------------------------------------------
      .write(out)

  // ===========================================================================
  def rejig(obj: HeadU): HeadU = {
    obj

        // ===========================================================================
        // transposing

          // ---------------------------------------------------------------------------
          // GTEx

          .zipStrings(
              GTEx_V7_gene   ~> gene,
              GTEx_V7_tissue ~> tissue)
            .splitBy(MainTupleSeparator)
              .underNewKey(V7)
          .nest(V7).under(GTEx)

          // ---------------------------------------------------------------------------
          // MutationTaster
          .zipStrings(
                MutationTaster_score ~> score,
                MutationTaster_AAE   ~> AA_exchange,
                MutationTaster_model ~> model,
                MutationTaster_pred  ~> prediction )
              .splitBy(MainTupleSeparator).underNewKey(MutationTaster)

          // ---------------------------------------------------------------------------
          // genes

          .zipStrings(Transposing.GeneKeys.keyz)
              .splitBy(MainTupleSeparator)
                .underNewKey(genes)

            // handle the "." parts of eg ".;.;.;.;." or ".;.;.;YES;." (see "21:44473990;T>A" for instance)
            .transformObjects(genes).using {
              _.forAllKeys {
                _.removeIfValueFor(_).is(MainMissingValue) } }

        // ===========================================================================
        // gnomad

          // ---------------------------------------------------------------------------
          // exomes

          .split(gnomAD_exomes_flag).by(";")

          .rename( // add _overall manually for those (easier)
              gnomAD_exomes_AN      ~> 'gnomAD_exomes_overall_AN,
              gnomAD_exomes_AC      ~> 'gnomAD_exomes_overall_AC,
              gnomAD_exomes_AF      ~> 'gnomAD_exomes_overall_AF,
              gnomAD_exomes_nhomalt ~> 'gnomAD_exomes_overall_nhomalt,
              gnomAD_exomes_flag    ~> 'gnomAD_exomes_overall_flag )

          .forKeysMatching(_.startsWith("gnomAD_exomes_controls_"))
            .zen {
              _.rename(_).using {
                _.replace( // eg: gnomAD_exomes_controls_AC ~> gnomAD_exomes_controls_overall_AC
                  "gnomAD_exomes_controls_",
                  "gnomAD_exomes_controls_overall_") } }

          .forKeysMatching { key =>
               key.startsWith("gnomAD_exomes_") &&
               key.notContains("overall_") }
            .zen {
              _.rename(_).using {
                _.replace( // eg: gnomAD_exomes_POPMAX_AC ~> gnomAD_exomes_default_POPMAX_AC
                  "gnomAD_exomes_",
                  "gnomAD_exomes_default_") } }

          // ---------------------------------------------------------------------------
          // genomes

          .split(gnomAD_genomes_flag).by(";")

          .rename( // add _overall manually for those (easier)
              gnomAD_genomes_AN               ~> 'gnomAD_genomes_overall_AN,
              gnomAD_genomes_AC               ~> 'gnomAD_genomes_overall_AC,
              gnomAD_genomes_AF               ~> 'gnomAD_genomes_overall_AF,
              gnomAD_genomes_nhomalt          ~> 'gnomAD_genomes_overall_nhomalt,
              gnomAD_genomes_flag             ~> 'gnomAD_genomes_overall_flag )

          .forKeysMatching(_.startsWith("gnomAD_genomes_controls_")).zen {
            _.rename(_).using {
              _.replace( // eg: gnomAD_genomes_controls_AC ~> gnomAD_genomes_controls_overall_AC
                "gnomAD_genomes_controls_",
                "gnomAD_genomes_controls_overall_") } }

          .forKeysMatching { key =>
               key.startsWith("gnomAD_genomes_") &&
              !key.contains("overall_") }
            .zen {
              _.rename(_).using {
                _.replace( // eg: gnomAD_genomes_POPMAX_AC ~> gnomAD_genomes_default_POPMAX_AC
                  "gnomAD_genomes_",
                  "gnomAD_genomes_default_") } }

      // ===========================================================================
      // ExAC

        .rename(
            ExAC_AC ~> 'ExAC_overall_AC,
            ExAC_AF ~> 'ExAC_overall_AF,

            ExAC_nonTCGA_AC ~> 'ExAC_nonTCGA_overall_AC,
            ExAC_nonTCGA_AF ~> 'ExAC_nonTCGA_overall_AF,

            ExAC_nonpsych_AC ~> 'ExAC_nonpsych_overall_AC,
            ExAC_nonpsych_AF ~> 'ExAC_nonpsych_overall_AF)

         // default as opposed to nonTCGA and nonpsych
        .forKeysMatching { key =>
            key.startsWith("ExAC_") &&
            key.notContains("_overall_") }
          .zen {
            _.rename(_).using {
              _.replace("ExAC_", "ExAC_default") } }

       // ===========================================================================
       // clinvar

       .transformString(clinvar_review).using(DbNsfpUtils.normalizeClinvarReview)

       .rename(
            clinvar_clnsig     ~> 'clinvar_significance,
            clinvar_hgvs       ~> 'clinvar_HGVS,
            clinvar_var_source ~> 'clinvar_source)

       .split(
            'clinvar_source,
             clinvar_trait      ,
             clinvar_MedGen_id  ,
             clinvar_OMIM_id    ,
             clinvar_Orphanet_id)
           .by("|")

      // ===========================================================================
      // renestings

      // there are ~700 underscores, most actually represent nesting
      // we use '@' temporarily to avoid unwanted renesting

      .transformObjects(genes).using {
        _ .rename(      Renesting.GeneObjectExplicitRenamings   ) // eg: "genename" to "symbol"
          .rename(DbNsfpRenesting.geneObjectRuleBasedRenamings _) // eg: append "iction" to "_pred"-ending fields
          .renestAllKeys.usingSeparator("_") }

      // ---------------------------------------------------------------------------
      .rename(      Renesting.RootObjectExplicitRenamings   ) // eg: "aaalt" to "AA_alt"
      .rename(DbNsfpRenesting.rootObjectRuleBasedRenamings _) // eg: append "iction" to "_pred"-ending fields
      .renestAllKeys.usingSeparator("_")

      // ---------------------------------------------------------------------------
      .forPathsMatching(_.key.name.contains("@")).zen { // this is a fairly costly operation as is
        _.rename(_).using {
          _.replace("@", "_") } }

      // ===========================================================================
      // MutPred top 5 features

      .transformObject(MutPred).using {
        _ .rename('Top5features ~> top_5_features)
          .split          (        top_5_features ).by("; ") // has space following semi-colon (only one like that)
          .transformString(        top_5_features).using(MutPredTransformer.apply) }

      // ===========================================================================
      // misc

      .nest(alt, ref).under(change)

      .nest(
          'ancestral_allele, // TODO: keep?
          Denisova,
          AltaiNeandertal,
          VindijiaNeandertal)
        .under('genotypes)

      // ---------------------------------------------------------------------------
      // genes

      .transformObjects(genes).using {
        _ .convert(VEP_canonical).toStrictFlag("YES")
          .transformString(TSL).using(_.prepend("tsl"))
          .split(Interpro_domain).by(DbNsfpUtils.splitInterproDomain) }

      // ---------------------------------------------------------------------------
      // these have cardinalities that vary independently of "genes"
      //   (the gnomAD and the MutationTaster counterparts are handled in their dedicated processors)
      .split(rs_dbSNP151).by(";")

      .transformObject(Geuvadis |> eQTL)
          .using(_.split(target_gene).by(";"))

      .split(SiPhy |> `29way` |> pi).by(":") // only one like that

      // ===========================================================================
      // conversions (to numbers)

      .forPathsMatching(_.key.containedIn(Converting.IntegerKeys)).zen(_.convert(_).toInt   )
      .forPathsMatching(_.key.containedIn(Converting.   RealKeys)).zen(_.convert(_).toDouble)

      // ---------------------------------------------------------------------------
      .forEachKey(rankscores, phyloP, phastCons).zen {
        _.transformObject(_).using {
          _.forLeafPaths(_.convert(_).toDouble) } }

      // ---------------------------------------------------------------------------
      // TODO:
      // - can probably make some fields required at this point, eg MutationTaster.score, ...
      // - couple of more fields to be turned from string to numbers?
  }
}

// ===========================================================================
