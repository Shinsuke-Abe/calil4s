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

import java.net.{URLEncoder, URL}
import calil4s.commons._

/**
 * @author mao.instantlife at gmail.com
 */
case class Library(systemid: String,
                    systemname: String,
                    libkey: String,
                    libid: String,
                    short: String,
                    formal: String,
                    url_pc: String,
                    pref: String,
                    city: String,
                    post: String,
                    tel: String,
                    geocode: String,
                    category: String,
                    distance: Option[Double] = None) {
  def calilUrl = calilUrl"/library/${libid}/${URLEncoder.encode(formal, "utf-8")}"

  def geoLocation = {
    val geocodeSplited = geocode.split(",")

    require(geocodeSplited.length >= 2)
    GeoLocation(geocodeSplited(1).toDouble, geocodeSplited.head.toDouble)
  }
}
