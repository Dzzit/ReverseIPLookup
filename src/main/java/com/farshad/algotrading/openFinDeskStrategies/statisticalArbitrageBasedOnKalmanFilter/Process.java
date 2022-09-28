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
    TimeSeriesPoint mVariance;
    TimeSeriesPoint mModel;

    TimeSeriesPoint series;
    TradingRecord tradingRecord;

    public Process(TimeSeriesPoint series, TradingRecord tradingRecord) {
        this.series = series;
        this.tradingRecord = tradingRecord;
    }

    public void initialize() throws IOException {
        //mContext = context;

        mCoint = new Cointegration(1e-10, 1e-7);
        mAlpha=new Symbol("alpha").getSeriesFromFile("/src/main/java/files/sarood-M1.csv");
        mBeta=new Symbol("beta").getSeriesFromFile("/src/main/java/files/sarood-M1.csv");
        mXs=new Symbol("mXs").getSeriesFromFile("/src/main/java/files/sarood-M1.csv");
        mYs=new Symbol("mYs").getSeriesFromFile("/src/main/java/files/sarood-M1.csv");
        mError=new 