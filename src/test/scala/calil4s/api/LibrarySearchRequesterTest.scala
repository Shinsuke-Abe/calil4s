package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.models.LibrarySite
import java.net.URLEncoder

class LibrarySearchRequesterTest extends Specification {
  val baseApiUrl = "http://api.calil.jp/library"

  private def encode(value: String) = URLEncoder.encode(value, "utf-8")

  "BySiteLibrarySearcher.requestUrl(LibrarySite, ApiKey)" should {
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
}
