package com.farshad.algotrading.core.fibonacciCore;

import com.farshad.algotrading.core.trendRangeAndWave.Trend;
import com.farshad.algotrading.core.trendRangeAndWave.Wave;
import org.apache.log4j.Logger;

import java.util.*;

public class Fibonacci {

    final static Logger logger= Logger.getLogger(Fibonacci.class);

    private List<Double> internalRetracementLevels=new ArrayLis