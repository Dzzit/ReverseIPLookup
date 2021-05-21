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
    private double[] trendCloseDifferenceForExtreme=new double[0];
    private List<PercentOfChange> percentageChangeList=new ArrayList<>();
    private List<AUDUSDCandlePoint> extremeList=new ArrayList<>();
    private List<Return> returnList=new ArrayList<>();
    private List<Long> duration=new ArrayList<>();

    public void classifyTrends(List<AUDUSDCandlePoint> candlePointList){
        //System.out.println