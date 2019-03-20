/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package me.ooon.scaviz.vega
import me.ooon.scaviz.util.EnumUtil

/**
  * Theme
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-20 15:53
  * @see [[https://github.com/vega/vega-themes/blob/master/src/index.ts]]
  */
object Theme extends Enumeration {
  val excel, ggplot2, quartz, vox, dark, fivethirtyeight, latimes = Value

  implicit val ThemeFormat = EnumUtil.enumFormat(Theme)
}
