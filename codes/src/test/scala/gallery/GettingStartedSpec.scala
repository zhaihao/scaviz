/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package gallery
import me.ooon.base.test.BaseSpec
import plot.spec.transform.{AggOp, Axis}

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

  "Encoding Data with Marks" - {

    "gallery 1" in {
      plot.vega
        .config(title = "Encoding Data with Marks", theme = Themes.Quartz)
        .data(values = values)
        .mark(Mark.Point)
        .html
        .browse
    }

    "gallery 2" in {
      plot.vega
        .config(theme = Themes.Quartz)
        .data(values = values)
        .mark(Mark.Point)
        .encodeX("a", FieldType.Nominal)
        .html
        .browse
    }

    "gallery 3" in {
      plot.vega
        .config(theme = Themes.Default)
        .data(values = values)
        .mark(Mark.Point)
        .encodeX("a", FieldType.Nominal)
        .encodeY("b", FieldType.Quantitative)
        .html
        .browse
    }
  }
  "Data Transformation: Aggregation" - {
    "gallery 1" in {
      plot.vega
        .config(theme = Themes.Default)
        .data(values = values)
        .mark(Mark.Bar)
        .encodeX("a", FieldType.Nominal)
        .encodeY("b", FieldType.Quantitative, AggOp.Average)
        .html
        .browse
    }

    "gallery 2" in {
      plot.vega
        .config(theme = Themes.Default)
        .data(values = values)
        .mark(Mark.Bar)
        .encodeY("a", FieldType.Nominal)
        .encodeX("b", FieldType.Quantitative, AggOp.Average)
        .html
        .browse
    }
  }

  "Customize your Visualization" in {
    plot.vega
      .data(values = values)
      .mark(Mark.Bar)
      .encodeY("a", FieldType.Nominal)
      .encodeX("b", FieldType.Quantitative, AggOp.Average, Axis(title = "Mean of b"))
      .html
      .browse
  }

}
