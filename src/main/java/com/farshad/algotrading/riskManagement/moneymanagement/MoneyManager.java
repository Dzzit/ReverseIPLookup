
package com.farshad.algotrading.riskManagement.moneymanagement;


import org.apache.log4j.Logger;

public class MoneyManager {

    final static Logger logger= Logger.getLogger(MoneyManager.class);


    private int numberOfAllowedOrders;

    private int numberOfOpenOrders;


    public MoneyManager() {
     }


    public int getNumberOfAllowedOrders() {
        return numberOfAllowedOrders;
    }

    public int findNumberOfOpenOrders(String symbol){
        return numberOfOpenOrders;
    }

