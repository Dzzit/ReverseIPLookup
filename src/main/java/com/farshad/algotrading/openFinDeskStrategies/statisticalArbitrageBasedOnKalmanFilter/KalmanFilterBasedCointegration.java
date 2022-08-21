/*
package com.farshad.algotrading.openFinDeskStrategies.statisticalArbitrageBasedOnKalmanFilter;

import com.farshad.algotrading.containerCore.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import org.ta4j.com.farshad.algotrading.containerCore.TimeSeriesPoint;
import org.ta4j.com.farshad.algotrading.containerCore.TradingRecord;

import java.io.IOException;
import java.util.concurrent.Callable;

public class KalmanFilterBasedCointegration extends OpenFinDeskStrategy {

    public KalmanFilterBasedCointegration(TimeSeriesPoint series, TradingR