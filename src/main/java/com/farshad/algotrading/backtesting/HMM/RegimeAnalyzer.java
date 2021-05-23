package com.farshad.algotrading.backtesting.HMM;

import com.farshad.algotrading.backtesting.measurements.AUDUSDCandlePoint;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PercentOfChange;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.Return;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class RegimeAnalyzer {

    final static Logger logger= Logger.getLogger(RegimeAnalyzer.class);


    private double[] difference=new double[0];
    private double[] trendCloseDifferenceForExtreme=new double[0];
    private List<PercentOfChange> percentageChangeList=new ArrayList<>();
    private List<AUDUSDCandlePoint> extremeList=new ArrayList<>();
    private List<Return> returnList=new ArrayList<>();
    private List<Long> duration=new ArrayList<>();

    public void classifyTrends(List<AUDUSDCandlePoint> candlePointList){
        //System.out.println("size of data="+candlePointList.size());
          difference =new double[candlePointList.size()];

        for(int i=0;i<candlePointList.size()-1;i++){
            difference[i]=candlePointList.get(i+1).getClose()-candlePointList.get(i).getClose();
            PercentOfChange percentOfChange=new PercentOfChange();
            percentOfChange.setPercent(((difference[i]/candlePointList.get(i).getClose())*100));
            percentOfChange.setTime(candlePointList.get(i).getTime());

            percentageChangeList.add(percentOfChange);

            if (Math.abs(percentageChangeList.get(i).getPercent())>0.2){
                extremeList.add(candlePointList.get(i));

            }
        }

        trendCloseDifferenceForExtreme=new double[extremeList.size()];

        for(int j=0;j<extremeList.size()-1;j++){
            //System.out.println("extremeList.get("+j+").getClose()="+extremeList.get(j).getClose());
            //System.out.println("extremeList.get("+j+").getTime().getEpochSecond()="+extremeList.get(j).getTime().getEpochSecond());


            trendCloseDifferenceForExtreme[j]=extremeList.get(j+1).getClose()-extremeList.get(j).getClose();

                //System.out.println("trendCloseDifferenceForExtreme["+j+"]="+trendCloseDifferenceForExtreme[j]);
                Return returnPoint=new Return();

                duration.a