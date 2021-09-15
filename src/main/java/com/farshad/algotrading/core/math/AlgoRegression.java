package com.farshad.algotrading.core.math;

import org.apache.commons.math3.stat.regression.SimpleRegression;
import org.apache.log4j.Logger;

import java.util.List;

public class AlgoRegression {

    final static Logger logger= Logger.getLogger(AlgoRegression.class);


    private double slope;
    private double intercept;


    public void comparePairs(List<Double> asset1, List<Double> asset2){

        SimpleRegression regression = new SimpleRegression();
        