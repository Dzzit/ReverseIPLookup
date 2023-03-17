
package com.farshad.algotrading.openFinDeskAnnotation;


import com.farshad.algotrading.core.openFinDeskOrder.OpenFinDeskOrder;
import com.farshad.algotrading.openFinDeskAnnotations.OpenFinDeskChanceNode;
import com.farshad.algotrading.openFinDeskStrategies.OpenFinDeskStrategy;
import com.farshad.algotrading.core.containerCore.StrategyContainer;
import com.farshad.algotrading.core.containerCore.ChanceNode;
import com.farshad.algotrading.core.containerCore.DecisionTree;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;
import org.ta4j.core.BaseTimeSeries;
import org.ta4j.core.TimeSeries;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("testing all annotations")
public class OpenFinDeskAnnotationsTest {

    final static Logger logger= Logger.getLogger(OpenFinDeskAnnotationsTest.class);
    Map<Integer,StrategyContainer> containers;

    DecisionTree decisionTree;
    OpenFinDeskOrder openFinDeskOrder;
    List<OpenFinDeskOrder> orderList;