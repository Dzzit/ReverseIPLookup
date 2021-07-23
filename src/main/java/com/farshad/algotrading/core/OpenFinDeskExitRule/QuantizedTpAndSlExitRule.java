package com.farshad.algotrading.core.OpenFinDeskExitRule;


import org.apache.log4j.Logger;

import static org.apache.commons.math3.util.Precision.round;

public class QuantizedTpAndSlExitRule extends OpenFinDeskExitRule {
    final static Logger logger= Logger.getLogger(QuantizedTpAndSlExitRule.class);

    private String quantizedExitRuleAction;

    @Override
    public void applyExitRule() {
        int lastIndex=series.getBarCount()-1;
        double price=0.5*(series.getBar(lastIndex).getClosePrice().doubleValue()+series.getBar(lastIndex).getOpenPrice().doubleValue());
        logger.info("symbol="+ getOpenFinDeskOrder().getSymbol());
        logger.info("price="+price);
        logger.info("orderType="+ getOpenF