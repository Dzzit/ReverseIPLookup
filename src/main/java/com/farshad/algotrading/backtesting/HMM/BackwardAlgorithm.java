package com.farshad.algotrading.backtesting.HMM;

import com.farshad.algotrading.backtesting.ExpectationMaximizationAlgorithm.ExpectationMaximization;
import org.apache.log4j.Logger;

public class BackwardAlgorithm {

    final static Logger logger= Logger.getLogger(BackwardAlgorithm.class);


    private int numberOfHiddenStates;

    private int numberOfValuesInEachHiddenState;

    private double x[];


    private double beta00;

    private  double beta01;


    private double[][] transitionProbability;

    private int batchSize;



    private  ExpectationMaximization expectationMaximization;


    public BackwardAlgorithm(int numberOfHiddenStates, int numberOfValuesInEachHiddenState,int numberOfObservationData) {
        this.numberOfHiddenStates = numberOfHiddenStates;
        this.numberOfValuesInEachHiddenState = numberOfValuesInEachHiddenState;
        x=new double[numberOfObservationData];
          transitionProbability=new double[numberOfHiddenStates][numberOfHiddenStates];
    }

    public void runHMM(double[] x, int batchSize) {
        for(int i=0;i<x.length;i++){
            this.x[i]=x[i];
            logger.info("x["+i+"]="+x[i]);
        }
        this.batchSize=batchSize;

        calculateEmissionProbability();
        calculateTransitionProbability();
    }

    public double beta00(double observation){
        double pxConditionedOnaAtSpecificObservation=(1/Math.sqrt((2*Math.PI*expectationMaximization.getVarianceOfa()))) * Math.exp(-Math.pow(observation - expectationMaximization.getMeanOfa(), 2) / (2 * expectationMaximization.getVarianceOfa()));
        double pxConditionedOnbAtSpecificObservation=(1/Math.sqrt((2*Math.PI*expectationMaximization.getVarianceOfb()))) * Math.exp(-Math.pow(observation - expectationMaximization.getMeanOfb(), 2) / (2 * expectationMaximization.getVarianceOfb()));
        beta00=1*pxConditionedOnaAtSpecificObservation*transitionProbability[0][0]
              +1*pxConditionedOnbAtSpecificObservation*transitionProbability[1][0];
        return beta00;
    }

    public double beta01(double observation){
        double pxConditionedOnaAtSpecificObservation=(1/Math.sqrt((2*Math.PI*expectationMaximization.getVarianceOfa()))) * Math.exp(-Math.pow(observation - expectationMaximization.getMeanOfa(), 2) / (2 * expectationMaximization.getVarianceOfa()));
        double pxConditionedOnbAtSpecificObservation=(1/Math.sqrt((2*Math.PI*expectationMaximization.getVarianceOfb()))) * Math.exp(-Math.pow(observation - expectationMaximization.getMeanOfb(), 2) / (2 * expectationMaximization.getVarianceOfb()));
        beta01=1*pxConditionedOnaAtSpecificObservation