package com.probablycorrect.examples;

import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.HistogramTrace;

/** */
public class HistogramExample {

  public static void main(String[] args) throws Exception {
    Table baseball = Table.read().csv("data/baseball.csv");

    Layout layout = Layout.builder().title("Distribution of team batting averages").build();
    HistogramTrace trace = HistogramTrace.builder(baseball.nCol("BA")).build();

    Plot.show(new Figure(layout, trace));
    
  }
}