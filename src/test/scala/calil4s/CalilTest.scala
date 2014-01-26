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
      (check collection isbns).isbns must equalTo(isbns)
    }

    // TODO collection メソッドの引数が空リスト
  }

  "SetTargetLibraryContext.of" should {
    "of method with library's systemid list returns CheckResult" in {
      val okayamaPrefLibsSystemId = (libraries at siteOkayamaCity).map(_.systemid).distinct
      (check collection isbns of okayamaPrefLibsSystemId).books must haveKeys(isbns: _*)
    }

    // TODO of メソッドの引数が空リスト
  }
  // TODO checkBooks
  // TODO 結果のポーリング

  // TODO Rate limit到達時の挙動が仕様に書かれていない...
}
