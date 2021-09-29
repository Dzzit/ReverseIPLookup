
package com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData;

import java.util.regex.Pattern;

public class TimeParser {


    private int year,month,dates,hour,minute;

    private String stringToParse;

    public TimeParser(String s) {
        this.stringToParse=s;
        parse();
    }


    public void parse(){
         String myDate=stringToParse.split(" ")[0];
         String myTime=stringToParse.split(" ")[1];

         hour=Integer.parseInt(myTime.split(":")[0]);
         minute=Integer.parseInt(myTime.split(":")[1]);

         year=Integer.parseInt(myDate.split(Pattern.quote("."))[0].replaceAll("^[0]+", ""));