package com.farshad.algotrading.core.trendRangeAndWave;

import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PriceTime;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * @author farshad noravesh
 * @since version 1.0.0
 */
public class Trend {
    final static Logger logger= Logger.getLogger(TrendGenerator.class);

     private String trendType;      //upward or downward

     private List<PriceTime> priceTimePoints;

    public Trend(String trendType, List<PriceTime> priceTimePoints) 