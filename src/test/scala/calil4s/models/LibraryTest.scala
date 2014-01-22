package calil4s.models

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.commons._
import java.net.URLEncoder

class LibraryTest extends Specification {
  "calilUrl" should {
    "returns library search url" in {
      val library = Library(???, ???, "testLibKey", 1L, ???, "formalLibraryName", ???, ???, ???, ???, ???, ???, ???)

      library.calilUrl must equalTo(calilUrl"/library/${library.libId}/${URLEncoder.encode(library.formalName, "utf-8")}")
    }
  }
}
