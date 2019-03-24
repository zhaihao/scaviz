/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.spec
import play.api.libs.json.Json
import plot.spec.transform.Axis
import plot.{AggOp, FieldType}

/**
  * Encoding
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-22 17:14
  */
case class Encoding(x: Option[Encode] = None, y: Option[Encode] = None)

case class Encode(field:     String,
                  `type`:    FieldType,
                  aggregate: Option[AggOp] = None,
                  axis:      Option[Axis] = None)

object FieldType {
  val Nominal:      FieldType = "nominal"      // 离散
  val Quantitative: FieldType = "quantitative" // 数值
  val Ordinal:      FieldType = "ordinal"      // 有序值
  val Temporal:     FieldType = "temporal"     // 时间
}

object Encode {
  implicit val EncodeFormat = Json.format[Encode]
}

object Encoding {
  implicit val EncodingFormat = Json.format[Encoding]
}
