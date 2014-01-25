package calil4s

/**
 * @author mao.instantlife at gmail.com
 */

import models.{GeoLocation, LibrarySite}
import org.specs2.mutable._

class CalilTest extends Specification {

  import TestConstants._
  import Calil._

  "libraries" should {
    "at method with library site returns Library list" in {
      implicit val appkey = "hoge"

      forall(libraries at siteOkayamaCity){ resultLibrary =>
        resultLibrary.pref must equalTo("岡山県")
        resultLibrary.city must equalTo("岡山市")
      }
    }

    "at method with geo code returns library list" in {
      implicit val appkey = "hoge"

      (libraries at geoOkayamaPrefLib).head.formal must equalTo("岡山県立図書館")
    }
  }
  // TODO searchLibrary
  // TODO checkBooks
  // TODO 結果のポーリング
}
