package galliaexample.dbnsfp

import aptus.String_

// ===========================================================================
object DbNsfpInputFields { // TODO: t210110100144 - macro for field names enum
  val `#chr`                                    = "#chr"        .symbol                    // 1
  val `pos(1-based)`                            = "pos(1-based)".symbol                    // 2

  val `ref`                                     = 'ref                                     // 3
  val `alt`                                     = 'alt                                     // 4

  val `aaref`                                   = 'aaref                                   // 5
  val `aaalt`                                   = 'aaalt                                   // 6

  val `rs_dbSNP151`                             = 'rs_dbSNP151                             // 7; eg rs1350406777;rs1203956874

  val `hg19_chr`                                = 'hg19_chr                                // 8
  val `hg19_pos(1-based)`                       = "hg19_pos(1-based)"                      // 9
  val `hg18_chr`                                = 'hg18_chr                                // 10
  val `hg18_pos(1-based)`                       = "hg18_pos(1-based)"                      // 11

  val `aapos`                                   = 'aapos                                   // 12
  val `genename`                                = 'genename                                // 13; eg CENPS-CORT;CENPS-CORT;CENPS-CORT;CENPS

  val `Ensembl_geneid`                          = 'Ensembl_geneid                          // 14
  val `Ensembl_transcriptid`                    = 'Ensembl_transcriptid                    // 15
  val `Ensembl_proteinid`                       = 'Ensembl_proteinid                       // 16

  val `Uniprot_acc`                             = 'Uniprot_acc                             // 17
  val `Uniprot_entry`                           = 'Uniprot_entry                           // 18; eg INT11_HUMAN;INT11_HUMAN;A0A087WYI0_HUMAN;INT11_HUMAN;C9IYS7_HUMAN;INT11_HUMAN;E9PNH9_HUMAN;E9PI75_HUMAN;E9PIG1_HUMAN

  // ===========================================================================
  // HGVS
  val `HGVSc_ANNOVAR`                           = 'HGVSc_ANNOVAR                           // 19
  val `HGVSp_ANNOVAR`                           = 'HGVSp_ANNOVAR                           // 20

  val `HGVSc_snpEff`                            = 'HGVSc_snpEff                            // 21
  val `HGVSp_snpEff`                            = 'HGVSp_snpEff                            // 22

  val `HGVSc_VEP`                               = 'HGVSc_VEP                               // 23
  val `HGVSp_VEP`                               = 'HGVSp_VEP                               // 24

  // ===========================================================================
  val `APPRIS`                                  = 'APPRIS                                  // 25; eg .;.;principal2;alternative2;alternative2;.;.;alternative2;alternative2;.;alternative2

  val `GENCODE_basic`                           = 'GENCODE_basic                           // 26

  val `TSL`                                     = 'TSL                                     // 27; eg 1;5;5;1

  val `VEP_canonical`                           = 'VEP_canonical                           // 28

  val `cds_strand`                              = 'cds_strand                              // 29

  // codon
  val `refcodon`                                = 'refcodon                                // 30
  val `codonpos`                                = 'codonpos                                // 31
  val `codon_degeneracy`                        = 'codon_degeneracy                        // 32

  // allele
  val `Ancestral_allele`                        = 'Ancestral_allele                        // 33

  // genotypes
  val `AltaiNeandertal`                         = 'AltaiNeandertal                         // 34
  val `Denisova`                                = 'Denisova                                // 35
  val `VindijiaNeandertal`                      = 'VindijiaNeandertal                      // 36

  val `SIFT_score`                              = 'SIFT_score                              // 37
  val `SIFT_converted_rankscore`                = 'SIFT_converted_rankscore                // 38
  val `SIFT_pred`                               = 'SIFT_pred                               // 39

  val `SIFT4G_score`                            = 'SIFT4G_score                            // 40
  val `SIFT4G_converted_rankscore`              = 'SIFT4G_converted_rankscore              // 41
  val `SIFT4G_pred`                             = 'SIFT4G_pred                             // 42

  val `Polyphen2_HDIV_score`                    = 'Polyphen2_HDIV_score                    // 43
  val `Polyphen2_HDIV_rankscore`                = 'Polyphen2_HDIV_rankscore                // 44
  val `Polyphen2_HDIV_pred`                     = 'Polyphen2_HDIV_pred                     // 45

  val `Polyphen2_HVAR_score`                    = 'Polyphen2_HVAR_score                    // 46
  val `Polyphen2_HVAR_rankscore`                = 'Polyphen2_HVAR_rankscore                // 47
  val `Polyphen2_HVAR_pred`                     = 'Polyphen2_HVAR_pred                     // 48

  val `LRT_score`                               = 'LRT_score                               // 49
  val `LRT_converted_rankscore`                 = 'LRT_converted_rankscore                 // 50
  val `LRT_pred`                                = 'LRT_pred                                // 51
  val `LRT_Omega`                               = 'LRT_Omega                               // 52

  val `MutationTaster_score`                    = 'MutationTaster_score                    // 53
  val `MutationTaster_converted_rankscore`      = 'MutationTaster_converted_rankscore      // 54
  val `MutationTaster_pred`                     = 'MutationTaster_pred                     // 55
  val `MutationTaster_model`                    = 'MutationTaster_model                    // 56
  val `MutationTaster_AAE`                      = 'MutationTaster_AAE                      // 57

  // no more: MutationAssessor_UniprotID
  // no more: MutationAssessor_variant
  val `MutationAssessor_score`                  = 'MutationAssessor_score                  // 58
  val `MutationAssessor_rankscore`              = 'MutationAssessor_rankscore              // 59
  val `MutationAssessor_pred`                   = 'MutationAssessor_pred                   // 60

  // see more fathmm below
  val `FATHMM_score`                            = 'FATHMM_score                            // 61
  val `FATHMM_converted_rankscore`              = 'FATHMM_converted_rankscore              // 62
  val `FATHMM_pred`                             = 'FATHMM_pred                             // 63

  val `PROVEAN_score`                           = 'PROVEAN_score                           // 64
  val `PROVEAN_converted_rankscore`             = 'PROVEAN_converted_rankscore             // 65
  val `PROVEAN_pred`                            = 'PROVEAN_pred                            // 66

  val `VEST4_score`                             = 'VEST4_score                             // 67
  val `VEST4_rankscore`                         = 'VEST4_rankscore                         // 68

  val `MetaSVM_score`                           = 'MetaSVM_score                           // 69
  val `MetaSVM_rankscore`                       = 'MetaSVM_rankscore                       // 70
  val `MetaSVM_pred`                            = 'MetaSVM_pred                            // 71

  val `MetaLR_score`                            = 'MetaLR_score                            // 72
  val `MetaLR_rankscore`                        = 'MetaLR_rankscore                        // 73
  val `MetaLR_pred`                             = 'MetaLR_pred                             // 74

  val `Reliability_index`                       = 'Reliability_index                       // 75

  val `M-CAP_score`                             = "M-CAP_score"                             // 76
  val `M-CAP_rankscore`                         = "M-CAP_rankscore"                         // 77
  val `M-CAP_pred`                              = "M-CAP_pred"                              // 78

  val `REVEL_score`                             = 'REVEL_score                             // 79
  val `REVEL_rankscore`                         = 'REVEL_rankscore                         // 80

  val `MutPred_score`                           = 'MutPred_score                           // 81
  val `MutPred_rankscore`                       = 'MutPred_rankscore                       // 82
  val `MutPred_protID`                          = 'MutPred_protID                          // 83; eg P05161, O00468, ENST00000453464, Q96HA4, ...
  val `MutPred_AAchange`                        = 'MutPred_AAchange                        // 84

  val `MutPred_Top5features`                    = 'MutPred_Top5features                    // 85

  val `MVP_score`                               = 'MVP_score                               // 86
  val `MVP_rankscore`                           = 'MVP_rankscore                           // 87

  val `MPC_score`                               = 'MPC_score                               // 88
  val `MPC_rankscore`                           = 'MPC_rankscore                           // 89

  val `PrimateAI_score`                         = 'PrimateAI_score                         // 90
  val `PrimateAI_rankscore`                     = 'PrimateAI_rankscore                     // 91
  val `PrimateAI_pred`                          = 'PrimateAI_pred                          // 92

  val `DEOGEN2_score`                           = 'DEOGEN2_score                           // 93
  val `DEOGEN2_rankscore`                       = 'DEOGEN2_rankscore                       // 94
  val `DEOGEN2_pred`                            = 'DEOGEN2_pred                            // 95

  val `Aloft_Fraction_transcripts_affected`     = 'Aloft_Fraction_transcripts_affected     // 96
  val `Aloft_prob_Tolerant`                     = 'Aloft_prob_Tolerant                     // 97
  val `Aloft_prob_Recessive`                    = 'Aloft_prob_Recessive                    // 98
  val `Aloft_prob_Dominant`                     = 'Aloft_prob_Dominant                     // 99
  val `Aloft_pred`                              = 'Aloft_pred                              // 100
  val `Aloft_Confidence`                        = 'Aloft_Confidence                        // 101

  val `CADD_raw`                                = 'CADD_raw                                // 102
  val `CADD_raw_rankscore`                      = 'CADD_raw_rankscore                      // 103
  val `CADD_phred`                              = 'CADD_phred                              // 104

  val `DANN_score`                              = 'DANN_score                              // 105
  val `DANN_rankscore`                          = 'DANN_rankscore                          // 106

  // ---------------------------------------------------------------------------
  val `fathmm-MKL_coding_score`                 = "fathmm-MKL_coding_score"                 // 107
  val `fathmm-MKL_coding_rankscore`             = "fathmm-MKL_coding_rankscore"             // 108
  val `fathmm-MKL_coding_pred`                  = "fathmm-MKL_coding_pred"                  // 109
  val `fathmm-MKL_coding_group`                 = "fathmm-MKL_coding_group"                 // 110

  val `fathmm-XF_coding_score`                  = "fathmm-XF_coding_score"                  // 111
  val `fathmm-XF_coding_rankscore`              = "fathmm-XF_coding_rankscore"              // 112
  val `fathmm-XF_coding_pred`                   = "fathmm-XF_coding_pred"                   // 113

  // ---------------------------------------------------------------------------
  // Eigen

  val `Eigen-raw_coding`                        = "Eigen-raw_coding"                        // 114
  val `Eigen-raw_coding_rankscore`              = "Eigen-raw_coding_rankscore"              // 115
  val `Eigen-pred_coding`                       = "Eigen-pred_coding"                       // 116

  val `Eigen-PC-raw_coding`                     = "Eigen-PC-raw_coding"                     // 117
  val `Eigen-PC-raw_coding_rankscore`           = "Eigen-PC-raw_coding_rankscore"           // 118
  val `Eigen-PC-phred_coding`                   = "Eigen-PC-phred_coding"                   // 119

  // ---------------------------------------------------------------------------
  val `GenoCanyon_score`                        = 'GenoCanyon_score                        // 120
  val `GenoCanyon_rankscore`                    = 'GenoCanyon_rankscore                    // 121

  // ---------------------------------------------------------------------------
  val `integrated_fitCons_score`                = 'integrated_fitCons_score                // 122
  val `integrated_fitCons_rankscore`            = 'integrated_fitCons_rankscore            // 123

  val `integrated_confidence_value`             = 'integrated_confidence_value             // 124

  // ---------------------------------------------------------------------------
  val `GM12878_fitCons_score`                   = 'GM12878_fitCons_score                   // 125
  val `GM12878_fitCons_rankscore`               = 'GM12878_fitCons_rankscore               // 126
  val `GM12878_confidence_value`                = 'GM12878_confidence_value                // 127

  val `H1-hESC_fitCons_score`                   = "H1-hESC_fitCons_score"                   // 128
  val `H1-hESC_fitCons_rankscore`               = "H1-hESC_fitCons_rankscore"               // 129
  val `H1-hESC_confidence_value`                = "H1-hESC_confidence_value"                // 130

  val `HUVEC_fitCons_score`                     = 'HUVEC_fitCons_score                     // 131
  val `HUVEC_fitCons_rankscore`                 = 'HUVEC_fitCons_rankscore                 // 132
  val `HUVEC_confidence_value`                  = 'HUVEC_confidence_value                  // 133

  val `LINSIGHT`                                = 'LINSIGHT                                // 134
  val `LINSIGHT_rankscore`                      = 'LINSIGHT_rankscore                      // 135

  val `GERP++_NR`                               = "GERP++_NR"                               // 136
  val `GERP++_RS`                               = "GERP++_RS"                               // 137
  val `GERP++_RS_rankscore`                     = "GERP++_RS_rankscore"                     // 138

  // ===========================================================================
  // phyloP
  val `phyloP100way_vertebrate`                 = 'phyloP100way_vertebrate                 // 139
  val `phyloP100way_vertebrate_rankscore`       = 'phyloP100way_vertebrate_rankscore       // 140

  val `phyloP30way_mammalian`                   = 'phyloP30way_mammalian                   // 141
  val `phyloP30way_mammalian_rankscore`         = 'phyloP30way_mammalian_rankscore         // 142

  val `phyloP17way_primate`                     = 'phyloP17way_primate                     // 143
  val `phyloP17way_primate_rankscore`           = 'phyloP17way_primate_rankscore           // 144

  // ===========================================================================
  // phastCons
  val `phastCons100way_vertebrate`              = 'phastCons100way_vertebrate              // 145
  val `phastCons100way_vertebrate_rankscore`    = 'phastCons100way_vertebrate_rankscore    // 146

  val `phastCons30way_mammalian`                = 'phastCons30way_mammalian                // 147
  val `phastCons30way_mammalian_rankscore`      = 'phastCons30way_mammalian_rankscore      // 148

  val `phastCons17way_primate`                  = 'phastCons17way_primate                  // 149
  val `phastCons17way_primate_rankscore`        = 'phastCons17way_primate_rankscore        // 150

  // ===========================================================================
  val `SiPhy_29way_pi`                          = 'SiPhy_29way_pi                          // 151; eg 0.1595:0.2771:0.3171:0.2464
  val `SiPhy_29way_logOdds`                     = 'SiPhy_29way_logOdds                     // 152
  val `SiPhy_29way_logOdds_rankscore`           = 'SiPhy_29way_logOdds_rankscore           // 153

  val `bStatistic`                              = 'bStatistic                              // 154
  val `bStatistic_rankscore`                    = 'bStatistic_rankscore                    // 155

  // ===========================================================================
  // 1000gp3
  val `1000Gp3_AC`                              = "1000Gp3_AC"                              // 156
  val `1000Gp3_AF`                              = "1000Gp3_AF"                              // 157
  val `1000Gp3_AFR_AC`                          = "1000Gp3_AFR_AC"                          // 158
  val `1000Gp3_AFR_AF`                          = "1000Gp3_AFR_AF"                          // 159
  val `1000Gp3_EUR_AC`                          = "1000Gp3_EUR_AC"                          // 160
  val `1000Gp3_EUR_AF`                          = "1000Gp3_EUR_AF"                          // 161
  val `1000Gp3_AMR_AC`                          = "1000Gp3_AMR_AC"                          // 162
  val `1000Gp3_AMR_AF`                          = "1000Gp3_AMR_AF"                          // 163
  val `1000Gp3_EAS_AC`                          = "1000Gp3_EAS_AC"                          // 164
  val `1000Gp3_EAS_AF`                          = "1000Gp3_EAS_AF"                          // 165
  val `1000Gp3_SAS_AC`                          = "1000Gp3_SAS_AC"                          // 166
  val `1000Gp3_SAS_AF`                          = "1000Gp3_SAS_AF"                          // 167

  // ===========================================================================
  val `TWINSUK_AC`                              = 'TWINSUK_AC                              // 168
  val `TWINSUK_AF`                              = 'TWINSUK_AF                              // 169

  val `ALSPAC_AC`                               = 'ALSPAC_AC                               // 170
  val `ALSPAC_AF`                               = 'ALSPAC_AF                               // 171

  val `UK10K_AC`                                = 'UK10K_AC                                // 172
  val `UK10K_AF`                                = 'UK10K_AF                                // 173

  // ===========================================================================
  // ESP

  val `ESP6500_AA_AC`                           = 'ESP6500_AA_AC                           // 174
  val `ESP6500_AA_AF`                           = 'ESP6500_AA_AF                           // 175
  val `ESP6500_EA_AC`                           = 'ESP6500_EA_AC                           // 176
  val `ESP6500_EA_AF`                           = 'ESP6500_EA_AF                           // 177

  // ===========================================================================
  // ExAC

  val `ExAC_AC`                                 = 'ExAC_AC                                 // 178
  val `ExAC_AF`                                 = 'ExAC_AF                                 // 179

  val `ExAC_Adj_AC`                             = 'ExAC_Adj_AC                             // 180
  val `ExAC_Adj_AF`                             = 'ExAC_Adj_AF                             // 181


  val `ExAC_AFR_AC`                             = 'ExAC_AFR_AC                             // 182
  val `ExAC_AFR_AF`                             = 'ExAC_AFR_AF                             // 183

  val `ExAC_AMR_AC`                             = 'ExAC_AMR_AC                             // 184
  val `ExAC_AMR_AF`                             = 'ExAC_AMR_AF                             // 185

  val `ExAC_EAS_AC`                             = 'ExAC_EAS_AC                             // 186
  val `ExAC_EAS_AF`                             = 'ExAC_EAS_AF                             // 187

  val `ExAC_FIN_AC`                             = 'ExAC_FIN_AC                             // 188
  val `ExAC_FIN_AF`                             = 'ExAC_FIN_AF                             // 189

  val `ExAC_NFE_AC`                             = 'ExAC_NFE_AC                             // 190
  val `ExAC_NFE_AF`                             = 'ExAC_NFE_AF                             // 191

  val `ExAC_SAS_AC`                             = 'ExAC_SAS_AC                             // 192
  val `ExAC_SAS_AF`                             = 'ExAC_SAS_AF                             // 193

  // ---------------------------------------------------------------------------
  val `ExAC_nonTCGA_AC`                         = 'ExAC_nonTCGA_AC                         // 194
  val `ExAC_nonTCGA_AF`                         = 'ExAC_nonTCGA_AF                         // 195


  val `ExAC_nonTCGA_Adj_AC`                     = 'ExAC_nonTCGA_Adj_AC                     // 196
  val `ExAC_nonTCGA_Adj_AF`                     = 'ExAC_nonTCGA_Adj_AF                     // 197


  val `ExAC_nonTCGA_AFR_AC`                     = 'ExAC_nonTCGA_AFR_AC                     // 198
  val `ExAC_nonTCGA_AFR_AF`                     = 'ExAC_nonTCGA_AFR_AF                     // 199

  val `ExAC_nonTCGA_AMR_AC`                     = 'ExAC_nonTCGA_AMR_AC                     // 200
  val `ExAC_nonTCGA_AMR_AF`                     = 'ExAC_nonTCGA_AMR_AF                     // 201

  val `ExAC_nonTCGA_EAS_AC`                     = 'ExAC_nonTCGA_EAS_AC                     // 202
  val `ExAC_nonTCGA_EAS_AF`                     = 'ExAC_nonTCGA_EAS_AF                     // 203

  val `ExAC_nonTCGA_FIN_AC`                     = 'ExAC_nonTCGA_FIN_AC                     // 204
  val `ExAC_nonTCGA_FIN_AF`                     = 'ExAC_nonTCGA_FIN_AF                     // 205

  val `ExAC_nonTCGA_NFE_AC`                     = 'ExAC_nonTCGA_NFE_AC                     // 206
  val `ExAC_nonTCGA_NFE_AF`                     = 'ExAC_nonTCGA_NFE_AF                     // 207

  val `ExAC_nonTCGA_SAS_AC`                     = 'ExAC_nonTCGA_SAS_AC                     // 208
  val `ExAC_nonTCGA_SAS_AF`                     = 'ExAC_nonTCGA_SAS_AF                     // 209

  // ---------------------------------------------------------------------------
  val `ExAC_nonpsych_AC`                        = 'ExAC_nonpsych_AC                        // 210
  val `ExAC_nonpsych_AF`                        = 'ExAC_nonpsych_AF                        // 211


  val `ExAC_nonpsych_Adj_AC`                    = 'ExAC_nonpsych_Adj_AC                    // 212
  val `ExAC_nonpsych_Adj_AF`                    = 'ExAC_nonpsych_Adj_AF                    // 213


  val `ExAC_nonpsych_AFR_AC`                    = 'ExAC_nonpsych_AFR_AC                    // 214
  val `ExAC_nonpsych_AFR_AF`                    = 'ExAC_nonpsych_AFR_AF                    // 215

  val `ExAC_nonpsych_AMR_AC`                    = 'ExAC_nonpsych_AMR_AC                    // 216
  val `ExAC_nonpsych_AMR_AF`                    = 'ExAC_nonpsych_AMR_AF                    // 217

  val `ExAC_nonpsych_EAS_AC`                    = 'ExAC_nonpsych_EAS_AC                    // 218
  val `ExAC_nonpsych_EAS_AF`                    = 'ExAC_nonpsych_EAS_AF                    // 219

  val `ExAC_nonpsych_FIN_AC`                    = 'ExAC_nonpsych_FIN_AC                    // 220
  val `ExAC_nonpsych_FIN_AF`                    = 'ExAC_nonpsych_FIN_AF                    // 221

  val `ExAC_nonpsych_NFE_AC`                    = 'ExAC_nonpsych_NFE_AC                    // 222
  val `ExAC_nonpsych_NFE_AF`                    = 'ExAC_nonpsych_NFE_AF                    // 223

  val `ExAC_nonpsych_SAS_AC`                    = 'ExAC_nonpsych_SAS_AC                    // 224
  val `ExAC_nonpsych_SAS_AF`                    = 'ExAC_nonpsych_SAS_AF                    // 225

  // ===========================================================================
  // gnomAD

  val `gnomAD_exomes_flag`                      = 'gnomAD_exomes_flag                      // 226; eg segdup;decoy

  val `gnomAD_exomes_AC`                        = 'gnomAD_exomes_AC                        // 227
  val `gnomAD_exomes_AN`                        = 'gnomAD_exomes_AN                        // 228
  val `gnomAD_exomes_AF`                        = 'gnomAD_exomes_AF                        // 229
  val `gnomAD_exomes_nhomalt`                   = 'gnomAD_exomes_nhomalt                   // 230
  val `gnomAD_exomes_AFR_AC`                    = 'gnomAD_exomes_AFR_AC                    // 231
  val `gnomAD_exomes_AFR_AN`                    = 'gnomAD_exomes_AFR_AN                    // 232
  val `gnomAD_exomes_AFR_AF`                    = 'gnomAD_exomes_AFR_AF                    // 233
  val `gnomAD_exomes_AFR_nhomalt`               = 'gnomAD_exomes_AFR_nhomalt               // 234
  val `gnomAD_exomes_AMR_AC`                    = 'gnomAD_exomes_AMR_AC                    // 235
  val `gnomAD_exomes_AMR_AN`                    = 'gnomAD_exomes_AMR_AN                    // 236
  val `gnomAD_exomes_AMR_AF`                    = 'gnomAD_exomes_AMR_AF                    // 237
  val `gnomAD_exomes_AMR_nhomalt`               = 'gnomAD_exomes_AMR_nhomalt               // 238
  val `gnomAD_exomes_ASJ_AC`                    = 'gnomAD_exomes_ASJ_AC                    // 239
  val `gnomAD_exomes_ASJ_AN`                    = 'gnomAD_exomes_ASJ_AN                    // 240
  val `gnomAD_exomes_ASJ_AF`                    = 'gnomAD_exomes_ASJ_AF                    // 241
  val `gnomAD_exomes_ASJ_nhomalt`               = 'gnomAD_exomes_ASJ_nhomalt               // 242
  val `gnomAD_exomes_EAS_AC`                    = 'gnomAD_exomes_EAS_AC                    // 243
  val `gnomAD_exomes_EAS_AN`                    = 'gnomAD_exomes_EAS_AN                    // 244
  val `gnomAD_exomes_EAS_AF`                    = 'gnomAD_exomes_EAS_AF                    // 245
  val `gnomAD_exomes_EAS_nhomalt`               = 'gnomAD_exomes_EAS_nhomalt               // 246
  val `gnomAD_exomes_FIN_AC`                    = 'gnomAD_exomes_FIN_AC                    // 247
  val `gnomAD_exomes_FIN_AN`                    = 'gnomAD_exomes_FIN_AN                    // 248
  val `gnomAD_exomes_FIN_AF`                    = 'gnomAD_exomes_FIN_AF                    // 249
  val `gnomAD_exomes_FIN_nhomalt`               = 'gnomAD_exomes_FIN_nhomalt               // 250
  val `gnomAD_exomes_NFE_AC`                    = 'gnomAD_exomes_NFE_AC                    // 251
  val `gnomAD_exomes_NFE_AN`                    = 'gnomAD_exomes_NFE_AN                    // 252
  val `gnomAD_exomes_NFE_AF`                    = 'gnomAD_exomes_NFE_AF                    // 253
  val `gnomAD_exomes_NFE_nhomalt`               = 'gnomAD_exomes_NFE_nhomalt               // 254
  val `gnomAD_exomes_SAS_AC`                    = 'gnomAD_exomes_SAS_AC                    // 255
  val `gnomAD_exomes_SAS_AN`                    = 'gnomAD_exomes_SAS_AN                    // 256
  val `gnomAD_exomes_SAS_AF`                    = 'gnomAD_exomes_SAS_AF                    // 257
  val `gnomAD_exomes_SAS_nhomalt`               = 'gnomAD_exomes_SAS_nhomalt               // 258
  val `gnomAD_exomes_POPMAX_AC`                 = 'gnomAD_exomes_POPMAX_AC                 // 259
  val `gnomAD_exomes_POPMAX_AN`                 = 'gnomAD_exomes_POPMAX_AN                 // 260
  val `gnomAD_exomes_POPMAX_AF`                 = 'gnomAD_exomes_POPMAX_AF                 // 261
  val `gnomAD_exomes_POPMAX_nhomalt`            = 'gnomAD_exomes_POPMAX_nhomalt            // 262
  val `gnomAD_exomes_controls_AC`               = 'gnomAD_exomes_controls_AC               // 263
  val `gnomAD_exomes_controls_AN`               = 'gnomAD_exomes_controls_AN               // 264
  val `gnomAD_exomes_controls_AF`               = 'gnomAD_exomes_controls_AF               // 265
  val `gnomAD_exomes_controls_nhomalt`          = 'gnomAD_exomes_controls_nhomalt          // 266
  val `gnomAD_exomes_controls_AFR_AC`           = 'gnomAD_exomes_controls_AFR_AC           // 267
  val `gnomAD_exomes_controls_AFR_AN`           = 'gnomAD_exomes_controls_AFR_AN           // 268
  val `gnomAD_exomes_controls_AFR_AF`           = 'gnomAD_exomes_controls_AFR_AF           // 269
  val `gnomAD_exomes_controls_AFR_nhomalt`      = 'gnomAD_exomes_controls_AFR_nhomalt      // 270
  val `gnomAD_exomes_controls_AMR_AC`           = 'gnomAD_exomes_controls_AMR_AC           // 271
  val `gnomAD_exomes_controls_AMR_AN`           = 'gnomAD_exomes_controls_AMR_AN           // 272
  val `gnomAD_exomes_controls_AMR_AF`           = 'gnomAD_exomes_controls_AMR_AF           // 273
  val `gnomAD_exomes_controls_AMR_nhomalt`      = 'gnomAD_exomes_controls_AMR_nhomalt      // 274
  val `gnomAD_exomes_controls_ASJ_AC`           = 'gnomAD_exomes_controls_ASJ_AC           // 275
  val `gnomAD_exomes_controls_ASJ_AN`           = 'gnomAD_exomes_controls_ASJ_AN           // 276
  val `gnomAD_exomes_controls_ASJ_AF`           = 'gnomAD_exomes_controls_ASJ_AF           // 277
  val `gnomAD_exomes_controls_ASJ_nhomalt`      = 'gnomAD_exomes_controls_ASJ_nhomalt      // 278
  val `gnomAD_exomes_controls_EAS_AC`           = 'gnomAD_exomes_controls_EAS_AC           // 279
  val `gnomAD_exomes_controls_EAS_AN`           = 'gnomAD_exomes_controls_EAS_AN           // 280
  val `gnomAD_exomes_controls_EAS_AF`           = 'gnomAD_exomes_controls_EAS_AF           // 281
  val `gnomAD_exomes_controls_EAS_nhomalt`      = 'gnomAD_exomes_controls_EAS_nhomalt      // 282
  val `gnomAD_exomes_controls_FIN_AC`           = 'gnomAD_exomes_controls_FIN_AC           // 283
  val `gnomAD_exomes_controls_FIN_AN`           = 'gnomAD_exomes_controls_FIN_AN           // 284
  val `gnomAD_exomes_controls_FIN_AF`           = 'gnomAD_exomes_controls_FIN_AF           // 285
  val `gnomAD_exomes_controls_FIN_nhomalt`      = 'gnomAD_exomes_controls_FIN_nhomalt      // 286
  val `gnomAD_exomes_controls_NFE_AC`           = 'gnomAD_exomes_controls_NFE_AC           // 287
  val `gnomAD_exomes_controls_NFE_AN`           = 'gnomAD_exomes_controls_NFE_AN           // 288
  val `gnomAD_exomes_controls_NFE_AF`           = 'gnomAD_exomes_controls_NFE_AF           // 289
  val `gnomAD_exomes_controls_NFE_nhomalt`      = 'gnomAD_exomes_controls_NFE_nhomalt      // 290
  val `gnomAD_exomes_controls_SAS_AC`           = 'gnomAD_exomes_controls_SAS_AC           // 291
  val `gnomAD_exomes_controls_SAS_AN`           = 'gnomAD_exomes_controls_SAS_AN           // 292
  val `gnomAD_exomes_controls_SAS_AF`           = 'gnomAD_exomes_controls_SAS_AF           // 293
  val `gnomAD_exomes_controls_SAS_nhomalt`      = 'gnomAD_exomes_controls_SAS_nhomalt      // 294
  val `gnomAD_exomes_controls_POPMAX_AC`        = 'gnomAD_exomes_controls_POPMAX_AC        // 295
  val `gnomAD_exomes_controls_POPMAX_AN`        = 'gnomAD_exomes_controls_POPMAX_AN        // 296
  val `gnomAD_exomes_controls_POPMAX_AF`        = 'gnomAD_exomes_controls_POPMAX_AF        // 297
  val `gnomAD_exomes_controls_POPMAX_nhomalt`   = 'gnomAD_exomes_controls_POPMAX_nhomalt   // 298

  // ---------------------------------------------------------------------------
  val `gnomAD_genomes_flag`                     = 'gnomAD_genomes_flag                     // 299; eg segdup;decoy

  val `gnomAD_genomes_AC`                       = 'gnomAD_genomes_AC                       // 300
  val `gnomAD_genomes_AN`                       = 'gnomAD_genomes_AN                       // 301
  val `gnomAD_genomes_AF`                       = 'gnomAD_genomes_AF                       // 302
  val `gnomAD_genomes_nhomalt`                  = 'gnomAD_genomes_nhomalt                  // 303
  val `gnomAD_genomes_AFR_AC`                   = 'gnomAD_genomes_AFR_AC                   // 304
  val `gnomAD_genomes_AFR_AN`                   = 'gnomAD_genomes_AFR_AN                   // 305
  val `gnomAD_genomes_AFR_AF`                   = 'gnomAD_genomes_AFR_AF                   // 306
  val `gnomAD_genomes_AFR_nhomalt`              = 'gnomAD_genomes_AFR_nhomalt              // 307
  val `gnomAD_genomes_AMR_AC`                   = 'gnomAD_genomes_AMR_AC                   // 308
  val `gnomAD_genomes_AMR_AN`                   = 'gnomAD_genomes_AMR_AN                   // 309
  val `gnomAD_genomes_AMR_AF`                   = 'gnomAD_genomes_AMR_AF                   // 310
  val `gnomAD_genomes_AMR_nhomalt`              = 'gnomAD_genomes_AMR_nhomalt              // 311
  val `gnomAD_genomes_ASJ_AC`                   = 'gnomAD_genomes_ASJ_AC                   // 312
  val `gnomAD_genomes_ASJ_AN`                   = 'gnomAD_genomes_ASJ_AN                   // 313
  val `gnomAD_genomes_ASJ_AF`                   = 'gnomAD_genomes_ASJ_AF                   // 314
  val `gnomAD_genomes_ASJ_nhomalt`              = 'gnomAD_genomes_ASJ_nhomalt              // 315
  val `gnomAD_genomes_EAS_AC`                   = 'gnomAD_genomes_EAS_AC                   // 316
  val `gnomAD_genomes_EAS_AN`                   = 'gnomAD_genomes_EAS_AN                   // 317
  val `gnomAD_genomes_EAS_AF`                   = 'gnomAD_genomes_EAS_AF                   // 318
  val `gnomAD_genomes_EAS_nhomalt`              = 'gnomAD_genomes_EAS_nhomalt              // 319
  val `gnomAD_genomes_FIN_AC`                   = 'gnomAD_genomes_FIN_AC                   // 320
  val `gnomAD_genomes_FIN_AN`                   = 'gnomAD_genomes_FIN_AN                   // 321
  val `gnomAD_genomes_FIN_AF`                   = 'gnomAD_genomes_FIN_AF                   // 322
  val `gnomAD_genomes_FIN_nhomalt`              = 'gnomAD_genomes_FIN_nhomalt              // 323
  val `gnomAD_genomes_NFE_AC`                   = 'gnomAD_genomes_NFE_AC                   // 324
  val `gnomAD_genomes_NFE_AN`                   = 'gnomAD_genomes_NFE_AN                   // 325
  val `gnomAD_genomes_NFE_AF`                   = 'gnomAD_genomes_NFE_AF                   // 326
  val `gnomAD_genomes_NFE_nhomalt`              = 'gnomAD_genomes_NFE_nhomalt              // 327
  val `gnomAD_genomes_POPMAX_AC`                = 'gnomAD_genomes_POPMAX_AC                // 328
  val `gnomAD_genomes_POPMAX_AN`                = 'gnomAD_genomes_POPMAX_AN                // 329
  val `gnomAD_genomes_POPMAX_AF`                = 'gnomAD_genomes_POPMAX_AF                // 330
  val `gnomAD_genomes_POPMAX_nhomalt`           = 'gnomAD_genomes_POPMAX_nhomalt           // 331
  val `gnomAD_genomes_controls_AC`              = 'gnomAD_genomes_controls_AC              // 332
  val `gnomAD_genomes_controls_AN`              = 'gnomAD_genomes_controls_AN              // 333
  val `gnomAD_genomes_controls_AF`              = 'gnomAD_genomes_controls_AF              // 334
  val `gnomAD_genomes_controls_nhomalt`         = 'gnomAD_genomes_controls_nhomalt         // 335
  val `gnomAD_genomes_controls_AFR_AC`          = 'gnomAD_genomes_controls_AFR_AC          // 336
  val `gnomAD_genomes_controls_AFR_AN`          = 'gnomAD_genomes_controls_AFR_AN          // 337
  val `gnomAD_genomes_controls_AFR_AF`          = 'gnomAD_genomes_controls_AFR_AF          // 338
  val `gnomAD_genomes_controls_AFR_nhomalt`     = 'gnomAD_genomes_controls_AFR_nhomalt     // 339
  val `gnomAD_genomes_controls_AMR_AC`          = 'gnomAD_genomes_controls_AMR_AC          // 340
  val `gnomAD_genomes_controls_AMR_AN`          = 'gnomAD_genomes_controls_AMR_AN          // 341
  val `gnomAD_genomes_controls_AMR_AF`          = 'gnomAD_genomes_controls_AMR_AF          // 342
  val `gnomAD_genomes_controls_AMR_nhomalt`     = 'gnomAD_genomes_controls_AMR_nhomalt     // 343
  val `gnomAD_genomes_controls_ASJ_AC`          = 'gnomAD_genomes_controls_ASJ_AC          // 344
  val `gnomAD_genomes_controls_ASJ_AN`          = 'gnomAD_genomes_controls_ASJ_AN          // 345
  val `gnomAD_genomes_controls_ASJ_AF`          = 'gnomAD_genomes_controls_ASJ_AF          // 346
  val `gnomAD_genomes_controls_ASJ_nhomalt`     = 'gnomAD_genomes_controls_ASJ_nhomalt     // 347
  val `gnomAD_genomes_controls_EAS_AC`          = 'gnomAD_genomes_controls_EAS_AC          // 348
  val `gnomAD_genomes_controls_EAS_AN`          = 'gnomAD_genomes_controls_EAS_AN          // 349
  val `gnomAD_genomes_controls_EAS_AF`          = 'gnomAD_genomes_controls_EAS_AF          // 350
  val `gnomAD_genomes_controls_EAS_nhomalt`     = 'gnomAD_genomes_controls_EAS_nhomalt     // 351
  val `gnomAD_genomes_controls_FIN_AC`          = 'gnomAD_genomes_controls_FIN_AC          // 352
  val `gnomAD_genomes_controls_FIN_AN`          = 'gnomAD_genomes_controls_FIN_AN          // 353
  val `gnomAD_genomes_controls_FIN_AF`          = 'gnomAD_genomes_controls_FIN_AF          // 354
  val `gnomAD_genomes_controls_FIN_nhomalt`     = 'gnomAD_genomes_controls_FIN_nhomalt     // 355
  val `gnomAD_genomes_controls_NFE_AC`          = 'gnomAD_genomes_controls_NFE_AC          // 356
  val `gnomAD_genomes_controls_NFE_AN`          = 'gnomAD_genomes_controls_NFE_AN          // 357
  val `gnomAD_genomes_controls_NFE_AF`          = 'gnomAD_genomes_controls_NFE_AF          // 358
  val `gnomAD_genomes_controls_NFE_nhomalt`     = 'gnomAD_genomes_controls_NFE_nhomalt     // 359
  val `gnomAD_genomes_controls_POPMAX_AC`       = 'gnomAD_genomes_controls_POPMAX_AC       // 360
  val `gnomAD_genomes_controls_POPMAX_AN`       = 'gnomAD_genomes_controls_POPMAX_AN       // 361
  val `gnomAD_genomes_controls_POPMAX_AF`       = 'gnomAD_genomes_controls_POPMAX_AF       // 362
  val `gnomAD_genomes_controls_POPMAX_nhomalt`  = 'gnomAD_genomes_controls_POPMAX_nhomalt  // 363

  // ===========================================================================
  // clinvar

  val `clinvar_id`                              = 'clinvar_id                              // 364
  val `clinvar_clnsig`                          = 'clinvar_clnsig                          // 365
  val `clinvar_trait`                           = 'clinvar_trait                           // 366
  val `clinvar_review`                          = 'clinvar_review                          // 367
    //19     reviewed_by_expert_panel
    //34     no_interpretation_for_the_single_variant
    //550    no_assertion_provided
    //772    criteria_provided,_conflicting_interpretations
    //1996   no_assertion_criteria_provided
    //2364   criteria_provided,_multiple_submitters,_no_conflicts
    //10487  criteria_provided,_single_submitter
    //15711  null

  val `clinvar_hgvs`                            = 'clinvar_hgvs                            // 368
  val `clinvar_var_source`                      = 'clinvar_var_source                      // 369; eg: ARUP_Laboratories,_Molecular_Genetics_and_Genomics,ARUP_Laboratories:108347|Illumina_Clinical_Services_Laboratory,Illumina:4319
  val `clinvar_MedGen_id`                       = 'clinvar_MedGen_id                       // 370
  val `clinvar_OMIM_id`                         = 'clinvar_OMIM_id                         // 371
  val `clinvar_Orphanet_id`                     = 'clinvar_Orphanet_id                     // 372

  // ===========================================================================
  /**
   * http://varianttools.sourceforge.net/Annotation/dbNSFP
   * domain or conserved site on which the variant locates
   *    Domain annotations come from Interpro database
   *    The number in the brackets following a specific domain
   *        is the count of times Interpro assigns the variant position to that domain
   *        typically coming from different predicting databases
   *    Multiple entries separated by ;.
   */
  val `Interpro_domain`                         = 'Interpro_domain                         // 373; eg Galactose oxidase, beta-propeller;Galactose oxidase, beta-propeller|Galactose oxidase/kelch, beta-propeller

  // ---------------------------------------------------------------------------
  // GTEx

  val `GTEx_V7_gene`                            = 'GTEx_V7_gene                            // 374
  val `GTEx_V7_tissue`                          = 'GTEx_V7_tissue                          // 375

  // ---------------------------------------------------------------------------
  val `Geuvadis_eQTL_target_gene`               = 'Geuvadis_eQTL_target_gene               // 376; eg ENSG00000187961, ENSG00000160803;ENSG00000163374;ENSG00000143537;ENSG00000116521;ENSG00000160752

}

// ===========================================================================
