package galliaexample.dbnsfp

import aptus.{Anything_, String_}
import gallia._

// ===========================================================================
object DbNsfpRenesting {
  import DbNsfpInputFields._

  // ===========================================================================
  private val WayRegex = "(\\d+)way".regex

  // ---------------------------------------------------------------------------
  private val MissingScoreSuffix = Set[SKey](
     CADD_raw    .name,
    `GERP++_RS`,
     LINSIGHT    .name,
     bStatistic  .name,
     SiPhy_29way_logOdds.name)

  // ---------------------------------------------------------------------------
  private val WayExcerpts = Set[SKey]( // SiPhy_29way won't be affected
    "100way",
    "30way",
    "17way")

  // ===========================================================================
  def geneObjectRuleBasedRenamings(key: SKey): SKey =
         if (key.endsWith("_pred")) key.append("iction")
    else if (key.contains("HGVSc")) key.replace("HGVSc", "HGVS_c")
    else if (key.contains("HGVSp")) key.replace("HGVSp", "HGVS_p")
    else                            key

  // ---------------------------------------------------------------------------
  def rootObjectRuleBasedRenamings(key: SKey): SKey =
         if (key.endsWith("_pred"            )) key.append("iction")
    else if (key.endsWith("_confidence_value")) key.stripSuffix("_value")

    // order matters
    // eg: "SiPhy_29way_logOdds_rankscore" -> "rankscores_SiPhy_29way_logOdds"
    else if (key.endsWith("_converted_rankscore")) "rankscores_converted_".append(key.replace("_converted_rankscore", ""))
    else if (key.endsWith(          "_rankscore")) "rankscores_"          .append(key.replace(          "_rankscore", ""))

    else if (key.containedIn(MissingScoreSuffix)) key.append("_score")
    else if (WayExcerpts.exists(key.contains))    WayRegex.replaceAllIn(key, "_$1way")
    else                                          key

}

// ===========================================================================
