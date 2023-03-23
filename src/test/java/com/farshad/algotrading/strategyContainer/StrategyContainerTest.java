
/*
package com.farshad.algotrading.strategyContainer;

import com.farshad.algotrading.containerCore.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import com.farshad.algotrading.openFinDeskStrategies.candlestickDriven.PinBarStrategy;
import com.farshad.algotrading.openFinDeskStrategies.fibonacciBased.TrendStrengthStrategyBasedOnInternalRetracementSequences;
import com.farshad.algotrading.core.containerCore.ChanceNode;
import com.farshad.algotrading.core.containerCore.DecisionTree;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.*;
import org.ta4j.containerCore.BaseTimeSeries;
import org.ta4j.containerCore.TimeSeries;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("testing all containers")
public class StrategyContainerTest {

    final static Logger logger= Logger.getLogger(StrategyContainerTest.class);


    DecisionTree decisionTree;
    OpenFinDeskOrder openFinDeskOrder;
    List<OpenFinDeskOrder> orderList;
    TimeSeries timeSeries1;
    TimeSeries timeSeries2;

    @BeforeAll
    static void setup() {
        logger.info("@BeforeAll - executes once before all test methods in this class");
    }

    @BeforeEach
    void init() {
        openFinDeskOrder=new OpenFinDeskOrder("EURUSD");
        orderList=new ArrayList<>();
        timeSeries1=new BaseTimeSeries.SeriesBuilder().withName("EURUSD").build();
        timeSeries2=new BaseTimeSeries.SeriesBuilder().withName("EURUSD").build();
        ZonedDateTime endTime = ZonedDateTime.now();
        timeSeries1.addBar(endTime, 105.42, 112.99, 104.01, 111.42, 1337);
        timeSeries1.addBar(endTime.plusDays(1), 111.43, 112.83, 107.77, 187.99, 1234);
        timeSeries1.addBar(endTime.plusDays(2), 107.90, 117.50, 107.90, 175.42, 4242);
        timeSeries1.addBar(endTime.plusDays(3), 147.90, 117.50, 107.90, 145.42, 4242);
        timeSeries1.addBar(endTime.plusDays(4), 157.90, 117.50, 107.90, 145.42, 4242);
        timeSeries1.addBar(endTime.plusDays(5), 167.90, 117.50, 107.90, 195.42, 4242);
        timeSeries1.addBar(endTime.plusDays(6), 177.90, 117.50, 107.90, 185.42, 4242);