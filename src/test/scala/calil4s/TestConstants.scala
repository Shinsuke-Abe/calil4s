package calil4s

import calil4s.models.{GeoLocation, LibrarySite}
import java.util.Properties
import java.io.{FileInputStream, File}

/**
 * @author mao.instantlife at gmail.com
 */
object TestConstants {
  val is = this.getClass.getResourceAsStream("/test.properties")

  val prop = new Properties()
  prop.load(is)

  is.close()

  implicit val testappkey = prop.getProperty("test.appkey")
  val siteOkayamaPref = LibrarySite("岡山県")
  val siteOkayamaCity = LibrarySite("岡山県", "岡山市")

  val geoOkayamaPrefLib = GeoLocation(34.6626, 133.934652)

  val librariesJson =
    """
      |[
      |    {
      |        "address": "岡山県岡山市丸の内2丁目6-30",
      |        "category": "LARGE",
      |        "city": "岡山市",
      |        "distance": 0.00016448437864536726,
      |        "formal": "岡山県立図書館",
      |        "geocode": "133.9346529,34.6625982",
      |        "libid": "102923",
      |        "libkey": "本館",
      |        "post": "700-0823",
      |        "pref": "岡山県",
      |        "savemlak": null,
      |        "short": "岡山県立図書館",
      |        "systemid": "Okayama_Pref",
      |        "systemname": "岡山県立図書館",
      |        "tel": "086-224-1286",
      |        "url_pc": "http://www.libnet.pref.okayama.jp/",
      |        "wikipedia": ""
      |    },
      |    {
      |        "address": "岡山県岡山市中区西川原1-5-22",
      |        "category": "UNIV",
      |        "city": "岡山市",
      |        "distance": 1.2166706818270887,
      |        "formal": "就実大学・就実短期大学図書館",
      |        "geocode": "133.9369219,34.6780215",
      |        "libid": "107300",
      |        "libkey": "本館",
      |        "post": "703-8258",
      |        "pref": "岡山県",
      |        "savemlak": null,
      |        "short": "就実大学・就実短期大学",
      |        "systemid": "Univ_Shujitsu",
      |        "systemname": "就実大学",
      |        "tel": "086-271-8135",
      |        "url_pc": "http://www.shujitsu.ac.jp/category/toshokan",
      |        "wikipedia": ""
      |    },
      |    {
      |        "address": "岡山県岡山市北区幸町10番16号",
      |        "category": "MEDIUM",
      |        "city": "岡山市",
      |        "distance": 1.414077521824859,
      |        "formal": "岡山市立幸町図書館",
      |        "geocode": "133.921982,34.6610921",
      |        "libid": "102916",
      |        "libkey": "幸町図書館",
      |        "post": "700-0903",
      |        "pref": "岡山県",
      |        "savemlak": null,
      |        "short": "幸町図書館",
      |        "systemid": "Okayama_Okayama",
      |        "systemname": "岡山県岡山市",
      |        "tel": "086-234-5188",
      |        "url_pc": "http://www.ocl.city.okayama.jp/",
      |        "wikipedia": ""
      |    },
      |    {
      |        "address": "岡山県岡山市北区二日市56",
      |        "category": "MEDIUM",
      |        "city": "岡山市",
      |        "distance": 1.5001362255090955,
      |        "formal": "岡山市立中央図書館",
      |        "geocode": "133.928393,34.645381",
      |        "libid": "102914",
      |        "libkey": "中央図書館",
      |        "post": "700-0843",
      |        "pref": "岡山県",
      |        "savemlak": null,
      |        "short": "岡山市立中央図書館",
      |        "systemid": "Okayama_Okayama",
      |        "systemname": "岡山県岡山市",
      |        "tel": "086-223-3373",
      |        "url_pc": "http://www.ocl.city.okayama.jp/",
      |        "wikipedia": ""
      |    },
      |    {
      |        "address": "岡山県岡山市中区平井1-14-1",
      |        "category": "UNIV",
      |        "city": "岡山市",
      |        "distance": 1.8117439081611197,
      |        "formal": "山陽学園大学 山陽学園短期大学 図書館",
      |        "geocode": "133.943806,34.643184",
      |        "libid": "105917",
      |        "libkey": "本館",
      |        "post": "703-8501",
      |        "pref": "岡山県",
      |        "savemlak": null,
      |        "short": "本館",
      |        "systemid": "Univ_Sguc",
      |        "systemname": "山陽学園大学",
      |        "tel": "086-901-0637",
      |        "url_pc": "http://library.sguc.ac.jp/jhkroot/index.html",
      |        "wikipedia": ""
      |    }
      |]
    """.stripMargin
}
