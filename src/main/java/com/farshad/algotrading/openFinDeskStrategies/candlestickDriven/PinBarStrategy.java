package com.farshad.algotrading.openFinDeskStrategies.candlestickDriven;

import com.farshad.algotrading.core.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.Callable;

public class PinBarStrategy extends OpenFinDeskStrategy {
    final static Logger logger= Logger.getLogger(PinBarStrategy.class);

    @Override
    public Callable<OpenFinDeskOrder> define() throws IOException {
        OpenFinDeskOrder openFinDeskOrder=new OpenFinDeskOrder(series.getName());
        openFinDeskOrder.setSymbol(series.getName());
        openFinDeskOrder.setStrategyName("PinBarStrategy");
        openFinDeskOrder.setPosition("*");

        int index=series.getBarCount();
        double bodyLength=series.g