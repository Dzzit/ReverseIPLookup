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

        InfluxDB influxDB=new Influx