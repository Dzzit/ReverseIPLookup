package com.farshad.algotrading.strategyContainer.container3;


import com.farshad.algotrading.openFinDeskAnnotations.OpenFinDeskChanceNode;
import com.farshad.algotrading.openFinDeskStrategies.indicatorBased.ADXBasedTrendDetection;
import com.farshad.algotrading.openFinDeskStrategies.indicatorBased.CrossingTwoMovingAverages;
import com.farshad.algotrading.core.containerCore.ChanceNode;
import org.apache.log4j.Logger;

@OpenFinDeskChanceNode(containerId=3,nodeId=0
        ,openfindeskStrategies={CrossingTwoMovingAverages.class,ADXBasedTrendDetection.class}
        ,timeFrames={"PERIOD_H1","PERIOD_D1"},disabled=true)
public class CheckIfCrossingMovingAverageChanceNode extends ChanceNode {
    final static Logger logger= Logger.getLogger(CheckIf