package galliaexample.dbnsfp

import aptus.String_

// ===========================================================================
object DbNsfpOutputFields {

  val chr = 'chr
  val pos = 'pos

  val shorthand = 'shorthand

  val codon_position = 'codon_position
  val reliability_index = 'reliability_index

  val codon      = 'codon
  val position   = 'position
  val degeneracy = 'degeneracy
  val symbol     = 'symbol

  val AC = 'AC
  val AN = 'AN
  val AF = 'AF
  val nhomalt = 'nhomalt

  // ===========================================================================
  object AloftFields {
    val confidence_level              = 'confidence_level
    val fraction_transcripts_affected = 'fraction_transcripts_affected

    // ---------------------------------------------------------------------------
    val dominant  = 'dominant
    val recessive = 'recessive
    val tolerant  = 'tolerant

    // ---------------------------------------------------------------------------
    val Aloft_probability = 'Aloft_probability
  }

  // ===========================================================================
  object HGVSFields {
    val ANNOVAR                           = 'ANNOVAR
    val snpEff                            = 'snpEff
    val VEP                               = 'VEP

    // ---------------------------------------------------------------------------
    val p = 'p
    val c = 'c
  }

  // ===========================================================================
  val AA_position = 'AA_position
  val AA_change   = 'AA_change

    val gene_id       = 'gene_id
    val transcript_id = 'transcript_id
    val protein_id    = 'protein_id

    val transcript_variation = 'transcript_variation

    val change    = 'change
    val genotypes = 'genotypes

    val converted_rankscore = 'converted_rankscore

  val score       = 'score
  val rankscore   = 'rankscore
  val prediction  = 'prediction
  val confidence  = 'confidence
  val probability = 'probability
  val accession   = 'accession
  val entry       = 'entry
  val id          = 'id

  val  AA_exchange = 'AA_exchange
  val  model       = 'model
  val `trait`      = 'trait

  val significance = 'significance

  val gene   = 'gene
  val tissue = 'tissue

  val rankscores = 'rankscores
    val converted  = 'converted

  val MutPred = 'MutPred
    val top_5_features = 'top_5_features

  val ensembl = 'ensembl

  val SIFT      = 'SIFT
  val SIFT4G    = 'SIFT4G
  val PROVEAN   = 'PROVEAN

  val VEST4 = 'VEST4

  val  FATHMM    = 'FATHMM
  val `FATHMM-MKL`   = "FATHMM-MKL".symbol
  val `FATHMM-XF`    = "FATHMM-XF" .symbol

  val VEST3     = 'VEST3
  val Polyphen2 = 'Polyphen2
  val Uniprot   = 'Uniprot
  val HDIV      = 'HDIV
  val HVAR      = 'HVAR

  val MutationAssessor = 'MutationAssessor
  val MutationTaster   = 'MutationTaster

  val GTEx = 'GTEx
    val V7        = 'V7

  val LRT = 'LRT

  val DEOGEN2  = 'DEOGEN2
  val Aloft    = 'Aloft
  val HGVS     = 'HGVS
  val MPC      = 'MPC
  val MVP      = 'MVP
  val Interpro = 'Interpro

  val `M-CAP` = "M-CAP".symbol

  val Geuvadis = 'Geuvadis
    val eQTL = 'eQTL
      val target_gene = 'target_gene

  val MetaLR  = 'MetaLR
  val MetaSVM = 'MetaSVM
  val `1KGP3` = "1KGP3".symbol

  val SiPhy = 'SiPhy
    val `29way` = "29way".symbol
      val pi = 'pi
  val `GERP++` = "GERP++".symbol
    val NR = 'NR
  val Eigen = 'Eigen

  val omega   = 'omega
  val p_value = 'p_value
  val phred   = 'phred

  val clinvar = 'clinvar

  val genes = 'genes

}

// ===========================================================================
