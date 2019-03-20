/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package me.ooon.scaviz.vega
import me.ooon.base.test.BaseSpec
import play.api.libs.json.Json

/**
  * TitleSpec
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-20 17:01
  */
class TitleSpec extends BaseSpec {

  "title json" in {
    val t = Title("sample bar")

    // language=JSON
    Json.prettyPrint(Json.toJson(t)) ==> """{
                                              "text" : "sample bar"
                                            }"""
  }

  "title 更多属性" in {
    val t = Title("sample bar", angle = 80.0, anchor = Anchor.start)

    // language=JSON
    Json.prettyPrint(Json.toJson(t)) ==> """{
                                              "text" : "sample bar",
                                              "anchor" : "start",
                                              "angle" : 80
                                            }"""
  }

}
