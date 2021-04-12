package com.farshad.algotrading.backtesting;

import com.farshad.algotrading.core.Symbol;
import com.farshad.algotrading.core.openFinDeskStore.influxdb.InfluxDB;
import org.apache.log4j.Logger;
import org.ta4j.core.TimeSeries;

import java.io.IOException;
import java.net.ServerSocket;
/**
 * @author Farshad Noravesh
 */
public class FetchingForexBacktest extends BackTest {
    final static Logger logger= Logger.getLogger(FetchingForexBacktest.class);

    private ServerSocket ss;

    public FetchingForexBacktest() throws IOException {
    }

    @Override
    public void begin() throws IOException {
        ss = new ServerSocket(5555);

        InfluxDB influxDB=new InfluxDB();
 