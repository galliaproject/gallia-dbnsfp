package galliaexample.dbnsfp

import aptus.{Anything_, String_}

// ===========================================================================
private object DbNsfpUtils {

  // dbNSFP4.Xa suitable for academic use, which includes all the resources, and dbNSFP4.Xc suitable for commercial use, which does not include Polyphen2, VEST, REVEL, CADD, LINSIGHT, and GenoCanyon. - see https://sites.google.com/site/jpopgen/dbNSFP
  def isAcademicUse: Boolean = "a" == DbNsfpDriver.InputFile.extractGroup(".*dbNSFP4.0([ac])_variant.+".regex).getOrElse(false)
  
  // ===========================================================================
  def normalizeClinvarReview(value: String): String =
    value
      .replace(
        "criteria_provided,_",
        "criteria_provided:")
      .replace(
        "multiple_submitters,_no_conflicts",
        "multiple_submitters,no_conflicts")

  // ---------------------------------------------------------------------------
  def splitInterproDomain(value: String): Seq[String] =
    value
        .assert(_.nonEmpty)
      .splitBy("|")
        .assert(_.nonEmpty)
        .assert(_.forall(_.nonEmpty))
      .distinct

}

// ===========================================================================
