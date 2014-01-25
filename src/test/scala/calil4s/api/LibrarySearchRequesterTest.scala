package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.models.{GeoLocation, LibrarySite}
import java.net.URLEncoder

class LibrarySearchRequesterTest extends Specification {
  val baseApiUrl = "https://api.calil.jp/library"

  private def encode(value: String) = URLEncoder.encode(value, "utf-8")

  // TODO テスト全体のリファクタリング
  // TODO formatパラメータとjsonパラメータの指定

  "BySiteLibrarySearcher.requestUrl(LibrarySite, AppKey)" should {
    "returns query url with pref only condition" in {
      val site = LibrarySite("岡山県")

      BySiteLibrarySearcher.requestUrl(site, "test-app-key").url must
      equalTo(s"${baseApiUrl}?appkey=test-app-key&pref=${encode(site.pref)}")
    }

    "returns query url with pref and city condition" in {
      val site = LibrarySite("岡山県", "岡山市")

      BySiteLibrarySearcher.requestUrl(site, "test-app-key").url must
      equalTo(s"${baseApiUrl}?appkey=test-app-key&pref=${encode(site.pref)}&city=${encode(site.city)}")
    }
  }

  "ByGeoLocationLibrarySearcher.requestUrl(GeoLocation, AppKey)" should {
    "returns query url with geo condition" in {
      val geo = GeoLocation(34.6626, 133.934652)

      ByGeoLocationLibrarySearcher.requestUrl(geo, "test-app-key").url must
      equalTo(s"${baseApiUrl}?appkey=test-app-key&geocode=${geo.longitude}%2C${geo.latitude}")
    }
  }
}
