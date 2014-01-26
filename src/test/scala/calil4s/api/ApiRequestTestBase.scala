package calil4s.api

import java.net.URLEncoder
import dispatch.Req
import org.specs2.mutable._

/**
 * @author mao.instantlife at gmail.com
 */
trait ApiRequestTestBase extends Specification {
  val baseApiUrl: String
  def baseSearchUrl(baseApiUrl: String) = s"${baseApiUrl}?appkey=test-app-key&format=json&callback="

  def encode(value: String) = URLEncoder.encode(value, "utf-8")

  implicit class RequestUrlAssertion(val requestUrl: Req) {
    def assert(queryStrings: String*) = {
      requestUrl.url.length must equalTo(
        queryStrings.foldLeft(baseSearchUrl(baseApiUrl).length)((z, param) => z + 1 + param.length))

      requestUrl.url must startWith(baseApiUrl)

      forall(queryStrings){ query =>
        requestUrl.url must contain(query)
      }
    }
  }
}
