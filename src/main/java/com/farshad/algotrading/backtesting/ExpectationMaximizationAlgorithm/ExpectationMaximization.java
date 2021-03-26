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

    private double[] probabilityOfbConditionedOnx;

    private double[] probabilityOfaConditionedOnx;

    private double[] probabilityOfxConditionedOna;

    private int batchSizeOfx;



    private double probabilityOfb;

    private double probabilityOfa;

    public ExpectationMaximization(String probabilityType, int batchSize) {
        batchSizeOfx=batchSize;
        this.probabilityType=probabilityType;
        probabilityOfxConditionedOnb=new double[batchSizeOfx];
        probabilityOfxConditionedOna=new double[batchSizeOfx];
        probabilityOfbConditionedOnx=new double[batchSizeOfx];
        prob