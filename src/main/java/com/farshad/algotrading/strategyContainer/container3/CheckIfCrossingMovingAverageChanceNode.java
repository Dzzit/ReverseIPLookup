package com.farshad.algotrading.strategyContainer.container3;


import com.farshad.algotrading.openFinDeskAnnotations.OpenFinDeskChanceNode;
import com.farshad.algotrading.openFinDeskStrategies.indicatorBased.ADXBasedTrendDetection;
import com.farshad.algotrading.openFinDeskStrategies.indicatorBased.CrossingTwoMovingAverages;
import com.farshad.algotrading.core.containerCore.ChanceNode;
import org.apache.log4j.Logger;

@OpenFinDeskChanceNode(containerId=3,nodeId=0
        ,openfindeskStrategies={CrossingTwoMovingAverages.class,ADXBasedTrendDetection.class}
        ,ti