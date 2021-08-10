package com.farshad.algotrading.core.containerCore;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class XYSeriesDemo extends ApplicationFrame {

    public XYSeries series = new XYSeries("Q action value");




    public XYSeriesDemo(final String title) {
        super(title);
/*
        series.add(1.0,500.2);
        series.add(5.0,694.1);
        series.add(4.0,100.0