
package com.farshad.algotrading.core.openFinDeskStore.csv;

import com.farshad.algotrading.core.openFinDeskStore.OpenFinDeskStore;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.OHLCData;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.TimeParser;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.csv.CSVReader;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.csv.CSVWriter;
import com.farshad.algotrading.core.sockets.SocketUtil;
import org.apache.log4j.Logger;
import org.ta4j.core.BaseTimeSeries;
import org.ta4j.core.TimeSeries;

import java.io.File;
 import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
 import java.util.List;

public class CSV extends OpenFinDeskStore {
    final static Logger logger= Logger.getLogger(CSV.class);

    private CSVReader csvReader;
    private CSVWriter csvWriter;
    private SocketUtil socketUtil;

    @Override
    public void initialize(String name,String timeFrame,String financialMarket,SocketUtil socketUtil) {
        this.socketUtil=socketUtil;

        String directory="csv";
        new File(directory).mkdirs();
        File idea=new File(directory,name+"-"+timeFrame+".csv");
        String fileName="/"+idea.getPath();
        List<String> header=new ArrayList<>();
        header.add("2000.01.15 17:34");header.add("1.1156");header.add("1.1157");
        header.add("1.1156");header.add("1.1156");header.add("16");
        csvWriter=new CSVWriter();
        csvWriter.setFile(idea);
        try {
            csvWriter.writeHeader(header);
        } catch (IOException e) {
            e.printStackTrace();
        }

     csvReader=new CSVReader();
    }

    @Override
    public void fetchCandlesFromMT5AndWriteItToOpenFinDeskStore(String symbolName,String timeFrame,int numberOfRequiredCandles,int count){
        socketUtil.getOhlcDataList().clear();
        String directory="csv";
        File idea=new File(directory,symbolName+"-"+timeFrame+".csv");
        //System.out.println("idea.getPath()="+idea.getPath());
        String fileName="/"+idea.getPath();
        csvReader.setFileName(fileName);
        csvWriter.setFile(idea);
        //System.out.println("count***="+count);
        //System.out.println("numberOfRequiredCandles***="+numberOfRequiredCandles);
        String message="fetchCandles"+","+symbolName+","+timeFrame+","+0+","+numberOfRequiredCandles;
        try {
            try {
                socketUtil.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
          List<OHLCData> ohlcDataList;

        ohlcDataList=new ArrayList<>();
        ohlcDataList=socketUtil.getOhlcDataList();
        //write to csv file
        List<String> stringList=new ArrayList<>();
        //System.out.println( "ohlcDataList size***:"+ohlcDataList.size());
          String[] dataOnLineOne = new String[6];

        try {
            dataOnLineOne=csvReader.readRow(1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String dateAndTimeOnLineOne;
        if (count==1){
            dateAndTimeOnLineOne="2000.01.15 17:34";
        }else{
            dateAndTimeOnLineOne=dataOnLineOne[0];
        }
        //System.out.println("dateAndTimeOnLineOne="+dateAndTimeOnLineOne);
        for(int j=0;j<numberOfRequiredCandles;j++){
            stringList.add(ohlcDataList.get(numberOfRequiredCandles - j - 1).getTime());
            stringList.add(ohlcDataList.get(numberOfRequiredCandles - j - 1).getOpen());
            stringList.add(ohlcDataList.get(numberOfRequiredCandles - j - 1).getHigh());
            stringList.add(ohlcDataList.get(numberOfRequiredCandles - j - 1).getLow());
            stringList.add(ohlcDataList.get(numberOfRequiredCandles - j - 1).getClose());
            stringList.add(ohlcDataList.get(numberOfRequiredCandles - j - 1).getTick_volume());
            if (dateAndTimeOnLineOne.equals(ohlcDataList.get(numberOfRequiredCandles-j-1).getTime())) {
                //do not allow duplicate data to be written on csv file
                stringList.clear();
            }else{
                try {
                    csvWriter.writeOnTop(stringList);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            stringList.clear();
        }
    }


    @Override
    public String findLatestTimeDownloaded(String symbolName,String timeFrame) {