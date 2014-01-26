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

import calil4s.models.CheckResult
import calil4s.commons.ApiRequester
import dispatch._
import org.json4s._

/**
 * @author mao.instantlife at gmail.com
 */
object CheckCollectionContext {
  def collection(isbns: List[String])(implicit appkey: String) = {
    require(isbns != null && !isbns.isEmpty)
    SetTargetLibraryContext(isbns, appkey)
  }
}

case class SetTargetLibraryContext(val isbns: List[String], appkey: String) extends ApiRequester[(List[String], List[String]), CheckResult]{
  implicit val format = DefaultFormats

  def of(systemids: List[String]):CheckResult = {
    require(systemids != null && !systemids.isEmpty)

    executeRequest(requestUrl((isbns, systemids), appkey))
  }

  private[calil4s] def requestUrl(condition: (List[String], List[String]), appkey: String): Req =
    url("https://api.calil.jp/check") <<?
      baseQueryMap(appkey) <<?
      Map("isbn" -> condition._1.mkString(","), "systemid" -> condition._2.mkString(","))

  def parseResponse(json: JValue) = json.extract[CheckResult]
}
