package com.farshad.algotrading.backtesting.ExpectationMaximizationAlgorithm;

import org.apache.log4j.Logger;

public class ExpectationMaximization {

    final static Logger logger= Logger.getLogger(ExpectationMaximization.class);


    private String probabilityType;

    private double meanOfb;
    private double meanOfa;

    private double varianceOfb;
    private double varianceOfa;


    private double[] probabilityOfxConditionedOnb;

   