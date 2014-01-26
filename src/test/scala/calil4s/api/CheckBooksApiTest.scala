package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import java.net.URLEncoder
import dispatch.Req

class CheckBooksApiTest extends Specification {
  val baseApiUrl = "https://api.calil.jp/check"
  val baseSearchUrl = s"${baseApiUrl}?appkey=test-app-key&format=json&callback="

  private def encode(value: String) = URLEncoder.encode(value, "utf-8")

  implicit class RequestUrlAssertion(val requestUrl: Req) {
    def assert(queryStrings: String*) = {
      requestUrl.url.length must equalTo(
        queryStrings.foldLeft(baseSearchUrl.length)((z, param) => z + 1 + param.length))

      requestUrl.url must startWith(baseApiUrl)

      forall(queryStrings){ query =>
        requestUrl.url must contain(query)
      }
    }
  }

  "SetTargetLibraryContext.requestUrl((List[String], List[String]), AppKey)" should {
    "returns query url with isbn list and system id list" in {
      val isbns = List("4334926940", "4088700104")
      val systemids = List("Okayama_Pref", "Univ_Shujitsu")

      SetTargetLibraryContext(isbns, "test-app-key").requestUrl((isbns, systemids), "test-app-key") assert (
        s"isbn=${encode(isbns.mkString(","))}",
        s"systemid=${encode(systemids.mkString(","))}")
    }
  }
}
