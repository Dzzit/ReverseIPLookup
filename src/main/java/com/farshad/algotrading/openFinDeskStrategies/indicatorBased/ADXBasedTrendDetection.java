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
        int index=series.getBarCou