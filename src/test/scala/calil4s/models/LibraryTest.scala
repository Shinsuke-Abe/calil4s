package calil4s.models

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.commons._
import java.net.URLEncoder

class LibraryTest extends Specification {
  // TODO JSONからのunapply
  "calilUrl" should {
    "returns library search url" in {
      val library = Library("test", "test", "testLibKey", 1L, "test", "formalLibraryName", null, "", "", "", "", null, "")

      library.calilUrl must equalTo(calilUrl"/library/${library.libId}/${URLEncoder.encode(library.formalName, "utf-8")}")
    }
  }
}
