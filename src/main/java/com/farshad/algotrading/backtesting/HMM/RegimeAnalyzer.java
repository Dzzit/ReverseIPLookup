package com.farshad.algotrading.backtesting.HMM;

import com.farshad.algotrading.backtesting.measurements.AUDUSDCandlePoint;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PercentOfChange;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.Return;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RegimeAnalyzer {

    final static Logger logger= Logger.getLogger(RegimeAnalyzer.class);


    private double[] difference=new double[0];
    private double[] trendCloseDifferenceForExtreme=new