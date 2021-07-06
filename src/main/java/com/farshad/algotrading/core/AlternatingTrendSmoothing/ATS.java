
package com.farshad.algotrading.core.AlternatingTrendSmoothing;

 import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PriceTime;
 import org.apache.log4j.Logger;

 import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ATS {
    final static Logger logger= Logger.getLogger(ATS.class);

    public List<PriceTime> priceChangeList;


    private int h;
    private List<PriceTime> priceTimeList;


    private double slope;

    public ATS(int h, List<PriceTime> priceTimeList) {
        this.h=h;
        this.priceTimeList=priceTimeList;
        this.priceChangeList=new ArrayList<>();

    }

    public void findPriceChangePoints() {
        Instant[] b=new Instant[700];

        double[] c=new double[b.length];
        float r=1;
         c[h]=priceTimeList.get(h).getPrice();
        slope = (c[h] - c[0]) ;

        r= (float) Math.signum(slope);

        int m=0;
        int d=0;
        while((m+h)<priceTimeList.size()) {
            b[m] =  priceTimeList.get(m).getTime();