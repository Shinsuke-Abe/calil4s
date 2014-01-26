# Calil4S

[カーリル](http://calil.jp/)が提供している図書館・蔵書検索APIをScalaで扱うためのライブラリです。<br/>
APIの仕様は[こちら](http://calil.jp/doc/api_ref.html)をご覧ください。<br/>
勢いで作ったので、リクエストを投げるのが優先で、バリデーションとかエラーハンドリングとかはあまりしてませんので、利用は自己責任で。。。

## インストール

build.sbtに以下の依存性を追加して下さい。

```
resolvers += "bintray" at "http://dl.bintray.com/shinsuke-abe/maven"

libraryDependencies += "com.github.Shinsuke-Abe" %% "calil4s" % "0.0.1"
```

## ビルド環境について

Calil4Sは以下の環境で構築されています。

* Scala 2.10.3
* sbt 0.13.1
* dispatch 0.11.0
* json4s 3.2.6

注：2014/01/26時点で最新の安定版のライブラリを元に構築しています。

## 使い方

Calil4sは以下のように使って下さい。<br/>

```
import calil4s.Calil._
import calil4s.models

implicit val appkey = "yourappkey"

// 図書館検索
val libsOkayamaCity: List[Library] = libraries at LibrarySite("岡山県", "岡山市") // 岡山県岡山市の図書館を検索
val libsOkayamaPref: List[Library] = libraries at LibrarySite("岡山県") // 岡山県の図書館を検索

val libsByGeocode: List[Library] = libraries at GeoLocation(緯度, 経度) // 緯度・経度から図書館を検索

// 蔵書検索
val checkResultFirst: CheckResult =
  check collection List("4334926940", "4088700104") of
    libsOkayamaCity.map(_.systemid).distince // ISBNのリストを指定の図書館から探す

val checkResultPolling: CheckResult = checkResultFirst polling // 指定した結果のセッションから結果をポーリングする
```
