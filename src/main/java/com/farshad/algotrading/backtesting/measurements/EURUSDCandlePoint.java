package com.farshad.algotrading.backtesting.measurements;


import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.TimeSeriesPoint;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "EURUSD")
 public class EURUSDCandlePoint extends TimeSeriesPoint {


    @Column(name = "open")
    private double open;

    @Column(name = "high")
    private do