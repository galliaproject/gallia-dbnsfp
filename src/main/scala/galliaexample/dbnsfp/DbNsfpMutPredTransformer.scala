package galliaexample.dbnsfp

import scala.util.chaining._
import enumeratum.{Enum, EnumEntry}
import aptus.{Anything_, String_}

// ===========================================================================
object MutPredTransformer {

  def apply(value: String): Transformed =
    Raw
      .parseStringOpt(value)
      .map(Transformed.fromRaw)
      .getOrElse(throw new IllegalStateException(s"value=${value.quote}"))

  // ===========================================================================
  case class Raw(
       `type`      : String,
        change_type: String,
        location   : String,
        p_value    : String)

    // ===========================================================================
    object Raw {
      private val ExampleLine = "Gain of MoRF binding (P = 0); Gain of catalytic residue at E3 (P = 0.0258); Gain of ubiquitination at E3 (P = 0.068); Gain of glycosylation at S2 (P = 0.1145); Gain of methylation at E3 (P = 0.2221)"

      private val Part1 = "(Gain|Loss) of (.+)"                          // eg "Gain of catalytic residue"
      private val Part2 =                      "at (.+)"                 // eg "at E3"
      private val Part3 =                               "\\(P = (.+)\\)" // eg "(P = 0.0258)"

      private val Regex1 = (Part1 space Part2 space Part3).regex // eg for "Gain of catalytic residue at E3 (P = 0.0258)"
      private val Regex2 = (Part1 space             Part3).regex // eg for "Gain of MoRF binding (P = 0)"

      // ---------------------------------------------------------------------------
      def parseStringOpt(value: String): Option[Raw] =
        value
          .extractGroups(Regex1)
          .map { matches =>
            Raw(
              matches(0),
              matches(1),
              matches(2),
              matches(3))
          }
      .orElse {
        value
          .extractGroups(Regex2)
          .map { matches =>
            Raw(
              matches(0),
              matches(1),
              "",
              matches(2))
        } }
    }

  // ===========================================================================
  case class Transformed(
       `type`       : MutPredType,
        change_type : MutPredChangeType,
        location    : Option[String], // eg S336, L2, ...
        p_value     : Double)         // eg 0, 0.1145, ...
      extends gallia.HasToObj {

        require(p_value >= 0, this)
        require(
            (location. isEmpty && !change_type.located) ||
            (location.nonEmpty &&  change_type.located),
          this)

        // ---------------------------------------------------------------------------
        // TODO: t210110100144 - macros for case-class to/from Obj
        override def toObj =
          gallia.obj(
              'type       -> `type`      .entryName,
              'change_type -> change_type.entryName,
              'location    -> location,
              'p_value     -> p_value)
      }

    // ===========================================================================
    object Transformed {

      def fromRaw(raw: Raw): Transformed =
        Transformed(
          raw.`type`     .uncapitalizeFirst.pipe(MutPredType      .withName),
          raw.change_type                  .pipe(MutPredChangeType.withName),
          raw.location.in.noneIf(_.isEmpty),
          raw.p_value.toDouble )
    }

  // ===========================================================================
  sealed trait MutPredType extends EnumEntry
    object MutPredType extends Enum[MutPredType] {
      val values = findValues

      // ---------------------------------------------------------------------------
      case object gain extends MutPredType
      case object loss extends MutPredType
    }

  // ===========================================================================
  sealed trait MutPredChangeType extends EnumEntry { def located: Boolean }

    // ---------------------------------------------------------------------------
    object MutPredChangeType extends Enum[MutPredChangeType] {
      val values = findValues

      // ---------------------------------------------------------------------------
      case object `MoRF binding`                   extends MutPredChangeType { val located  = false }
      case object `disorder`                       extends MutPredChangeType { val located  = false }
      case object `helix`                          extends MutPredChangeType { val located  = false }
      case object `loop`                           extends MutPredChangeType { val located  = false }
      case object `sheet`                          extends MutPredChangeType { val located  = false }
      case object `solvent accessibility`          extends MutPredChangeType { val located  = false }
      case object `relative solvent accessibility` extends MutPredChangeType { val located  = false }
      case object `stability`                      extends MutPredChangeType { val located  = false }

      // ---------------------------------------------------------------------------
      case object `catalytic residue`              extends MutPredChangeType { val located  = true }
      case object `glycosylation`                  extends MutPredChangeType { val located  = true }
      case object `methylation`                    extends MutPredChangeType { val located  = true }
      case object `phosphorylation`                extends MutPredChangeType { val located  = true }
      case object `ubiquitination`                 extends MutPredChangeType { val located  = true }
    }

}

// ===========================================================================
