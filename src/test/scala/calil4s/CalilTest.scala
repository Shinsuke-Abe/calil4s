package calil4s

/**
 * @author mao.instantlife at gmail.com
 */

import models.{GeoLocation, LibrarySite}
import org.specs2.mutable._

class CalilTest extends Specification {

  import Calil._

  "libraries" should {
    "at method with library site returns Library list" in {
      implicit val apiKey = "hoge"

      forall(libraries at LibrarySite("岡山県", "岡山市")){ resultLibrary =>
        resultLibrary.pref must equalTo("岡山県")
        resultLibrary.city must equalTo("岡山市")
      }
    }

    "at method with geo code returns library list" in {
      implicit val apiKey = "hoge"

      (libraries at GeoLocation(34.6626, 133.934652)).head.formalName must equalTo("岡山県立図書館")
    }
  }
  // TODO searchLibrary
  // TODO checkBooks
  // TODO 結果のポーリング
}
