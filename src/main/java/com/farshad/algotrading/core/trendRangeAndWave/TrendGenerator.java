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


    public TrendGenerator(List<PriceTime> priceTimeChangePointList) {
       this.priceTimeChangePointList=priceTimeChangePointList;
    }

    public List<Trend> generate(){
        priceTimeChangePointList.stream().forEach(priceTime -> {
            logger.info("priceTimeChangePointList:"+priceTime.getPrice()+" ,"+priceTime.getTime());
        });

        double difference=0;

        for(int i=0;i<priceTimeChangePointList.size()-1;i++){
            List<PriceTime> priceTimes=new ArrayList<>();

            PriceTime currentPriceTime=priceTimeChangePointList.get(i);
            PriceTime nextPriceTime=priceTimeChan