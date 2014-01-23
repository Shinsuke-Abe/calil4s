package calil4s.models

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

import calil4s.commons._
/**
 * @author mao.instantlife at gmail.com
 */
case class Book(isbn: String, searchResponses: List[LibrarySearchResponse]) {
  def calilUrl = calilUrl"/book/${isbn}"
}
