package galliaexample.dbnsfp

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
            (location. isEmpty && change_type.isInstanceOf[Unlocated]) ||
            (location.nonEmpty && change_type.isInstanceOf[  Located]),
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
          raw.`type`     .uncapitalizeFirst.thn(MutPredType      .withName),
          raw.change_type                  .thn(MutPredChangeType.withName),
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
  sealed trait MutPredChangeType extends EnumEntry

      // ---------------------------------------------------------------------------
      object MutPredChangeType extends Enum[MutPredChangeType] {
        val values = Unlocated.values ++ Located.values
      }

    // ===========================================================================
    sealed trait Unlocated extends MutPredChangeType
      object Unlocated extends Enum[Unlocated] {
        val values = findValues

        // ---------------------------------------------------------------------------
        case object `MoRF binding`                   extends Unlocated
        case object `disorder`                       extends Unlocated
        case object `helix`                          extends Unlocated
        case object `loop`                           extends Unlocated
        case object `sheet`                          extends Unlocated
        case object `solvent accessibility`          extends Unlocated
        case object `relative solvent accessibility` extends Unlocated
        case object `stability`                      extends Unlocated
      }

    // ===========================================================================
    sealed trait Located extends MutPredChangeType
      object Located extends Enum[Located] {
        val values = findValues

        // ---------------------------------------------------------------------------
        case object `catalytic residue`              extends Located
        case object `glycosylation`                  extends Located
        case object `methylation`                    extends Located
        case object `phosphorylation`                extends Located
        case object `ubiquitination`                 extends Located
      }

}

// ===========================================================================
