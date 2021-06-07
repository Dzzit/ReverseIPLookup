package com.farshad.algotrading.backtesting;

import com.farshad.algotrading.backtesting.HMM.BackwardAlgorithm;
import com.farshad.algotrading.backtesting.HMM.RegimeAnalyzer;
import com.farshad.algotrading.backtesting.measurements.AUDUSDCandlePoint;
import com.farshad.algotrading.backtesting.influxDbCRUD.InfluxDbManager;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PercentOfChange;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.Return;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.OHLCData;
import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Farshad Noravesh
 */
public class HMMBackTest extends BackTest{

    final static Logger logger= Logger.getLogger(HMMBackTest.class);


    public HMMBackTest() throws IOException {
    }

    public void begin()  {
        System.out.println("------com.farshad.algotrading.backtesting-------");
        List<OHLCData> allOhlcDataList=new ArrayList<>();
        int batchSize=6;
        int howManyBatches=90;
        int totalCandles=howManyBatches*batchSize;
        for(int i=1;i<totalCandles;i=i+batchSize) {
            fetchDataUsingMetaTrader5("EURUSD", "PERIOD_H4",i-1,batchSize);
            allOhlcDataList.addAll(getOhlcDataList());
        }

        InfluxDbManager influxDbManager=new InfluxDbManager<AUDUSDCandlePoint>("PERIOD_H4","EURUSD");
        influxDbManager.writeCandles(allOhlcDataList);

        String query="SELECT * FROM "+influxDbManager.getMeasurement();
        List<AUDUSDCandlePoint> candlePointList=influxDbManager.executeSomeQuery(query, AUDUSDCandlePoint.class);

        //  candlePointList.stream().forEach(candle-> System.out.println("candle.getClose():"+candle.getClose()));
        influxDbManager.close();

        RegimeAnalyzer regimeAnalyzer=new RegimeAnalyzer();
        regimeAnalyzer.classifyTrends(candlePointList);
        influxDbManager=new InfluxDbManager<PercentOfChange>("H4","EURUSDChangeInPercent");
        try {
            influxDbManager.writeTimeSeries(regimeAnalyzer.getPercentageChange(),"percent");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        query="SELECT * FROM "+influxDbManager.getMeasurement();
        influxDbManager.executeSomeQuery(query,PercentOfChange.class);
        influxDbManager.close();

        //Now writing extreme to influxDb
        influxDbManager=new InfluxDbManager<AUDUSDCandlePoint>("H4","EURUSDExtreme");
        try {
            influxDbManag