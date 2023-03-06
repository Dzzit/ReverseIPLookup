package com.farshad.algotrading.customizedPivotPointsMethods;

import com.farshad.algotrading.core.customizedPivotPointMethods.CamarillaPivotPointApproach;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.ta4j.core.BaseTimeSeries;
import org.ta4j.core.TimeSeries;

import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("testing  Camarilla Pivot Point")
public class CamarillaPivotPointTest {
    final static Logger logger= Logger.getLogger(CamarillaPivotPointTest.class);
    TimeSeries timeSeries1;

    @BeforeEach
    void init() {
        timeSeries1=new BaseTimeSeries.SeriesBuilder().withName("EURUSD").build();
         ZonedDateTime endTime = ZonedDateTime.now();
        timeSeries1.addBar(endTime, 105.42, 112.99, 104.01, 111.42, 1337);
        timeSeries1.addBar(endTime.plusDays(1), 111.43, 112.83, 107.77, 187.99, 1234);
        timeSeries1.addBar(endTime.plusDays(2), 1.0790, 1.50, 1.90, 1.42, 200);
        timeSeries1.addBar(endTime.plusDays(3), 147.90, 117.50, 107.90, 145.42, 4242);
        timeSeries1.a