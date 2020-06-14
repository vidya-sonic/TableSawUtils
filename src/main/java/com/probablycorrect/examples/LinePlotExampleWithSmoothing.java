package com.probablycorrect.examples;
import tech.tablesaw.api.NumericColumn;
import tech.tablesaw.api.Table;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.components.Line;
import tech.tablesaw.plotly.traces.ScatterTrace;

/** */
public class LinePlotExampleWithSmoothing {

  public static void main(String[] args) throws Exception {
    Table robberies = Table.read().csv("data/boston-robberies.csv");
    NumericColumn<?> x = robberies.nCol("Record");
    NumericColumn<?> y = robberies.nCol("Robberies");

    Layout layout =
        Layout.builder().title("Monthly Boston Armed Robberies Jan. 1966 - Oct. 1975").build();

    ScatterTrace trace =
        ScatterTrace.builder(x, y)
            .mode(ScatterTrace.Mode.LINE)
            .line(Line.builder().shape(Line.Shape.SPLINE).smoothing(1.2).build())
            .build();

    Plot.show(new Figure(layout, trace));
  }
}