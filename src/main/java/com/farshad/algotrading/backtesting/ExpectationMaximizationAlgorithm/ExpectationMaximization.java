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
        probabilityOfaConditionedOnx=new double[batchSizeOfx];
    }

    public void initializeMeanAndVariance() {
        probabilityOfb=0.5;
        probabilityOfa=1-probabilityOfb;
        meanOfb=1.2;
        meanOfa=1.4;
        varianceOfb=0.1;
        varianceOfa=0.1;
    }

    public void findMeanAndVariance(double[] batchedx) {
         expectationStep(batchedx);
        maximizationStep(batchedx);
    }


    private void expectationStep(double[] batchedx) {
        for(int i=0;i<batchSizeOfx;i++){
            probabilityOfxConditionedOna[i]= (1 / Math.sqrt(2*Math.PI*varianceOfa)) * Math.exp(-Math.pow(batchedx[i] - meanOfa, 2) / (2 * varianceOfa));
            probabilityOfxConditionedOnb[i] = (1 / Math.sqrt(2*Math.PI*varianceOfb)) * Math.exp(-Math.pow(batchedx[i