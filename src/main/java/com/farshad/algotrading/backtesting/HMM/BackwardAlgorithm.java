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

        calculateEmiss