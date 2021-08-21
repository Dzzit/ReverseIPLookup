package com.farshad.algotrading.core.fibonacciCore;

import com.farshad.algotrading.core.trendRangeAndWave.Trend;
import com.farshad.algotrading.core.trendRangeAndWave.Wave;
import org.apache.log4j.Logger;

import java.util.*;

public class Fibonacci {

    final static Logger logger= Logger.getLogger(Fibonacci.class);

    private List<Double> internalRetracementLevels=new ArrayList<>();
    private List<Double> externalRetracementLevels=new ArrayList<>();
    private List<Double> extensionLevels=new ArrayList<>();
    private List<Double> projectionLevels=new ArrayList<>();


    private List<Double> quantizedInternalRetracementList=new ArrayList<>();
    private List<Double> quantizedExternalRetracementList=new ArrayList<>();
    private List<Double> quantizedExtensionList=new ArrayList<>();
    private List<Double> quantizedProjectionList=new ArrayList<>();


    private double strength;

    public Fibonacci() {
        internalRetracementLevels.add(0.382);
        internalRetracementLevels.add(0.5);
        internalRetracementLevels.add(0.618);

        externalRetracementLevels.add(1.272);
        externalRetracementLevels.add(1.618);
        externalRetracementLevels.add(2.618);

        extensionLevels.add(1.272);
        extensionLevels.add(1.618);

        projectionLevels.add((double) 1);
        projectionLevels.add(1.618);
    }



    private List<Wave> waveList;

    private List<Trend> trendList;

    private String   typeOfGlobalRegime;

    public void addWaves(List<Wave> waveList){
        this.trendList=new ArrayList<>();
        this.waveList=waveList;
        logger.info("waveList.size()="+waveList.size());
        for(int i=0;i<waveList.size();i++){
            trendList.add(waveList.get(i).getFirstTrend());
            trendList.add(waveList.get(i).getSecondTrend());
        }
    }

    public void addTrend(Trend trend){
        trendList.add(trend);
        logger.info("trendList.size()="+trendList.size());
     }

    public void calculateTypeOfGlobalRegime() {
        typeOfGlobalRegime="ranging";
        boolean waveIsIncreasing=false;
        boolean waveIsDecreasing=false;

        if (waveList.size()==0){
            String trendType=trendList.get(0).getTrendType();
            if(trendType.equals("upward")){
                typeOfGlobalRegime="increasing";
            }else if(trendType.equals("downward")){
                typeOfGlobalRegime="decreasing";
            }
            return;
        }

        if (waveList.get(0).getTypeOfWave().equals("increasing")){
            waveIsIncreasing=true;
        }else if (waveList.get(0).getTypeOfWave().equals("decreasing")){
            waveIsDecreasing=true;
        }else{
            return;
        }

        for(int i=1;i<waveList.size();i++){
            waveIsIncreasing=waveList.get(i).getTypeOfWave().equals("increasing")&&waveIsIncreasing;
            waveIsDecreasing=waveList.get(i).getTypeOfWave().equals("decreasing")&&waveIsDecreasing;
        }

        if (waveIsIncreasing){
            typeOfGlobalRegime="increasing";
        }else if(waveIsDecreasing){
            typeOfGlobalRegime="decreasing";
        }else{
            typeOfGlobalRegime="ranging";
        }

     }


    public void calculateInternalRetracement() {
        double differenceForTrend1=0;
        double differenceForTrend2=0;
        double actualRatio=0;
        for(int i=0;i<waveList.size();i++){
            diffe