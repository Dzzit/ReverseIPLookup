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
    public void executeCurrentChanceNode() {
        this.openFinDeskOrder.setPrice(featureVector.get(0).getPrice());
        this.openFinDeskOrder.setStrategyName("no signal from container 9");

        this.openFinDeskOrder.setOpenFinDeskOrderNumber(featureVector.get(0).getOpenFinDeskOrderNumber());
        if ((featureVector.get(0).getPosition().equals(featureVector.get(1).getPosition()))&&(featureVector.get(0).getPosition().equals("buy"))) {
            openFinDeskOrder.setOrderType("openBuy");
            openFinDeskOrder.setPosition("buy");
            openFinDeskOrder.setVolume("0.01");
            openFinDeskOrder.setSymbol(featureVector.get(0).getSymbol());
            openFinDeskOrder.setPrice(featureVector.get(0).getPrice());
            this.openFin