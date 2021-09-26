package com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData;

public class OHLCData {

    String symbol;
    String time;
    String open;
    String high;
    String low;
    String close;
    String tick_volume;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
   