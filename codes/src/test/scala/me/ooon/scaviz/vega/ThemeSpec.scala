/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package me.ooon.scaviz.vega
import me.ooon.base.test.BaseSpec

/**
  * ThemeSpec
  *
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-20 15:54
  */
class ThemeSpec extends BaseSpec {

  "test theme" in {
    Theme.vox.toString ==> "vox"
  }

}
