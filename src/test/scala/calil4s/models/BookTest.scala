package calil4s.models

/**
 * @author mao.instantlife at gmail.com
 */

import org.specs2.mutable._
import calil4s.commons._

// TODO 削除,calilUrlをCheckResultに変更
class BookTest extends Specification {
  "calilUrl" should {
    "returns book search url" in {
      val book = Book("1234567890", List.empty)
      book.calilUrl must equalTo(calilUrl"/book/${book.isbn}")
    }
  }
}
