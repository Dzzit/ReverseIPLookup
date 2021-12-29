package com.farshad.algotrading.core.trendRangeAndWave;

import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PriceTime;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TrendGenerator {
    final static Logger logger= Logger.getLogger(TrendGenerator.class);

    private int startingIndex;
    private List<PriceTime> priceTimeChangePointList;

    private List<Trend> trendList=new ArrayList<>();


    public TrendGenerator(List<PriceTime> pri