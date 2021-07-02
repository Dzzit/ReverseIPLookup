package com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements;

 import org.influxdb.annotation.Column;
 import org.influxdb.annotation.Measurement;

 import java.time.Instant;


@Measurement(name = "priceTime")
public class PriceTime extends TimeSeriesPoint {


    @Column(name = "price")
    private double price;

    privat