package com.university.forecast;

import java.awt.Color;
import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;

public class Charts extends ApplicationFrame {

    private static final long serialVersionUID = 1L;

    public Charts(final String chartTitle, double[] similarityValues) {
        super(chartTitle);

        final JFreeChart jFreeChart = putContentOfChart(similarityValues);
        putDesignOfChart(jFreeChart);

        final ChartPanel chartPanel = new ChartPanel(jFreeChart);
        setContentPane(chartPanel);
    }

    private JFreeChart putContentOfChart(double[] similarityValues) {
        final XYSeries series = new XYSeries("");

        for (int i = 0; i < similarityValues.length; i++) {
            series.add(i, similarityValues[i]);
        }

        XYSeriesCollection data = new XYSeriesCollection(series);
        return ChartFactory.createXYLineChart("Similarity Forecast Simulator", "Step", "Similarity", data, PlotOrientation.VERTICAL, true, true, false);
    }

    private void putDesignOfChart(final JFreeChart chart) {
        String fontName = "Lucida Sans";
        StandardChartTheme theme = (StandardChartTheme) org.jfree.chart.StandardChartTheme.createJFreeTheme();

        theme.setTitlePaint(Color.decode("#4572a7"));
        theme.setExtraLargeFont(new Font(fontName, Font.PLAIN, 16));
        theme.setLargeFont(new Font(fontName, Font.BOLD, 15));
        theme.setRegularFont(new Font(fontName, Font.PLAIN, 11));
        theme.setRangeGridlinePaint(Color.decode("#C0C0C0"));
        theme.setPlotBackgroundPaint(Color.white);
        theme.setChartBackgroundPaint(Color.white);
        theme.setGridBandPaint(Color.red);
        theme.setAxisOffset(new RectangleInsets(0, 0, 0, 0));
        theme.setBarPainter(new StandardBarPainter());
        theme.setAxisLabelPaint(Color.decode("#666666"));
        theme.apply(chart);
    }
}