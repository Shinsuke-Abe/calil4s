package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */
class CheckBooksApiTest extends ApiRequestTestBase {
  val baseApiUrl = "https://api.calil.jp/check"

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
