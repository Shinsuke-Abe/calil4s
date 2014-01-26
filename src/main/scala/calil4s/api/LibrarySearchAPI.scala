package calil4s.api

/*
 * Copyright (C) 2014 Shinsuke Abe
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import calil4s.models.{GeoLocation, LibrarySite, Library}
import calil4s.commons.ApiRequester
import dispatch._, Defaults._
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * @author mao.instantlife at gmail.com
 */

// TODO LibrarySearchContextにrename
object LibrarySearchAPI {
  def at[T](condition: T)(implicit appkey: String, searcher: LibrarySearcher[T]) = searcher.search(condition, appkey)
}

trait LibrarySearcher[T] extends ApiRequester[T] {
  implicit val format = DefaultFormats

  protected def apiBase(appkey: String) = url("https://api.calil.jp/library") <<? baseQueryMap(appkey)

  def search(self: T, appkey: String): List[Library] = {
    val response = Http(requestUrl(self, appkey) OK as.String)
    parseResponse(parse(trimCallbackBracket(response())))
  }

  def parseResponse(json: JValue) = json.extract[List[Library]]
}

object BySiteLibrarySearcher extends LibrarySearcher[LibrarySite] {
  private[calil4s] def requestUrl(condition: LibrarySite, appkey: String) =
    if(Option(condition.city).isDefined) apiBase(appkey) <<? Map("pref" -> condition.pref, "city" -> condition.city)
    else apiBase(appkey) <<? Map("pref" -> condition.pref)
}

object ByGeoLocationLibrarySearcher extends LibrarySearcher[GeoLocation]{
  private[calil4s] def requestUrl(geo: GeoLocation, appkey: String) =
    apiBase(appkey) <<? Map("geocode" -> s"${geo.longitude},${geo.latitude}")
}