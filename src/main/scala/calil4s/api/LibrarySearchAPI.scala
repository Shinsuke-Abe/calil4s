package calil4s.api

import calil4s.models.{GeoLocation, LibrarySite, Library}
import calil4s.commons.ApiRequester
import dispatch._

/**
 * @author mao.instantlife at gmail.com
 */
object LibrarySearchAPI {
  def at[T](condition: T)(implicit appkey: String, searcher: LibrarySearcher[T]) = searcher.search(condition, appkey)
}

trait LibrarySearcher[T] extends ApiRequester[T] {
  def search(self: T, appkey: String): List[Library]
}

object BySiteLibrarySearcher extends LibrarySearcher[LibrarySite] {
  def search(self: LibrarySite, appkey: String): List[Library] =
    List(Library("Okayama_Pref", null, "testLibKey", 1L, null, "formalLibraryName", null, "岡山県", "岡山市", null, null, null, null))

  private[calil4s] def requestUrl(condition: LibrarySite, appkey: String) = {
    val paramValues = Map("appkey" -> appkey, "pref" -> condition.pref)

    url("https://api.calil.jp/library") <<? {
      if(Option(condition.city).isDefined) paramValues + ("city" -> condition.city)
      else paramValues
    }
  }
}

object ByGeoLocationLibrarySearcher extends LibrarySearcher[GeoLocation]{
  def search(self: GeoLocation, appkey: String): List[Library] =
    List(Library("Okayama_Pref", null, "testLibKey", 1L, null, "岡山県立図書館", null, "岡山県", "岡山市", null, null, null, null))

  private[calil4s] def requestUrl(geo: GeoLocation, appkey: String) =
    url("https://api.calil.jp/library") <<? Map("appkey" -> appkey, "geocode" -> s"${geo.longitude},${geo.latitude}")
}