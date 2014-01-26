package calil4s.commons

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
import dispatch.Req

/**
 * @author mao.instantlife at gmail.com
 */
trait ApiRequester[T] {
  protected def baseQueryMap(appkey: String) = Map("appkey" -> appkey, "format" -> "json", "callback" -> "")

  private[calil4s] def requestUrl(condition: T, appkey: String): Req

  // TODO 正規表現で行けると思う
  protected def trimCallbackBracket(response: String) =
    if(response.startsWith("(") && response.endsWith(");")) response.substring(1, response.length - 2)
    else response
}
