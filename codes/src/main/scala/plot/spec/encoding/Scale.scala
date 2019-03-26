/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.spec.encoding
import play.api.libs.json.Json

/**
 * Scale 
 *
 * @author zhaihao
 * @version 1.0 
 * @since 2019-03-26 17:08
 */
case class Scale(domain: Seq[String], range: Seq[String])

object Scale {
  implicit val ScaleFormat = Json.format[Scale]
}