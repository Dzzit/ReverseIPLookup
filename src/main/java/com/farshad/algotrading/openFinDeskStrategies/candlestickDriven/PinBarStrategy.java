package com.farshad.algotrading.openFinDeskStrategies.candlestickDriven;

import com.farshad.algotrading.core.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.concurrent.Callable;

public class PinBarStrategy extends OpenFinDeskStrategy {
    final static Logger logger= Logger.getLogger(PinBarStrategy.class);

    @Override
    public Callable<Ope