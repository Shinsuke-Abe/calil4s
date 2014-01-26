package calil4s.api

/**
 * @author mao.instantlife at gmail.com
 */
object CheckCollectionContext {
  def collection(isbns: List[String]) = SetTargetLibraryContext(isbns)
}

case class SetTargetLibraryContext(val isbns: List[String])
