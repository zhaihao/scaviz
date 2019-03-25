/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package gallery
import me.ooon.base.test.BaseSpec
import plot.spec.{FieldType, Mark}

/**
  * ExploringDataSpec
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-25 17:57
  */
class ExploringDataSpec extends BaseSpec {
  import plot._
  "gallery 1" in {
    plot.vega
      .data(DemoData.Weather)
      .mark(Mark.Tick)
      .encodeX("precipitation", FieldType.Quantitative)
      .html
      .browse
  }
}
