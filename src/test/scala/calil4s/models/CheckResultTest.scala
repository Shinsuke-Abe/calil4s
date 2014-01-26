package calil4s.models

import org.specs2.mutable._
import calil4s.commons._

/**
 * @author mao.instantlife at gmail.com
 */
class CheckResultTest extends Specification {
  "calilUrlMap" should {
    "returns book search url" in {
      val checkResult = CheckResult(null, Map("4334926940" -> null, "4088700104" -> null), 0)
      checkResult.calilUrlMap must equalTo(
        Map("4334926940" -> calilUrl"/book/4334926940", "4088700104" -> calilUrl"/book/4088700104"))
    }
  }
}
