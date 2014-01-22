package calil4s.commons

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import java.net.{URLEncoder, URL}

class URLContextTest extends Specification {
  "calilUrl String context" should {
    "returns java.net.URL instance" in {
      calilUrl"/library/${URLEncoder.encode("テスト", "utf-8")}" must
        equalTo(new URL(s"${baseUrl}/library/${URLEncoder.encode("テスト", "utf-8")}"))
    }
  }
}
