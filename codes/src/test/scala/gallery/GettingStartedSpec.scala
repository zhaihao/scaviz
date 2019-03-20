/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package gallery
import me.ooon.base.test.BaseSpec
import plot.spec.Themes

/**
  * GettingStartedSpec
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-22 16:17
  * @see [[https://vega.github.io/vega-lite/tutorials/getting_started.html]]
  */
class GettingStartedSpec extends BaseSpec {
  import plot._
  import plot.spec._

  "Encoding Data with Marks" - {
    val values = Seq(
      Map("a" -> "C", "b" -> 2),
      Map("a" -> "C", "b" -> 7),
      Map("a" -> "C", "b" -> 4),
      Map("a" -> "D", "b" -> 1),
      Map("a" -> "D", "b" -> 2),
      Map("a" -> "D", "b" -> 6),
      Map("a" -> "E", "b" -> 8),
      Map("a" -> "E", "b" -> 4),
      Map("a" -> "E", "b" -> 7)
    )

    "gallery 1" in {
      plot.vega
        .config(title = "Encoding Data with Marks", theme = Themes.Quartz)
        .data(values = values)
        .mark(Mark.Point)
        .html.browse
    }
  }
}
