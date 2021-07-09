package com.farshad.algotrading.core;

import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.TimeParser;
import org.apache.log4j.Logger;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author farshad noravesh
 * @since version 1.0.0
 */
public class Comparison {

    final static Logger logger= Logger.getLogger(Comparison.class);


    private long difference;

    public int compareTwoTimes(String time1, String time2){

        TimeParser timeParser1=new TimeParser(time1);
        LocalDateTime ldt1 = LocalDateTime.of(timeParser1.getYear(), Month.of(timeParser1.getMonth()), timeParser1.getDates(), timeParser1.getHour(), timeParser1.getMinute());
        ZonedDateTime tehranDateTime1 ;
        tehranDateTime1=ldt1.atZone(ZoneId.of("Asia/Tehran"));
        logger.info("time1="+time1);
        logger.info("Tehran Date Time1="+tehranDateTime1);

        TimeParser timeParser2=new TimeParser(time2);
        LocalDateTime ldt2 = LocalDateTime.of(timeParser2.getYear(), Month.of