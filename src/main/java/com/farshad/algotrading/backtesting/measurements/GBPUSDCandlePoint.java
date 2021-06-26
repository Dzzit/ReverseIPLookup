package com.farshad.algotrading.backtesting.measurements;


import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.TimeSeriesPoint;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

@Measurement(name = "GBPUSD")
public class GBPUSDCandlePoint extends TimeSeriesPo