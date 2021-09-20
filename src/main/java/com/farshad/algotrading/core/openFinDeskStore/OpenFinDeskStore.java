package com.farshad.algotrading.core.openFinDeskStore;

 import com.farshad.algotrading.core.sockets.SocketUtil;
import org.ta4j.core.TimeSeries;


public abstract class OpenFinDeskStore {

    public abstract void initialize(String name,String timeFrame,String financialMarket,SocketUtil socketUtil);

    public abstract void fetc