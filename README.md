This is only intended to showcase processing in Gallia, it is not complete nor thoroughly tested at the moment. Use output at your own risk.

For more information, see gallia-core [documentation](https://github.com/galliaproject/gallia-core/blob/init/README.md), in particular the bioinformatics examples [section](https://github.com/galliaproject/gallia-core/blob/init/README.md#bioinformatics-examples).

Uses [_Gallia_ transformations](https://github.com/galliaproject/gallia-dbnsfp/blob/init/src/main/scala/galliaexample/dbnsfp/DbNsfp.scala#L14)

to turn rows such as:

```plain
#chr  pos(1-based)  ref  alt  aaref  aaalt  rs_dbSNP151  hg19_chr  hg19_pos(1-based)  hg18_chr  hg18_pos(1-based)  aapos                genename  Ensembl_geneid                                                                   Ensembl_transcriptid                                                             Ensembl_proteinid                                                                Uniprot_acc                    Uniprot_entry                                  HGVSc_ANNOVAR                                      HGVSp_ANNOVAR                            HGVSc_snpEff                                       HGVSp_snpEff                                                                          HGVSc_VEP                                          HGVSp_VEP                                                                                            APPRIS                                                    GENCODE_basic  TSL        VEP_canonical  cds_strand  refcodon  codonpos  codon_degeneracy  Ancestral_allele  AltaiNeandertal  Denisova  VindijiaNeandertal  SIFT_score  SIFT_converted_rankscore  SIFT_pred  SIFT4G_score  SIFT4G_converted_rankscore  SIFT4G_pred  LRT_score  LRT_converted_rankscore  LRT_pred  LRT_Omega  MutationTaster_score     MutationTaster_converted_rankscore  MutationTaster_pred      MutationTaster_model                                                                                                                             MutationTaster_AAE                                                       MutationAssessor_score  MutationAssessor_rankscore  MutationAssessor_pred  FATHMM_score  FATHMM_converted_rankscore  FATHMM_pred  PROVEAN_score  PROVEAN_converted_rankscore  PROVEAN_pred  MetaSVM_score  MetaSVM_rankscore  MetaSVM_pred  MetaLR_score  MetaLR_rankscore  MetaLR_pred  Reliability_index  M-CAP_score  M-CAP_rankscore  M-CAP_pred  MutPred_score  MutPred_rankscore  MutPred_protID  MutPred_AAchange  MutPred_Top5features  MVP_score  MVP_rankscore  MPC_score  MPC_rankscore  PrimateAI_score  PrimateAI_rankscore  PrimateAI_pred  DEOGEN2_score  DEOGEN2_rankscore  DEOGEN2_pred  Aloft_Fraction_transcripts_affected  Aloft_prob_Tolerant  Aloft_prob_Recessive  Aloft_prob_Dominant  Aloft_pred  Aloft_Confidence  DANN_score           DANN_rankscore  fathmm-MKL_coding_score  fathmm-MKL_coding_rankscore  fathmm-MKL_coding_pred  fathmm-MKL_coding_group  fathmm-XF_coding_score  fathmm-XF_coding_rankscore  fathmm-XF_coding_pred  Eigen-raw_coding   Eigen-raw_coding_rankscore  Eigen-pred_coding  Eigen-PC-raw_coding  Eigen-PC-raw_coding_rankscore  Eigen-PC-phred_coding  integrated_fitCons_score  integrated_fitCons_rankscore  integrated_confidence_value  GM12878_fitCons_score  GM12878_fitCons_rankscore  GM12878_confidence_value  H1-hESC_fitCons_score  H1-hESC_fitCons_rankscore  H1-hESC_confidence_value  HUVEC_fitCons_score  HUVEC_fitCons_rankscore  HUVEC_confidence_value  GERP++_NR  GERP++_RS  GERP++_RS_rankscore  phyloP100way_vertebrate  phyloP100way_vertebrate_rankscore  phyloP30way_mammalian  phyloP30way_mammalian_rankscore  phyloP17way_primate  phyloP17way_primate_rankscore  phastCons100way_vertebrate  phastCons100way_vertebrate_rankscore  phastCons30way_mammalian  phastCons30way_mammalian_rankscore  phastCons17way_primate  phastCons17way_primate_rankscore  SiPhy_29way_pi         SiPhy_29way_logOdds  SiPhy_29way_logOdds_rankscore  bStatistic  bStatistic_rankscore  1000Gp3_AC  1000Gp3_AF  1000Gp3_AFR_AC  1000Gp3_AFR_AF  1000Gp3_EUR_AC  1000Gp3_EUR_AF  1000Gp3_AMR_AC  1000Gp3_AMR_AF  1000Gp3_EAS_AC  1000Gp3_EAS_AF  1000Gp3_SAS_AC  1000Gp3_SAS_AF  TWINSUK_AC  TWINSUK_AF  ALSPAC_AC  ALSPAC_AF  UK10K_AC  UK10K_AF  ESP6500_AA_AC  ESP6500_AA_AF  ESP6500_EA_AC  ESP6500_EA_AF  ExAC_AC  ExAC_AF  ExAC_Adj_AC  ExAC_Adj_AF  ExAC_AFR_AC  ExAC_AFR_AF  ExAC_AMR_AC  ExAC_AMR_AF  ExAC_EAS_AC  ExAC_EAS_AF  ExAC_FIN_AC  ExAC_FIN_AF  ExAC_NFE_AC  ExAC_NFE_AF  ExAC_SAS_AC  ExAC_SAS_AF  ExAC_nonTCGA_AC  ExAC_nonTCGA_AF  ExAC_nonTCGA_Adj_AC  ExAC_nonTCGA_Adj_AF  ExAC_nonTCGA_AFR_AC  ExAC_nonTCGA_AFR_AF  ExAC_nonTCGA_AMR_AC  ExAC_nonTCGA_AMR_AF  ExAC_nonTCGA_EAS_AC  ExAC_nonTCGA_EAS_AF  ExAC_nonTCGA_FIN_AC  ExAC_nonTCGA_FIN_AF  ExAC_nonTCGA_NFE_AC  ExAC_nonTCGA_NFE_AF  ExAC_nonTCGA_SAS_AC  ExAC_nonTCGA_SAS_AF  ExAC_nonpsych_AC  ExAC_nonpsych_AF  ExAC_nonpsych_Adj_AC  ExAC_nonpsych_Adj_AF  ExAC_nonpsych_AFR_AC  ExAC_nonpsych_AFR_AF  ExAC_nonpsych_AMR_AC  ExAC_nonpsych_AMR_AF  ExAC_nonpsych_EAS_AC  ExAC_nonpsych_EAS_AF  ExAC_nonpsych_FIN_AC  ExAC_nonpsych_FIN_AF  ExAC_nonpsych_NFE_AC  ExAC_nonpsych_NFE_AF  ExAC_nonpsych_SAS_AC  ExAC_nonpsych_SAS_AF  gnomAD_exomes_flag  gnomAD_exomes_AC  gnomAD_exomes_AN  gnomAD_exomes_AF  gnomAD_exomes_nhomalt  gnomAD_exomes_AFR_AC  gnomAD_exomes_AFR_AN  gnomAD_exomes_AFR_AF  gnomAD_exomes_AFR_nhomalt  gnomAD_exomes_AMR_AC  gnomAD_exomes_AMR_AN  gnomAD_exomes_AMR_AF  gnomAD_exomes_AMR_nhomalt  gnomAD_exomes_ASJ_AC  gnomAD_exomes_ASJ_AN  gnomAD_exomes_ASJ_AF  gnomAD_exomes_ASJ_nhomalt  gnomAD_exomes_EAS_AC  gnomAD_exomes_EAS_AN  gnomAD_exomes_EAS_AF  gnomAD_exomes_EAS_nhomalt  gnomAD_exomes_FIN_AC  gnomAD_exomes_FIN_AN  gnomAD_exomes_FIN_AF  gnomAD_exomes_FIN_nhomalt  gnomAD_exomes_NFE_AC  gnomAD_exomes_NFE_AN  gnomAD_exomes_NFE_AF  gnomAD_exomes_NFE_nhomalt  gnomAD_exomes_SAS_AC  gnomAD_exomes_SAS_AN  gnomAD_exomes_SAS_AF  gnomAD_exomes_SAS_nhomalt  gnomAD_exomes_POPMAX_AC  gnomAD_exomes_POPMAX_AN  gnomAD_exomes_POPMAX_AF  gnomAD_exomes_POPMAX_nhomalt  gnomAD_exomes_controls_AC  gnomAD_exomes_controls_AN  gnomAD_exomes_controls_AF  gnomAD_exomes_controls_nhomalt  gnomAD_exomes_controls_AFR_AC  gnomAD_exomes_controls_AFR_AN  gnomAD_exomes_controls_AFR_AF  gnomAD_exomes_controls_AFR_nhomalt  gnomAD_exomes_controls_AMR_AC  gnomAD_exomes_controls_AMR_AN  gnomAD_exomes_controls_AMR_AF  gnomAD_exomes_controls_AMR_nhomalt  gnomAD_exomes_controls_ASJ_AC  gnomAD_exomes_controls_ASJ_AN  gnomAD_exomes_controls_ASJ_AF  gnomAD_exomes_controls_ASJ_nhomalt  gnomAD_exomes_controls_EAS_AC  gnomAD_exomes_controls_EAS_AN  gnomAD_exomes_controls_EAS_AF  gnomAD_exomes_controls_EAS_nhomalt  gnomAD_exomes_controls_FIN_AC  gnomAD_exomes_controls_FIN_AN  gnomAD_exomes_controls_FIN_AF  gnomAD_exomes_controls_FIN_nhomalt  gnomAD_exomes_controls_NFE_AC  gnomAD_exomes_controls_NFE_AN  gnomAD_exomes_controls_NFE_AF  gnomAD_exomes_controls_NFE_nhomalt  gnomAD_exomes_controls_SAS_AC  gnomAD_exomes_controls_SAS_AN  gnomAD_exomes_controls_SAS_AF  gnomAD_exomes_controls_SAS_nhomalt  gnomAD_exomes_controls_POPMAX_AC  gnomAD_exomes_controls_POPMAX_AN  gnomAD_exomes_controls_POPMAX_AF  gnomAD_exomes_controls_POPMAX_nhomalt  gnomAD_genomes_flag  gnomAD_genomes_AC  gnomAD_genomes_AN  gnomAD_genomes_AF  gnomAD_genomes_nhomalt  gnomAD_genomes_AFR_AC  gnomAD_genomes_AFR_AN  gnomAD_genomes_AFR_AF  gnomAD_genomes_AFR_nhomalt  gnomAD_genomes_AMR_AC  gnomAD_genomes_AMR_AN  gnomAD_genomes_AMR_AF  gnomAD_genomes_AMR_nhomalt  gnomAD_genomes_ASJ_AC  gnomAD_genomes_ASJ_AN  gnomAD_genomes_ASJ_AF  gnomAD_genomes_ASJ_nhomalt  gnomAD_genomes_EAS_AC  gnomAD_genomes_EAS_AN  gnomAD_genomes_EAS_AF  gnomAD_genomes_EAS_nhomalt  gnomAD_genomes_FIN_AC  gnomAD_genomes_FIN_AN  gnomAD_genomes_FIN_AF  gnomAD_genomes_FIN_nhomalt  gnomAD_genomes_NFE_AC  gnomAD_genomes_NFE_AN  gnomAD_genomes_NFE_AF  gnomAD_genomes_NFE_nhomalt  gnomAD_genomes_POPMAX_AC  gnomAD_genomes_POPMAX_AN  gnomAD_genomes_POPMAX_AF  gnomAD_genomes_POPMAX_nhomalt  gnomAD_genomes_controls_AC  gnomAD_genomes_controls_AN  gnomAD_genomes_controls_AF  gnomAD_genomes_controls_nhomalt  gnomAD_genomes_controls_AFR_AC  gnomAD_genomes_controls_AFR_AN  gnomAD_genomes_controls_AFR_AF  gnomAD_genomes_controls_AFR_nhomalt  gnomAD_genomes_controls_AMR_AC  gnomAD_genomes_controls_AMR_AN  gnomAD_genomes_controls_AMR_AF  gnomAD_genomes_controls_AMR_nhomalt  gnomAD_genomes_controls_ASJ_AC  gnomAD_genomes_controls_ASJ_AN  gnomAD_genomes_controls_ASJ_AF  gnomAD_genomes_controls_ASJ_nhomalt  gnomAD_genomes_controls_EAS_AC  gnomAD_genomes_controls_EAS_AN  gnomAD_genomes_controls_EAS_AF  gnomAD_genomes_controls_EAS_nhomalt  gnomAD_genomes_controls_FIN_AC  gnomAD_genomes_controls_FIN_AN  gnomAD_genomes_controls_FIN_AF  gnomAD_genomes_controls_FIN_nhomalt  gnomAD_genomes_controls_NFE_AC  gnomAD_genomes_controls_NFE_AN  gnomAD_genomes_controls_NFE_AF  gnomAD_genomes_controls_NFE_nhomalt  gnomAD_genomes_controls_POPMAX_AC  gnomAD_genomes_controls_POPMAX_AN  gnomAD_genomes_controls_POPMAX_AF  gnomAD_genomes_controls_POPMAX_nhomalt  clinvar_id  clinvar_clnsig  clinvar_trait  clinvar_review  clinvar_hgvs  clinvar_var_source  clinvar_MedGen_id  clinvar_OMIM_id  clinvar_Orphanet_id  Interpro_domain  GTEx_V7_gene  GTEx_V7_tissue  Geuvadis_eQTL_target_gene     
21    6445558       T    A    X      C      .            21        44473990           21        43347059           552;552;552;552;566  CBSL      ENSG00000274276;ENSG00000274276;ENSG00000274276;ENSG00000274276;ENSG00000274276  ENST00000624406;ENST00000398168;ENST00000618024;ENST00000617706;ENST00000624934  ENSP00000485669;ENSP00000381234;ENSP00000479559;ENSP00000481719;ENSP00000485527  P0DN79;P0DN79;P0DN79;P0DN79;.  CBSL_HUMAN;CBSL_HUMAN;CBSL_HUMAN;CBSL_HUMAN;.  c.1656A>T;c.1656A>T;c.1656A>T;c.1656A>T;c.1698A>T  p.X552C;p.X552C;p.X552C;p.X552C;p.X566C  c.1656A>T;c.1656A>T;c.1656A>T;c.1656A>T;c.1698A>T  p.Ter552Cysext*?;p.Ter552Cysext*?;p.Ter552Cysext*?;p.Ter552Cysext*?;p.Ter566Cysext*?  c.1656A>T;c.1656A>T;c.1656A>T;c.1656A>T;c.1698A>T  p.Ter552CysextTer31;p.Ter552CysextTer31;p.Ter552CysextTer14;p.Ter552CysextTer31;p.Ter566CysextTer31  principal2;principal2;principal2;principal2;alternative2  Y;Y;Y;Y;Y      1;1;1;1;5  .;.;.;YES;.    -           TGA       3         0                 .                 T/T              T/T       T/T                 .;.;.;.;.   .                         .;.;.;.;.  .;.;.;.;.     .                           .;.;.;.;.    .          .                        .         .          1;1;1;1;1;1;1;1;1;1;1;1  0.08975                             N;N;N;N;N;N;N;N;N;N;N;N  complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae;complex_aae  *464C;*566C;*552C;*552C;*552C;*552C;*464C;*552C;*552C;*552C;*552C;*566C  .;.;.;.;.               .                           .;.;.;.;.              .             .                           .            .;.;.;.;.      .                            .;.;.;.;.     .              .                  .             .             .                 .            .                  .            .                .           .              .                  .               .                 .                     .;.;.;.;.  .              .;.;.;.;.  .              .                .                    .               .;.;.;.;.      .                  .;.;.;.;.     .;.;.;.;.                            .;.;.;.;.            .;.;.;.;.             .;.;.;.;.            .;.;.;.;.   .;.;.;.;.         0.54113587345593983  0.05073         0.08502                  0.14423                      N                       AEFDBHCI                 .                       .                           .                      0.200976666004101  0.51248                     3.307481           -0.163821194829558   0.32880                        1.875051               0.262962                  0.04601                       0                            0.304816               0.05638                    0                         0.189914               0.04498                    0                         0.285054             0.05467                  0                       4.87       2.51       0.29435              0.223000                 0.17501                            -0.254000              0.08183                          0.455000             0.21489                        0.000000                    0.06391                               0.000000                  0.01923                             0.009000                0.08673                           0.0:0.2717:0.0:0.7283  7.5162               0.26770                        .           .                     .           .           .               .               .               .               .               .               .               .               .               .               .           .           .          .          .         .         .              .              .              .              .        .        .            .            .            .            .            .            .            .            .            .            .            .            .            .            .                .                .                    .                    .                    .                    .                    .                    .                    .                    .                    .                    .                    .                    .                    .                    .                 .                 .                     .                     .                     .                     .                     .                     .                     .                     .                     .                     .                     .                     .                     .                     .                   .                 .                 .                 .                      .                     .                     .                     .                          .                     .                     .                     .                          .                     .                     .                     .                          .                     .                     .                     .                          .                     .                     .                     .                          .                     .                     .                     .                          .                     .                     .                     .                          .                        .                        .                        .                             .                          .                          .                          .                               .                              .                              .                              .                                   .                              .                              .                              .                                   .                              .                              .                              .                                   .                              .                              .                              .                                   .                              .                              .                              .                                   .                              .                              .                              .                                   .                              .                              .                              .                                   .                                 .                                 .                                 .                                      .                    .                  .                  .                  .                       .                      .                      .                      .                           .                      .                      .                      .                           .                      .                      .                      .                           .                      .                      .                      .                           .                      .                      .                      .                           .                      .                      .                      .                           .                         .                         .                         .                              .                           .                           .                           .                                .                               .                               .                               .                                    .                               .                               .                               .                                    .                               .                               .                               .                                    .                               .                               .                               .                                    .                               .                               .                               .                                    .                               .                               .                               .                                    .                                  .                                  .                                  .                                       .           .               .              .               .             .                   .                  .                .                    .;.;.;.;.        .             .                                          .  
```

into objects like:

```json
{
  "shorthand": "21:44473990;T>A",  
  "locus": {
    "hg20": {
      "chromosome": "21",
      "position": 6445558 },
    "hg19": {
      "chromosome": "21",
      "position": 44473990 },
    "hg18": {
      "chromosome": "21",
      "position": 43347059 },
    "cds": { "strand": "-" } },  
  "genes": [
    {
      "AA_position": 552,
      "symbol": "CBSL",
      "APPRIS": "principal2",
      "TSL": "tsl1",
      "accession": "P0DN79",
      "codon": {
        "degeneracy": 0,
        "ref": "TGA" },
      "ensembl": {
        "gene_id": "ENSG00000274276",
        "transcript_id": "ENST00000624406",
        "protein_id": "ENSP00000485669" },
      "GENCODE": { "basic": "Y" },
      "HGVS": {
        "c": {
          "ANNOVAR": "c.1656A>T",
          "VEP": "c.1656A>T",
          "snpEff": "c.1656A>T" },
        "p": {
          "ANNOVAR": "p.X552C",
          "VEP": "p.Ter552CysextTer31",
          "snpEff": "p.Ter552Cysext*?"  } },
      "Uniprot": {
        "entry": "CBSL_HUMAN" } },
    { "AA_position": 552,
      "symbol": "CBSL",
      "APPRIS": "principal2",
      "TSL": "tsl1",
      "accession": "P0DN79",
      "codon": {
        "degeneracy": 0,
        "ref": "TGA" },
      "ensembl": {
        "gene_id": "ENSG00000274276",
        "transcript_id": "ENST00000398168",
        "protein_id": "ENSP00000381234" },
      "GENCODE": {
        "basic": "Y" },
      "HGVS": {
        "c": {
          "ANNOVAR": "c.1656A>T",
          "VEP": "c.1656A>T",
          "snpEff": "c.1656A>T" },
        "p": {
          "ANNOVAR": "p.X552C",
          "VEP": "p.Ter552CysextTer31",
          "snpEff": "p.Ter552Cysext*?"  } },
      "Uniprot": {
        "entry": "CBSL_HUMAN" } },
    { "AA_position": 552,
      "symbol": "CBSL",
      "APPRIS": "principal2",
      "TSL": "tsl1",
      "accession": "P0DN79",
      "codon": {
        "degeneracy": 0,
        "ref": "TGA" },
      "ensembl": {
        "gene_id": "ENSG00000274276",
        "transcript_id": "ENST00000618024",
        "protein_id": "ENSP00000479559" },
      "GENCODE": {
        "basic": "Y" },
      "HGVS": {
        "c": {
          "ANNOVAR": "c.1656A>T",
          "VEP": "c.1656A>T",
          "snpEff": "c.1656A>T" },
        "p": {
          "ANNOVAR": "p.X552C",
          "VEP": "p.Ter552CysextTer14",
          "snpEff": "p.Ter552Cysext*?"  } },
      "Uniprot": {
        "entry": "CBSL_HUMAN" } },
    { "AA_position": 552,
      "symbol": "CBSL",
      "APPRIS": "principal2",
      "TSL": "tsl1",
      "accession": "P0DN79",
      "VEP_canonical": true,
      "codon": {
        "degeneracy": 0,
        "ref": "TGA" },
      "ensembl": {
        "gene_id": "ENSG00000274276",
        "transcript_id": "ENST00000617706",
        "protein_id": "ENSP00000481719" },
      "GENCODE": {
        "basic": "Y" },
      "HGVS": {
        "c": {
          "ANNOVAR": "c.1656A>T",
          "VEP": "c.1656A>T",
          "snpEff": "c.1656A>T" },
        "p": {
          "ANNOVAR": "p.X552C",
          "VEP": "p.Ter552CysextTer31",
          "snpEff": "p.Ter552Cysext*?"  } },
      "Uniprot": {
        "entry": "CBSL_HUMAN" } },
    { "AA_position": 566,
      "symbol": "CBSL",
      "APPRIS": "alternative2",
      "TSL": "tsl5",
      "codon": {
        "degeneracy": 0,
        "ref": "TGA" },
      "ensembl": {
        "gene_id": "ENSG00000274276",
        "transcript_id": "ENST00000624934",
        "protein_id": "ENSP00000485527" },
      "GENCODE": {
        "basic": "Y" },
      "HGVS": {
        "c": {
          "ANNOVAR": "c.1698A>T",
          "VEP": "c.1698A>T",
          "snpEff": "c.1698A>T" },
        "p": {
          "ANNOVAR": "p.X566C",
          "VEP": "p.Ter566CysextTer31",
          "snpEff": "p.Ter566Cysext*?"
        }
      }
    }
  ],
  "codon_position": 3,
  "AA": {
    "ref": "X",
    "alt": "C" },  
  "rankscores": {
    "MutationTaster": {
      "converted": 0.08975 },
    "DANN": {
      "raw": 0.05073 },
    "fathmm-MKL": {
      "coding": {
        "raw": 0.14423 } },
    "Eigen": {
      "coding": {
        "full": {
          "raw": {
            "raw": 0.51248 } },
        "PC": {
          "raw": {
            "raw": 0.3288 } } } },
    "integrated": {
      "fitCons": {
        "raw": 0.04601 }  },
    "GM12878": {
      "fitCons": {
        "raw": 0.05638 }  },
    "H1-hESC": {
      "fitCons": {
        "raw": 0.04498 }  },
    "HUVEC": {
      "fitCons": {
        "raw": 0.05467 }  },
    "GERP++": {
      "RS": {
        "raw": 0.29435 }  },
    "phyloP100way": {
      "vertebrate": {
        "raw": 0.17501 }  },
    "phyloP30way": {
      "mammalian": {
        "raw": 0.08183 }  },
    "phyloP17way": {
      "primate": {
        "raw": 0.21489 }  },
    "phastCons100way": {
      "vertebrate": {
        "raw": 0.06391 }  },
    "phastCons30way": {
      "mammalian": {
        "raw": 0.01923 }  },
    "phastCons17way": {
      "primate": {
        "raw": 0.08673 }  },
    "SiPhy": {
      "29way": {
        "logOdds": {
          "raw": 0.2677 } } } },
  "DANN": {
    "score": 0.5411358734559398 },
  "fathmm-MKL": {
    "coding": {
      "score": 0.08502,
      "group": "AEFDBHCI" } },
  "FATHMM-MKL": {
    "coding": {
      "prediction": "N" } },
  "Eigen": {
    "coding": {
      "full": {
        "raw": {
          "score": 0.200976666004101 },
        "phred": 3.307481 },
      "PC": {
        "raw": {
          "score": -0.163821194829558 },
        "phred": 1.875051 } } },
  "integrated": {
    "fitCons": {
      "score": 0.262962 },
    "confidence": 0 },
  "GM12878": {
    "fitCons": {
      "score": 0.304816 },
    "confidence": 0 },
  "H1-hESC": {
    "fitCons": {
      "score": 0.189914 },
    "confidence": 0 },
  "HUVEC": {
    "fitCons": {
      "score": 0.285054 },
    "confidence": 0 },
  "GERP++": {
    "NR": 4.87,
    "RS": {
      "score": 2.51 } },
  "phyloP": {
    "100way": {
      "vertebrate": 0.223 },
    "30way": {
      "mammalian": -0.254 },
    "17way": {
      "primate": {
        "value": 0.455 } } },
  "phastCons": {
    "100way": {
      "vertebrate": "0.000000" },
    "30way": {
      "mammalian": "0.000000" },
    "17way": {
      "primate": {
        "value": "0.009000" } } },
  "SiPhy": {
    "29way": {
      "pi": [
        0,
        0.2717,
        0,
        0.7283 ],
      "logOdds": {
        "score": 7.5162 } } },
  "genotypes": {
    "AltaiNeandertal": "T/T",
    "Denisova": "T/T",
    "VindijiaNeandertal": "T/T" },
  "MutationTaster": [
    { "score": 1,
      "AA_exchange": "*464C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*566C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*464C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*552C",
      "model": "complex_aae",
      "prediction": "N" },
    { "score": 1,
      "AA_exchange": "*566C",
      "model": "complex_aae",
      "prediction": "N" }
  ]
}
```

<a name="references">### dnNSFP References
- _Liu X, Jian X, and Boerwinkle E. 2011. dbNSFP: a lightweight database of human non-synonymous SNPs and their functional predictions. Human Mutation. 32:894-899._
- _Liu X, Jian X, and Boerwinkle E. 2013. dbNSFP v2.0: A Database of Human Non-synonymous SNVs and Their Functional Predictions and Annotations. Human Mutation. 34:E2393-E2402._
- _Liu X, Wu C, Li C, and Boerwinkle E. 2016. dbNSFP v3.0: A One-Stop Database of Functional Predictions and Annotations for Human Non-synonymous and Splice Site SNVs. Human Mutation. 37:235-241._
- _Liu X, Li C, Mou C, Dong Y, and Tu Y. 2020. dbNSFP v4: a comprehensive database of transcript-specific functional predictions and annotations for human nonsynonymous and splice-site SNVs. Genome Medicine. 12:103._
- _Dong C, Wei P, Jian X, Gibbs R, Boerwinkle E, Wang K* and Liu X*. (2015) Comparison and integration of deleteriousness prediction methods for nonsynonymous SNVs in whole exome sequencing studies. Human Molecular Genetics 24(8):2125-2137. *corresponding authors [PDF]_

