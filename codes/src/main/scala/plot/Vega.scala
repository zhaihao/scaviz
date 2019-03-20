/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot
import play.api.libs.json.{JsObject, JsString, Json, Writes}
import plot.dsl.{DataDSL, MarkDSL, RenderDSL, VegaConfigDSL}

/**
  * Vega
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-22 11:34
  */
class Vega extends VegaConfigDSL with DataDSL with MarkDSL with RenderDSL {
  val schema = s"https://vega.github.io/schema/vega-lite/$SCHEMA_VERSION.json"
}

object Vega {

  def apply(): Vega = new Vega()

  implicit val VegaWrite = new Writes[Vega] {
    override def writes(o: Vega) =
      JsObject(
        Seq(
          "$schema" -> JsString(o.schema),
          "data"    -> Json.toJson(o.data),
          "mark"    -> Json.toJson(o.mark)
        )
      )
  }
}
