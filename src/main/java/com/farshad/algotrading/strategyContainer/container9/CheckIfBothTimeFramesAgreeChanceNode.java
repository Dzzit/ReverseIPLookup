/*
package com.farshad.algotrading.strategyContainer.container9;

 import com.farshad.algotrading.openFinDeskAnnotations.OpenFinDeskChanceNode;
 import com.farshad.algotrading.openFinDeskStrategies.fibonacciBased.TrendStrengthStrategyBasedOnInternalRetracementSequences;
 import org.apache.log4j.Logger;
 import com.farshad.algotrading.core.containerCore.ChanceNode;

 @OpenFinDeskChanceNode(containerId=9,nodeId=1
        ,openfindeskStrategies={TrendStrengthStrategyBasedOnInternalRetracementSequences.class, TrendStrengthStrategyBasedOnInternalRetracementSequences.class}
        ,timeFrames={"PERIOD_H1","PERIOD_D1"})

 public class CheckIfBothTimeFramesAgreeChanceNode extends ChanceNode {
    final static Logger logger= Logger.getLogger(CheckIfBothTimeFramesAgreeChanceNode.class);

    @Override
    public void e