package com.farshad.algotrading.backtesting;


import com.farshad.algotrading.backtesting.influxDbCRUD.InfluxDbManager;
import com.farshad.algotrading.backtesting.measurements.AUDUSDCandlePoint;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PriceTime;
import com.farshad.algotrading.core.AlternatingTrendSmoothing.ATS;
import com.farshad.algotrading.core.trendRangeAndWave.Trend;
import com.farshad.algotrading.core.trendRangeAndWave.TrendGenerator;
import com.farshad.algotrading.core.trendRangeAndWave.Wave;
import com.farshad.algotrading.core.trendRangeAndWave.WaveGenerator;
import com.farshad.algotrading.core.fibonacciCore.Fibonacci;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Farshad Noravesh
 */
public class FibonacciBackTest extends Back