package ns.top

object DefaultSettings {
  def apply() = Map(
    "MemMapBase" -> 0x0000000000000000L,
    "MemMapRegionBits" -> 0,
    "MMIOBase" -> 0x0000000040000000L,
    "MMIOSize" -> 0x0000000040000000L,
    "ResetVector" -> 0x80000000L,
    "NrExtIntr" -> 1,

    "HasL2cache" -> true,
    "HasPrefetch" -> true,
    "EnableMultiIssue" -> false,
    "EnableOutOfOrderExec" -> false,
    "HasDTLB" -> true,
    "HasITLB" -> true,
    "HasDcache" -> true,
    "HasIcache" -> true,
    "MmodeOnly" -> false,
    "IsRV32" -> false,

    "FPGAPlatform" -> false,
    "EnableILA" -> true,
    "EnableDebug" -> true,
    "EnableRVC" -> true
  )
}

object PynqSettings {
  def apply() = Map(
    "FPGAPlatform" -> true,
    "NrExtIntr" -> 3,
    "ResetVector" -> 0x60000000L,
    "MemMapBase" -> 0x0000000010000000L,
    "MemMapRegionBits" -> 28,
    "MMIOBase" -> 0x00000000e0000000L,
    "MMIOSize" -> 0x0000000020000000L
  )
}

object Axu3cgSettings {
  def apply() = Map(
    "FPGAPlatform" -> true,
    "NrExtIntr" -> 2
  )
}

object PXIeSettings {
  def apply() = Map(
    "FPGAPlatform" -> true,
    "NrExtIntr" -> 5
  )
}

object OOOSettings {
  def apply() = Map(
    "EnableMultiIssue" -> true,
    "EnableOutOfOrderExec" -> true
  )
}

object InOrderSettings {
  def apply() = Map()
}

object EmbededSettings {
  def apply() = Map(
    "HasL2cache" -> false,
    "HasPrefetch" -> false,
    "HasDTLB" -> false,
    "HasITLB" -> false,
    "HasDcache" -> false,
    "HasIcache" -> false,
    "MmodeOnly" -> true,
    "IsRV32" -> true,
    "EnableRVC" -> false
  )
}

object Settings {
  var settings: Map[String, AnyVal] = DefaultSettings()
  def get(field: String) = {
    settings(field).asInstanceOf[Boolean]
  }
  def getLong(field: String) = {
    settings(field).asInstanceOf[Long]
  }
  def getInt(field: String) = {
    settings(field).asInstanceOf[Int]
  }
}