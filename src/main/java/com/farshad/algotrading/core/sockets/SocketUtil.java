package com.farshad.algotrading.core.sockets;

import com.farshad.algotrading.OpenFinDesklogLevels.LiveTradingLogLevel;
import com.google.gson.Gson;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.OHLCData;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.OpenFinDeskMessage;
import org.apache.log4j.Logger;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketUtil {

    final static Logger logger= Logger.getLogger(SocketUtil.class);


    private Socket client;

    priva