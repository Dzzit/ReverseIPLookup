package com.farshad.algotrading.backtesting;

import com.farshad.algotrading.core.AlternatingTrendSmoothing.ATS;
import com.farshad.algotrading.backtesting.influxDbCRUD.InfluxDbManager;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PriceTime;
import com.farshad.algotrading.core.Symbol;
import com.farshad.algotrading.core.openFinDeskStore.influxdb.InfluxDB;
import org.apache.log4j.Logger;
import org.ta4j.core.TimeSeries;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Farshad Noravesh
 */
public class ATSBackTest extends BackTest {

    final static Logger logger= Logger.getLogger(ATSBackTest.class);
    private ServerSocket ss;


    public ATSBackTest() throws IOException {

    }

    @Override
    public void begin() throws IOException {
        logger.info("*******ATSBackTest************");
         ss = new ServerSocket(5555);

        InfluxDB influxDB=new InfluxDB();
        Symbol<InfluxDB> eurusdSymbol = new Symbol<InfluxDB>(influxDB,"EURUSD", new String[]{"PERIOD_H1","PERIOD_D1"}, "forex",ss);
        Symbol<InfluxDB> audusdSymbol = new Symbol<InfluxDB>(influxDB,"AUDUSD", new String[]{"PERIOD_H1","PERIOD_D1"}, "forex",ss);
        Symbol<InfluxDB> gbpusdSymbol = new Symbol<InfluxDB>(influxDB,"GBPUSD", new String[]{"PERIOD_H1","PERIOD_D1"}, "forex",ss);


        //audusdSymbolD1.fetchCandlesFromMT5AndWriteItToOpenFinDeskStore();
        audusdSymbol.fetchCandlesFromMT5AndWriteItToOpenFinDeskStore(30);

        //TimeSeries series=audusdSymbolD1.getSeries();
        TimeSeries series=audusdSymbol.getSeries()[0];

        List<PriceTime> priceTimeList=new ArrayList<>();
        int index=series.getBarCount();
        for(int i=index-25;i<index;i++){
            priceTimeList.add(n