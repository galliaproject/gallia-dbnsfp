package galliaexample.dbnsfp

import gallia._

// ===========================================================================
object DbNsfpConstants {
  import DbNsfpInputFields._
  import DbNsfpOutputFields._

  // ===========================================================================
  val MainMissingValue   = "."
  val MainTupleSeparator = ";"

  // ---------------------------------------------------------------------------
  val BasicNucleotideSet = Set("A", "T", "G", "C")

  // ===========================================================================
  object Transposing {

    val GeneKeys: KeyWz =
      Seq(
          aapos           ,
          codon_degeneracy,
          genename        ,

          // ---------------------------------------------------------------------------
          cds_strand      ,
          codonpos        ,
          refcodon        ,

          // ---------------------------------------------------------------------------
          Ensembl_geneid      ,
          Ensembl_transcriptid,
          Ensembl_proteinid   ,

          // ---------------------------------------------------------------------------
          Aloft_Confidence                   ,
          Aloft_Fraction_transcripts_affected,
          Aloft_pred                         ,
          Aloft_prob_Dominant                ,
          Aloft_prob_Recessive               ,
          Aloft_prob_Tolerant                ,

          // ---------------------------------------------------------------------------
          APPRIS,

          // ---------------------------------------------------------------------------
          DEOGEN2_pred ,
          DEOGEN2_score,

          FATHMM_pred ,
          FATHMM_score,

          GENCODE_basic,

          HGVSc_ANNOVAR,
          HGVSc_VEP    ,
          HGVSc_snpEff ,

          HGVSp_ANNOVAR,
          HGVSp_VEP    ,
          HGVSp_snpEff ,

          Interpro_domain,

          MPC_score,

          MVP_score,

          MutationAssessor_pred ,
          MutationAssessor_score,

          PROVEAN_pred ,
          PROVEAN_score,

          SIFT4G_pred ,
          SIFT4G_score,

          SIFT_pred ,
          SIFT_score,

          TSL,

          Uniprot_acc  ,
          Uniprot_entry,

          VEP_canonical,
        ) ++
      // ---------------------------------------------------------------------------
      (if (!DbNsfpUtils.isAcademicUse) Nil
       else Seq(
          Polyphen2_HDIV_pred ,
          Polyphen2_HDIV_score,
          
          Polyphen2_HVAR_pred ,
          Polyphen2_HVAR_score,
          
          VEST4_score))
  }

  // ===========================================================================
  object Renesting {

    val GeneObjectExplicitRenamings = Map[KeyW, KeyW](
        aapos                      -> "AA@position",
        genename                   -> 'symbol,
 
       cds_strand                  -> "cds@strand",
       codonpos                    -> "codon_position",

        refcodon                   -> 'codon_ref, // so gets picked up with other codon_* like fields
        Uniprot_acc                -> 'accession,

        VEP_canonical              -> "VEP@canonical"  ,
        Interpro_domain            -> "Interpro@domain",


        // ===========================================================================
        // ensembl: missing underscore before id

        Ensembl_geneid       -> "ensembl_gene@id",
        Ensembl_transcriptid -> "ensembl_transcript@id",
        Ensembl_proteinid    -> "ensembl_protein@id",


        // ===========================================================================
        // Aloft: odd casing

        Aloft_prob_Dominant  -> 'Aloft_probability_dominant ,
        Aloft_prob_Recessive -> 'Aloft_probability_recessive,
        Aloft_prob_Tolerant  -> 'Aloft_probability_tolerant ,

        // ---------------------------------------------------------------------------
        Aloft_Confidence                    -> "Aloft_confidence@level", // TODO: can't use confidence else turned to int (homogenize?)
        Aloft_Fraction_transcripts_affected -> "Aloft_fraction@transcripts@affected",
      )

    // ===========================================================================
    val RootObjectExplicitRenamings = Map[KeyW, KeyW](

      // locus
          `#chr`          -> 'locus_hg20_chromosome,
      `hg18_chr`          -> 'locus_hg18_chromosome,
           'chr           -> 'locus_hg19_chromosome,

           `pos(1-based)` -> 'locus_hg20_position,
      `hg18_pos(1-based)` -> 'locus_hg18_position,
           'pos           -> 'locus_hg19_position,

        // ---------------------------------------------------------------------------
       // misc

       aaalt -> 'AA_alt,
       aaref -> 'AA_ref,

      `fathmm-MKL_coding_pred` -> "FATHMM-MKL_coding_pred",
      `fathmm-XF_coding_pred`  -> "FATHMM-XF_coding_pred" ,

       // insert _overall_
      `1000Gp3_AC` -> "1KGP3_overall_AC",
      `1000Gp3_AF` -> "1KGP3_overall_AF",

      // ---------------------------------------------------------------------------
      // Eigen
      `Eigen-raw_coding`              -> 'Eigen_coding_full_raw_score,
      `Eigen-raw_coding_rankscore`    -> 'Eigen_coding_full_rankscore,
      `Eigen-pred_coding`             -> 'Eigen_coding_full_phred    , // likely typo (pred vs phred)

      `Eigen-PC-raw_coding`           -> 'Eigen_coding_PC_raw_score  ,
      `Eigen-PC-raw_coding_rankscore` -> 'Eigen_coding_PC_rankscore  ,
      `Eigen-PC-phred_coding`         -> 'Eigen_coding_PC_phred      ,


      // ---------------------------------------------------------------------------
      // LRT

      LRT_pred                -> 'LRT_prediction,
      LRT_Omega               -> 'LRT_omega,


      // ---------------------------------------------------------------------------
      // MutPred; Top5features is handled separately
      MutPred_protID   -> 'MutPred_protein_id,
      MutPred_AAchange -> 'MutPred_AA_change ,

      // ---------------------------------------------------------------------------
      // misc
      Reliability_index         -> "reliability@index",
      Ancestral_allele          -> "ancestral@allele",
      rs_dbSNP151               -> "rs@dbSNP151",
      Geuvadis_eQTL_target_gene -> "Geuvadis_eQTL_target@gene",
    )
  }

  // ===========================================================================
  object Converting {

    val IntegerKeys: Seq[Key] =
      Seq(
        AC,
        AN,

              position,
           AA_position,
        codon_position,

        confidence,
        nhomalt,
        degeneracy,
      )

    // ---------------------------------------------------------------------------
    val RealKeys: Seq[Key] =
      Seq(
        score,
        AF,
        NR,
        pi,
        omega,
        phred,
        p_value,
        rankscore, // M-PAC, ...
        converted_rankscore, // only for LRT...
     )
  }

}

// ===========================================================================

