package com.farshad.algotrading.openFinDeskStrategies.indicatorBased;

import com.farshad.algotrading.core.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import org.ta4j.core.indicators.RSIIndicator;
import org.ta4j.core.indicators.helpers.ClosePriceIndicator;

import java.io.IOException;
import java.util.concurrent.Callable;

public class RSIStrategy extends OpenFinDeskStrategy {



    @Override
    public Callable<OpenFinDeskOrder> define() throws IOException {
        int index=series.getBarCount();
        OpenFinDeskOrder openFinDeskOrder=new OpenFinDeskOrder(series.getName());
        openFinDeskOrder.setSymbol(series.getName());
        openFinDeskOrder.setStrategyName("RSIStrategy");
        openFinDeskOrder.setPosition("*");
        openFinDeskOrder.setVolume("0.01");
        openFinDeskOrder.setPrice(0.5*(series.getBar(index-1).getClosePrice().doubleValue()+
                series.getBar(index-1).getOpenPrice().doubleValue()));


        ClosePriceIndicator closePrice = new ClosePriceIndicator(series);
     