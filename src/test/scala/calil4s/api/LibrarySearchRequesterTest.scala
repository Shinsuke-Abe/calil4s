package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import java.net.URLEncoder
import calil4s.TestConstants._

class LibrarySearchRequesterTest extends Specification {
  val baseApiUrl = "https://api.calil.jp/library"

  private def encode(value: String) = URLEncoder.encode(value, "utf-8")

  // TODO formatパラメータとjsonパラメータの指定

  "BySiteLibrarySearcher.requestUrl(LibrarySite, AppKey)" should {
    "returns query url with pref only condition" in {
      BySiteLibrarySearcher.requestUrl(siteOkayamaPref, "test-app-key").url must
      equalTo(s"${baseApiUrl}?appkey=test-app-key&pref=${encode(siteOkayamaPref.pref)}")
    }

    "returns query url with pref and city condition" in {
      BySiteLibrarySearcher.requestUrl(siteOkayamaCity, "test-app-key").url must
      equalTo(s"${baseApiUrl}?appkey=test-app-key&pref=${encode(siteOkayamaCity.pref)}&city=${encode(siteOkayamaCity.city)}")
    }
  }

  "ByGeoLocationLibrarySearcher.requestUrl(GeoLocation, AppKey)" should {
    "returns query url with geo condition" in {
      ByGeoLocationLibrarySearcher.requestUrl(geoOkayamaPrefLib, "test-app-key").url must
      equalTo(s"${baseApiUrl}?appkey=test-app-key&geocode=${geoOkayamaPrefLib.longitude}%2C${geoOkayamaPrefLib.latitude}")
    }
  }
}
