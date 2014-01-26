package calil4s

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._

class CalilTest extends Specification {

  import TestConstants._
  import Calil._

  val okayamaCityLib = libraries at siteOkayamaCity
  val okayamaPrefGeoLib = libraries at geoOkayamaPrefLib

  "libraries" should {
    "at method with library site returns Library list" in {
      forall(okayamaCityLib){ resultLibrary =>
        resultLibrary.pref must equalTo("岡山県")
        resultLibrary.city must equalTo("岡山市")
      }
    }

    "at method with geo code returns library list" in {
      (okayamaPrefGeoLib).head.formal must equalTo("岡山県立図書館")
    }
  }

  "check collection" should {
    "collection method with isbn list returns SetTargetLibraryContext" in {
      (check collection isbns).isbns must equalTo(isbns)
    }

    "collection method with null values throw exception" in {
      (check collection null) must throwA[IllegalArgumentException]
    }

    "collection method with empty list throw exception" in {
      (check collection List.empty[String]) must throwA[IllegalArgumentException]
    }
  }

  "SetTargetLibraryContext.of" should {
    "of method with library's systemid list returns CheckResult" in {
      val okayamaPrefLibsSystemId = okayamaCityLib.map(_.systemid).distinct
      (check collection isbns of okayamaPrefLibsSystemId).books must haveKeys(isbns: _*)
    }

    "of method with null value s throw exceptioin" in {
      (check collection isbns of null) must throwA[IllegalArgumentException]
    }

    "of method with empty list throw excpetion" in {
      (check collection isbns of List.empty[String]) must throwA[IllegalArgumentException]
    }
  }

  // TODO Rate limit到達時の挙動が仕様に書かれていない...
}
