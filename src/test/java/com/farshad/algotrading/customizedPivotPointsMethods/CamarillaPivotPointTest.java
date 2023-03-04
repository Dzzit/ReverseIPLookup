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
        timeSeries1=new BaseTimeSeries.SeriesBuilder().withName("EU