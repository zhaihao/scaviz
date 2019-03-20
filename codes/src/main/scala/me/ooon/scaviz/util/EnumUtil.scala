/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package me.ooon.scaviz.util
import play.api.libs.json._

import scala.language.implicitConversions

/**
  * EnumUtil
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-20 17:18
  */
object EnumUtil {

  def enumReads[E <: Enumeration](enum: E): Reads[E#Value] = {
    case JsString(s) =>
      try {
        JsSuccess(enum.withName(s))
      } catch {
        case _: NoSuchElementException =>
          JsError(
            s"Enumeration expected of type: '${enum.getClass}', but it does not appear to contain the value: '$s'")
      }
    case _ => JsError("String value expected")
  }

  implicit def enumWrites[E <: Enumeration]: Writes[E#Value] = (v: E#Value) => JsString(v.toString)

  implicit def enumFormat[E <: Enumeration](enum: E): Format[E#Value] = {
    Format(EnumUtil.enumReads(enum), EnumUtil.enumWrites)
  }
}
