/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.dsl
import plot.{AggOp, FieldType}
import plot.spec.{Encode, Encoding}

/**
  * EncodingDSL
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-22 17:24
  */
trait EncodingDSL {

  protected var encoding: Option[Encoding] = None

  def encodeX(field: String, `type`: FieldType, aggregate: Option[AggOp] = None): this.type = {
    if (encoding.isEmpty) encoding = Encoding(x = Encode(field, `type`, aggregate))
    else encoding                  = encoding.map(_.copy(x = Encode(field, `type`, aggregate)))

    this
  }

  def encodeY(field: String, `type`: FieldType, aggregate: Option[AggOp] = None): this.type = {
    if (encoding.isEmpty) encoding = Encoding(y = Encode(field, `type`, aggregate))
    else encoding                  = encoding.map(_.copy(y = Encode(field, `type`, aggregate)))

    this
  }

}
