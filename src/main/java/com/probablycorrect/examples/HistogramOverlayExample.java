package com.probablycorrect.examples;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Marker;
import tech.tablesaw.plotly.traces.HistogramTrace;
import tech.tablesaw.table.TableSliceGroup;

/** */
public class HistogramOverlayExample {

  public static void main(String[] args) throws Exception {
    Table baseball = Table.read().csv("data/baseball.csv");

    Layout layout =
        Layout.builder()
            .title("Distribution of team batting averages")
            .barMode(Layout.BarMode.OVERLAY)
            .showLegend(true)
            .build();

    TableSliceGroup groups = baseball.splitOn("league");
    Table t1 = groups.get(0).asTable();

    HistogramTrace trace1 =
        HistogramTrace.builder(t1.nCol("BA"))
            .name("American Leage")
            .opacity(.75)
            .nBinsX(24)
            .marker(Marker.builder().color("#FF4136").build())
            .build();

    Table t2 = groups.get(1).asTable();
    HistogramTrace trace2 =
        HistogramTrace.builder(t2.nCol("BA"))
            .name("National League")
            .opacity(.75)
            .nBinsX(24)
            .marker(Marker.builder().color("#7FDBFF").build())
            .build();

    Plot.show(new Figure(layout, trace1, trace2));
  }
}