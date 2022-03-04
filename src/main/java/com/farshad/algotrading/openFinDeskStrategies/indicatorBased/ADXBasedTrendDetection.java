package com.farshad.algotrading.openFinDeskStrategies.indicatorBased;

import com.farshad.algotrading.core.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskStrategies.CrossingTimeSeriesDetector;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import org.apache.log4j.Logger;
import org.ta4j.core.indicators.ParabolicSarIndicator;
import org.ta4j.core.indicators.adx.ADXIndicator;
import org.ta4j.core.indicators.adx.MinusDIIndicator;
import org.ta4j.core.indicators.adx.PlusDIIndicator;


import java.io.IOException;
import java.util.concurrent.Callable;

public class ADXBasedTrendDetection extends OpenFinDeskStrategy {


    final static Logger logger= Logger.getLogger(ADXBasedTrendDetection.class);


    @Override
    public Callable<OpenFinDeskOrder> define() throws IOException {
        int index=series.getBarCount();

         int big=20;

        ParabolicSarIndicator parabolicSarIndicator=new ParabolicSarIndicator(series);


        ADXIndicator adxIndicator=new ADXIndicator(series,14);
        PlusDIIndicator plusDIIndicator=new PlusDIIndicator(series,14);
        MinusDIIndicator minusDIIndicator=new MinusDIIndicator(series,14);



        int horizen=5;
        double[] plusDIIndicatorArray = new double[horizen];
        double[] minusDIIndicatorArray = new double[horizen];
        int j=0;
        for(int i=index-horizen;i<index;i++){
            plusDIIndicatorArray[j]= plusDIIndicator.getValue(i).doubleValue();
            minusDIIndicatorArray[j]= minusDIIndicator.getValue(i).doubleValue();
            j++;
        }

        CrossingTimeSeriesDetector crossUpDetector=new CrossingTimeSeriesDetector(plusDIIndicatorArray,minusDIIndicatorArray);
        String statusForCrossUp=crossUpDetector.detect(horizen);

        CrossingTimeSeriesDetector crossDownDetector=new CrossingTimeSeriesDetector(minusDIIndicatorArray,plusDIIndicatorArray);
        String statusForCrossDown=crossDownDetector.detect(horizen);

        logger.info("crossUpDetector: status in ADXBasedTrendDetection:"+statusForCrossUp+" ,crossPoint="+crossUpDetector.getCrossPoint());
        logger.info("crossDownDetector: status in ADXBasedTrendDetection:"+statusForCrossDown+" ,crossPoint="+crossDownDetector.getCrossPoint());


        for(int i=index-1;i>index-2;i--){
            logger.info("symbol:"+series.getName()+",14-ticks-ADXIndicator value at the "+i+"th index: " + adxIndicator.getValue(i).doubleValue());
         }

        start();

        OpenFinDeskOrder openFinDeskOrder=new OpenFinDeskOrder(series.getName());
        openFinDeskOrder.setSymbol(series.getName());
        openFinDeskOrder.setStrategyName("ADXBasedTrendDetection");
        openFinDeskOrder.setPosition("*");
        openFinDeskOrder.setVolume("0.01");
        logger.info("symbol:"+series.getName()+",plusDIIndicator.getValue(index-1).dou