package calil4s

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._

class CalilTest extends Specification {

  import TestConstants._
  import Calil._

  "libraries" should {
    "at method with library site returns Library list" in {
      forall(libraries at siteOkayamaCity){ resultLibrary =>
        resultLibrary.pref must equalTo("岡山県")
        resultLibrary.city must equalTo("岡山市")
      }
    }

    "at method with geo code returns library list" in {
      (libraries at geoOkayamaPrefLib).head.formal must equalTo("岡山県立図書館")
    }
  }

  "check collection" should {
    "collection method with isbn list returns SetTargetLibraryContext" in {
      (check collection List("0123456789", "1234567890")).isbns must equalTo(List("0123456789", "1234567890"))
    }
  }
  // TODO checkBooks
  // TODO 結果のポーリング

  // TODO Rate limit到達時の挙動が仕様に書かれていない...
}
