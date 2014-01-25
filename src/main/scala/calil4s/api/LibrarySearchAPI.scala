package calil4s.api

import calil4s.models.{GeoLocation, LibrarySite, Library}
import calil4s.commons.ApiRequester
import dispatch._
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * @author mao.instantlife at gmail.com
 */
object LibrarySearchAPI {
  def at[T](condition: T)(implicit appkey: String, searcher: LibrarySearcher[T]) = searcher.search(condition, appkey)
}

trait LibrarySearcher[T] extends ApiRequester[T] {
  implicit val format = DefaultFormats

  protected def apiBase(appkey: String) = url("https://api.calil.jp/library") <<? baseQueryMap(appkey)

  def search(self: T, appkey: String): List[Library]

  def parseResponse(json: JValue) = json.extract[List[Library]]
}

object BySiteLibrarySearcher extends LibrarySearcher[LibrarySite] {
  def search(self: LibrarySite, appkey: String): List[Library] =
    List(Library("Okayama_Pref", null, "testLibKey", "1", null, "formalLibraryName", null, "岡山県", "岡山市", null, null, null, null))

  private[calil4s] def requestUrl(condition: LibrarySite, appkey: String) =
    if(Option(condition.city).isDefined) apiBase(appkey) <<? Map("pref" -> condition.pref, "city" -> condition.city)
    else apiBase(appkey) <<? Map("pref" -> condition.pref)
}

object ByGeoLocationLibrarySearcher extends LibrarySearcher[GeoLocation]{
  def search(self: GeoLocation, appkey: String): List[Library] =
    List(Library("Okayama_Pref", null, "testLibKey", "1", null, "岡山県立図書館", null, "岡山県", "岡山市", null, null, null, null))

  private[calil4s] def requestUrl(geo: GeoLocation, appkey: String) =
    apiBase(appkey) <<? Map("geocode" -> s"${geo.longitude},${geo.latitude}")
}