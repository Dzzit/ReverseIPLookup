
package com.farshad.algotrading.core.openFinDeskOrder;

public class OpenFinDeskOrder {
    private String orderType;
    private String position;
    private double takeProfit;
    private double stopLoss;
    private double price;
    private String volume;
    private String symbol;
    private String strategyName;
    private int openFinDeskOrderNumber;
    private String parameter;
    private String action;

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public OpenFinDeskOrder(String symbol) {
        this.symbol = symbol;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(double takeProfit) {
        this.takeProfit = takeProfit;
    }

    public double getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(double stopLoss) {
        this.stopLoss = stopLoss;