package calil4s.api

import calil4s.models.CheckResult
import calil4s.commons.ApiRequester
import dispatch._, Defaults._

/**
 * @author mao.instantlife at gmail.com
 */
object CheckCollectionContext {
  def collection(isbns: List[String])(implicit appkey: String) = SetTargetLibraryContext(isbns, appkey)
}

case class SetTargetLibraryContext(val isbns: List[String], appkey: String) extends ApiRequester[(List[String], List[String])]{
  def of(systemids: List[String]) = CheckResult(null, Map("4334926940" -> null, "4088700104" -> null), 0)

  private[calil4s] def requestUrl(condition: (List[String], List[String]), appkey: String): Req =
    url("https://api.calil.jp/check") <<?
      baseQueryMap(appkey) <<?
      Map("isbn" -> condition._1.mkString(","), "systemid" -> condition._2.mkString(","))
}
