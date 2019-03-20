/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package me.ooon.scaviz.vega
import me.ooon.scaviz.util.EnumUtil
import me.ooon.scaviz.vega.Anchor.Anchor
import me.ooon.scaviz.vega.Orient.Orient
import play.api.libs.json.Json

/**
  * Title
  *
  * 暂不支持 baseline,frame,style,zindex
  *
  * @param text 标题文本
  * @param anchor 锚点位置
  * @param angle 标题文本旋转角度
  * @param color 标题颜色，支持 css 颜色设置 #f304d3, #ccc, rgb(253, 12, 134), steelblue, red
  * @param font 字体名称
  * @param fontSize 字体大小
  * @param fontWight 字体粗细，100-900 的整百数，400 是正常粗细，700 是粗体
  * @param limit 标题长度限制
  * @param offset 标题与图的距离
  * @param orient 标题相对于图的位置
  * @author zhaihao
  * @version 1.0
  * @since 2019-03-20 16:18
  * @see [[https://vega.github.io/vega-lite/docs/title.html#params]]
  */
case class Title(text:      String,
                 anchor:    Option[Anchor] = None,
                 angle:     Option[Double] = None,
                 color:     Option[String] = None,
                 font:      Option[String] = None,
                 fontSize:  Option[Int] = None,
                 fontWight: Option[Int] = None,
                 limit:     Option[Int] = None,
                 offset:    Option[Int] = None,
                 orient:    Option[Orient] = None)

object Orient extends Enumeration {
  type Orient = Value
  val top, bottom, left, right = Value
  implicit val OrientFormat    = EnumUtil.enumFormat(Orient)
}

object Anchor extends Enumeration {
  type Anchor = Value
  val start, middle, end    = Value
  implicit val AnchorFormat = EnumUtil.enumFormat(Anchor)
}

object Title {
  implicit val titleFormat = Json.format[Title]
}
