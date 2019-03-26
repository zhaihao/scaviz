/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.spec.transform
import play.api.libs.json.{JsValue, Json, Writes}

/**
  * Transform
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-26 14:46
  */
sealed trait Transform

case class Calculate(calculate: String, as: String) extends Transform

object Transform {
  implicit val CalculateFormat = Json.format[Calculate]

  implicit val TransformWrite = new Writes[Transform] {
    override def writes(o: Transform): JsValue = o match {
      case a: Calculate => CalculateFormat.writes(a)
      case _ => throw new Exception("transform is unsupported!")
    }
  }
}
