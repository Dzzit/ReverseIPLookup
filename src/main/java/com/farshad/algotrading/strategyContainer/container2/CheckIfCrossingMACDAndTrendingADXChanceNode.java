package com.farshad.algotrading.strategyContainer.container2;

import com.farshad.algotrading.openFinDeskAnnotations.OpenFinDeskChanceNode;
import com.farshad.algotrading.openFinDeskStrategies.indicatorBased.ADXBasedTrendDetection;
import com.farshad.algotrading.openFinDeskStrategies.indicatorBased.MACDbasedCrossingStrategy;
import com.farshad.algotrading.core.containerCore.ChanceNode;
import org.apache.log4j.Logger;

@OpenFinDeskChanceNode(containerId=2,nodeId=0
        ,openfindeskStrategies={MACDbasedCrossingStrategy.class, ADXBasedTrendDetection.class}
        ,timeFrames={"PERIOD_H1","PERIOD_D1"})
public class CheckIfCrossingMACDAndTrendingADXChanceNode extends 