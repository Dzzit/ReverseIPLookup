/*
package com.farshad.algotrading.openFinDeskStrategies.statisticalArbitrageBasedOnKalmanFilter;

import org.apache.log4j.Logger;
import org.ta4j.com.farshad.algotrading.containerCore.TimeSeriesPoint;
import org.ta4j.com.farshad.algotrading.containerCore.TradingRecord;
import com.farshad.algotrading.containerCore.Symbol;

import java.io.IOException;

public class Process {
    private static Logger LOGGER= Logger.getLogger(Process.class);

    boolean mReinvest = false;

    String mX, mY;
    //TradingContext mContext;
    Cointegration mCoint;

    TimeSeriesPoint mAlpha;
    TimeSeriesPoint mBeta;
    TimeSeriesPoint mXs;
    TimeSeriesPoint mYs;
    TimeSeriesPoint mError;
 