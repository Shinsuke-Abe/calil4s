package calil4s.commons

import dispatch.Req

/**
 * @author mao.instantlife at gmail.com
 */
trait ApiRequester[T] {
  private[calil4s] def requestUrl(condition: T, appkey: String): Req
}
