package calil4s.models

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.commons._
import java.net.URLEncoder
import calil4s.TestConstants._

class LibraryTest extends Specification {
  "calilUrl" should {
    "returns library search url" in {
      val library = Library("test", "test", "testLibKey", "1", "test", "formalLibraryName", null, "", "", "", "", null, "")

      library.calilUrl must equalTo(calilUrl"/library/${library.libid}/${URLEncoder.encode(library.formal, "utf-8")}")
    }
  }

  "geoLocation" should {
    "return GeoLocation instance from geocode string" in {
      val library = Library("test", "test", "testLibKey", "1", "test", "formalLibraryName", null, "", "", "", "", "133.934652,34.6626", "")

      library.geoLocation must equalTo(geoOkayamaPrefLib)
    }
  }
}
