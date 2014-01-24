package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.models.LibrarySite
import java.net.URLEncoder

class LibrarySearchRequesterTest extends Specification {

  "BySiteLibrarySearcher.requestUrl(LibrarySite, ApiKey)" should {
    "returns query url with pref only conditon" in {
      val site = LibrarySite("岡山県")

      // TODO dispatch形式のURLで返す
      BySiteLibrarySearcher.requestUrl(site, "test-api-key") must
      equalTo(s"http://api.calil.jp/library?appkey=test-api-key&pref=${URLEncoder.encode(site.pref, "utf-8")}")
    }
  }
}
