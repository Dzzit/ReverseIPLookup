package com.farshad.algotrading.core.OpenFinDeskExitRule;


import org.apache.log4j.Logger;

import static org.apache.commons.math3.util.Precision.round;

public class QuantizedTpAndSlExitRule extends OpenFinDeskExitRule {
    final static Logger logger= Logger.getLogger(QuantizedTpAndSlExitRule.class);

    private String quantizedExitRuleAction;

 