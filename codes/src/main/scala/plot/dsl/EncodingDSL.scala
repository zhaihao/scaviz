/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.dsl
import plot.spec.transform.Axis
import plot.spec.{Encode, Encoding}
import plot.{AggOp, FieldType}

/**
  * EncodingDSL
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-22 17:24
  */
trait EncodingDSL {

  protected var encoding: Option[Encoding] = None

  def encodeX(field:     String,
              `type`:    FieldType,
              aggregate: Option[AggOp] = None,
              axis:      Option[Axis] = None): this.type = {
    if (encoding.isEmpty) encoding = Encoding(x = Encode(field, `type`, aggregate, axis))
    else encoding                  = encoding.map(_.copy(x = Encode(field, `type`, aggregate, axis)))

    this
  }

  def encodeY(field:     String,
              `type`:    FieldType,
              aggregate: Option[AggOp] = None,
              axis:      Option[Axis] = None): this.type = {
    if (encoding.isEmpty) encoding = Encoding(y = Encode(field, `type`, aggregate, axis))
    else encoding                  = encoding.map(_.copy(y = Encode(field, `type`, aggregate, axis)))

    this
  }

}