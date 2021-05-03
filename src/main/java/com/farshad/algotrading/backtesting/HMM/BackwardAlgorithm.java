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


    public BackwardAlgorithm(int numberOfHiddenSt