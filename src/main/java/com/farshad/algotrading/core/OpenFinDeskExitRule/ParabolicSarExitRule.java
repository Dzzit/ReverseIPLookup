package com.farshad.algotrading.core.OpenFinDeskExitRule;

import org.ta4j.core.indicators.ParabolicSarIndicator;

import static org.apache.commons.math3.util.Precision.round;

public class ParabolicSarExitRule extends OpenFinDeskExitRule {

    @Override
    public void applyExitRule() {
        int lastIndex=series.getBarCount()-1;
         ParabolicSarIndicator parabolicSarIndicator=new ParabolicSarIndicator(ser