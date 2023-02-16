package com.farshad.algotrading;

import com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.csv.CSVReader;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.IOException;

public class TestCSVReader {
    final static Logger logger= Logger.getLogger(TestCSVReader.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        String directory="src/main/java/files";
        new File(directory).mkdirs();
        File idea=new File(directo