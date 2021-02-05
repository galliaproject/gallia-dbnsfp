package galliaexample.dbnsfp

import aptus.{Anything_, String_}

// ===========================================================================
private object DbNsfpUtils {

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
