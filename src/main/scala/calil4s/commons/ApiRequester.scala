package calil4s.commons

import dispatch.Req

/**
 * @author mao.instantlife at gmail.com
 */
trait ApiRequester[T] {
  protected def baseQueryMap(appkey: String) = Map("appkey" -> appkey, "format" -> "json", "callback" -> "")

  private[calil4s] def requestUrl(condition: T, appkey: String): Req
}
