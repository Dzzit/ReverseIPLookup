package com.farshad.algotrading.backtesting;

import com.farshad.algotrading.backtesting.HMM.BackwardAlgorithm;
import com.farshad.algotrading.backtesting.HMM.RegimeAnalyzer;
import com.farshad.algotrading.backtesting.measurements.AUDUSDCandlePoint;
import com.farshad.algotrading.backtesting.influxDbCRUD.InfluxDbManager;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.PercentOfChange;
import com.farshad.algotrading.backtesting.measurements.timeSeriesMeasurements.Return;
import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.OHLCData;
import org.apache.log4j.Logger;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Lis