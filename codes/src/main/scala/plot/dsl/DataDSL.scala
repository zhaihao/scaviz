/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.dsl
import plot.spec.Data

/**
  * DataDSL
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-22 10:44
  */
trait DataDSL {
  protected var data: Data = Data()

  def data(url: Option[String] = None, values: Option[Seq[Map[String, Any]]] = None): this.type = {
    this.data = data.copy(url = url, values = values)
    this
  }
}
