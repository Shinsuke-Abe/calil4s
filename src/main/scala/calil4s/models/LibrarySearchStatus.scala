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


/**
 * @author mao.instantlife at gmail.com
 */
case class LibrarySearchStatus(status: String,
                               reserveurl: String,
                               libkey: Option[Map[String, String]])

case class SearchStatus(status: String)
object OK extends SearchStatus("OK")
object Cache extends SearchStatus("Cache")
object Running extends SearchStatus("Running")
object Error extends SearchStatus("Error")

case class BorrowStatus(status: String)
object Borrowable extends BorrowStatus("貸出可")
object InCollection extends BorrowStatus("蔵書あり")
object OnlyInLibrary extends BorrowStatus("館内のみ")
object Borrowed extends BorrowStatus("貸出中")
object Reserved extends BorrowStatus("予約中")
object Preparing extends BorrowStatus("準備中")
object LibraryClosed extends BorrowStatus("休館中")
object NotInCollection extends BorrowStatus("蔵書なし")