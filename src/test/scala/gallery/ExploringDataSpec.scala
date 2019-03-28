/*
 * Copyright (c) 2019.
 * OOON.ME ALL RIGHTS RESERVED.
 * Licensed under the Mozilla Public License, version 2.0
 * Please visit http://ooon.me or mail to zhaihao@ooon.me
 */

package gallery
import me.ooon.base.test.BaseSpec
import plot.spec.encoding._
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

  "gallery 2" in {
    plot.vega
      .data(DemoData.Weather)
      .mark(Mark.Bar)
      .encodeX("precipitation", FieldType.Quantitative, bin = Bin())
      .encodeY(`type` = FieldType.Quantitative, aggregate = AggOp.Count)
      .html
      .browse
  }

  "gallery 3" in {
    plot.vega
      .data(DemoData.Weather)
      .mark(Mark.Line)
      .encodeX(field = "date", `type` = FieldType.Temporal, timeUnit = TimeUnit.Month)
      .encodeY(field = "precipitation", `type` = FieldType.Quantitative, aggregate = AggOp.Mean)
      .html
      .browse
  }

  "gallery 4" in {
    plot
      .vega()
      .data(DemoData.Weather)
      .mark(Mark.Line)
      .encodeX(field = "date", `type` = FieldType.Temporal, timeUnit = TimeUnit.YearMonth)
      .encodeY(field = "temp_max", `type` = FieldType.Quantitative, aggregate = AggOp.Max)
      .html
      .browse
  }

  "gallery 5" in {
    plot.vega
      .data(DemoData.Weather)
      .mark(Mark.Line)
      .encodeX(field = "date", `type` = FieldType.Temporal, timeUnit = TimeUnit.Year)
      .encodeY(field = "temp_max", `type` = FieldType.Quantitative, aggregate = AggOp.Max)
      .html
      .browse
  }

  "gallery 6" in {
    plot.vega
      .data(DemoData.Weather)
      .calculate("datum.temp_max - datum.temp_min", "temp_range")
      .mark(Mark.Line)
      .encodeX(field = "date", `type` = FieldType.Temporal, timeUnit = TimeUnit.Month)
      .encodeY(field = "temp_range", `type` = FieldType.Quantitative, aggregate = AggOp.Mean)
      .html
      .browse
  }

  "gallery 7" in {
    plot.vega
      .data(DemoData.Weather)
      .mark(Mark.Bar)
      .encodeX(field = "date", `type` = FieldType.Ordinal, timeUnit = TimeUnit.Month)
      .encodeY(`type` = FieldType.Quantitative, aggregate = AggOp.Count)
      .encodeColor(field = "weather", `type` = FieldType.Nominal)
      .html
      .browse
  }

  "gallery 8" in {
    plot.vega
      .data(DemoData.Weather)
      .mark(Mark.Bar)
      .encodeX(field = "date",
               `type` = FieldType.Ordinal,
               timeUnit = TimeUnit.Month,
               axis = Axis(title = "Month of the year"))
      .encodeY(`type` = FieldType.Quantitative, aggregate = AggOp.Count)
      .encodeColor(
        field = "weather",
        `type` = FieldType.Nominal,
        scale = Scale(domain = Seq("sun", "fog", "drizzle", "rain", "snow"),
                      range = Seq("#e7ba52", "#c7c7c7", "#aec7e8", "#1f77b4", "#9467bd")),
        legend = Legend("Weather type")
      )
      .html
      .browse
  }

}
