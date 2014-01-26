package calil4s.api

import calil4s.models.CheckResult
import calil4s.commons.ApiRequester
import dispatch._, Defaults._
import org.json4s._
import org.json4s.native.JsonMethods._

/**
 * @author mao.instantlife at gmail.com
 */
object CheckCollectionContext {
  def collection(isbns: List[String])(implicit appkey: String) = SetTargetLibraryContext(isbns, appkey)
}

case class SetTargetLibraryContext(val isbns: List[String], appkey: String) extends ApiRequester[(List[String], List[String])]{
  implicit val format = DefaultFormats

  def of(systemids: List[String]):CheckResult = {
    val response = Http(requestUrl((isbns, systemids), appkey) OK as.String)
    parseResponse(parse(trimCallbackBracket(response())))
  }

  private[calil4s] def requestUrl(condition: (List[String], List[String]), appkey: String): Req =
    url("https://api.calil.jp/check") <<?
      baseQueryMap(appkey) <<?
      Map("isbn" -> condition._1.mkString(","), "systemid" -> condition._2.mkString(","))

  def parseResponse(json: JValue) = json.extract[CheckResult]
}
