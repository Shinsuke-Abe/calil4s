package calil4s

import api._
import calil4s.models.{CheckResult, Library}

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

/**
 * @author mao.instantlife at gmail.com
 */
object Calil {
  implicit val byLibrarySite = BySiteLibrarySearcher
  implicit val byGeoLocation = ByGeoLocationLibrarySearcher

  val libraries = LibrarySearchContext

  val check = CheckCollectionContext

  implicit class ToCheckResultContext(val checkResult: CheckResult) {
    def polling(implicit appkey: String) = PollingResultContext(checkResult.session, appkey)
  }
}
