package calil4s.api

import calil4s.TestConstants._
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * @author mao.instantlife at gmail.com
 */
class CheckBooksApiTest extends ApiRequestTestBase {
  val baseApiUrl = "https://api.calil.jp/check"

  val isbns = List("4334926940", "4088700104")

  val testContext = SetTargetLibraryContext(isbns, "test-app-key")

  "SetTargetLibraryContext.requestUrl((List[String], List[String]), AppKey)" should {
    "returns query url with isbn list and system id list" in {
      val systemids = List("Okayama_Pref", "Univ_Shujitsu")

      testContext.requestUrl((isbns, systemids), "test-app-key") assert (
        s"isbn=${encode(isbns.mkString(","))}",
        s"systemid=${encode(systemids.mkString(","))}")
    }
  }

  "SetTargetLibraryContext.parseResponse" should {
    "json to list of Library" in {
      testContext.parseResponse(parse(checkResultJson)).books must haveKeys("4334926940", "4088700104")
    }
  }
}
