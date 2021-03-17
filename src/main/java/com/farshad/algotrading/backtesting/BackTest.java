package com.farshad.algotrading.backtesting;

import com.farshad.algotrading.core.sockets.SocketUtil;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.OHLCData;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Farshad Noravesh
 */
public abstract class BackTest {

        private ServerSocket ss;
        private SocketUtil socketUtil;
        private List<OHLCData> ohlcDataList;

        protected BackTest() throws IOException {
              //  ss=new ServerSocket(5555);
              //  socketUtil=new SocketUtil(ss,new Socket());
                 ohlcDataList=new ArrayList<>();

        }

