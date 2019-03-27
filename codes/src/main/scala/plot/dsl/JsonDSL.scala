/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package plot.dsl
import plot._

/**
  * JsonDSL
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-27 17:58
  */
trait JsonDSL {
  protected var json: Option[String] = None

  def json(json: String): this.type = {
    this.json = json
    this
  }

}
