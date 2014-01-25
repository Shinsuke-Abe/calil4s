package calil4s.api

import calil4s.models.{GeoLocation, LibrarySite, Library}
import calil4s.commons.ApiRequester
import java.net.URLEncoder
import dispatch._

/**
 * @author mao.instantlife at gmail.com
 */
object LibrarySearchAPI {
  def at[T](condition: T)(implicit apiKey: String, searcher: LibrarySearcher[T]) = searcher.search(condition, apiKey)
}

trait LibrarySearcher[T] {
  def search(self: T, apiKey: String): List[Library]
}

object BySiteLibrarySearcher extends LibrarySearcher[LibrarySite] with ApiRequester[LibrarySite] {
  def search(self: LibrarySite, apiKey: String): List[Library] =
    List(Library("Okayama_Pref", null, "testLibKey", 1L, null, "formalLibraryName", null, "岡山県", "岡山市", null, null, null, null))

  private[calil4s] def requestUrl(condition: LibrarySite, apiKey: String) = {
    val paramValues = Map("appkey" -> apiKey, "pref" -> condition.pref)

    url("http://api.calil.jp/library") <<? {
      if(Option(condition.city).isDefined) paramValues + ("city" -> condition.city)
      else paramValues
    }
  }
}

object ByGeoLocationLibrarySearcher extends LibrarySearcher[GeoLocation]{
  def search(self: GeoLocation, apiKey: String): List[Library] =
    List(Library("Okayama_Pref", null, "testLibKey", 1L, null, "岡山県立図書館", null, "岡山県", "岡山市", null, null, null, null))
}