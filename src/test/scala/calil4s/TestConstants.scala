package calil4s

import calil4s.models.{GeoLocation, LibrarySite}

/**
 * @author mao.instantlife at gmail.com
 */
object TestConstants {
  val siteOkayamaPref = LibrarySite("岡山県")
  val siteOkayamaCity = LibrarySite("岡山県", "岡山市")

  val geoOkayamaPrefLib = GeoLocation(34.6626, 133.934652)
}
