package calil4s.api

import calil4s.TestConstants._
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * @author mao.instantlife at gmail.com
 */
class LibrarySearchRequesterTest extends ApiRequestTestBase {
  val baseApiUrl = "https://api.calil.jp/library"

  "BySiteLibrarySearcher.requestUrl(LibrarySite, AppKey)" should {
    "returns query url with pref only condition" in {
      BySiteLibrarySearcher.requestUrl(siteOkayamaPref, "test-app-key") assert
        s"pref=${encode(siteOkayamaPref.pref)}"
    }

    "returns query url with pref and city condition" in {
      BySiteLibrarySearcher.requestUrl(siteOkayamaCity, "test-app-key") assert (
        s"pref=${encode(siteOkayamaCity.pref)}",
        s"city=${encode(siteOkayamaCity.city)}")
    }
  }

  "ByGeoLocationLibrarySearcher.requestUrl(GeoLocation, AppKey)" should {
    "returns query url with geo condition" in {
      ByGeoLocationLibrarySearcher.requestUrl(geoOkayamaPrefLib, "test-app-key") assert
        s"geocode=${geoOkayamaPrefLib.longitude}%2C${geoOkayamaPrefLib.latitude}"
    }
  }

  "LibrarySearcherReuqest.parseResponse" should {
    "json to list of Library" in {
      val librariesList = BySiteLibrarySearcher.parseResponse(parse(librariesJson))
      librariesList must haveSize(5)
      librariesList.map(_.formal) must contain(allOf(
        "岡山県立図書館",
        "就実大学・就実短期大学図書館",
        "岡山市立幸町図書館",
        "岡山市立中央図書館",
        "山陽学園大学 山陽学園短期大学 図書館"))
    }
  }
}
