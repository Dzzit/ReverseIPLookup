package com.farshad.algotrading.strategyContainer.container1;

import com.farshad.algotrading.openFinDeskAnnotations.OpenFinDeskChanceNode;
import com.farshad.algotrading.openFinDeskStrategies.candlestickDriven.PinBarStrategy;
import com.farshad.algotrading.openFinDeskStrategies.fibonacciBased.TrendStrengthStrategyBasedOnInternalRetracementSequences;
import org.apache.log4j.Logger;
import com.farshad.algotrading.core.containerCore.ChanceNode;

@OpenFinDeskChanceNode(containerId=1,nodeId=0
,openfindeskStrategies={PinBarStrategy.class,TrendStrengthStrategyBasedOnInternalRetracementSequences.class}
,timeFrames={"PERIOD_H1","PERIOD_D1"},disabled=true)
public class CheckIfWeHavePinBarCandlestickChanceNode extends ChanceNode {
    final static Logger logger= Logger.getLogger(CheckIfWeHave