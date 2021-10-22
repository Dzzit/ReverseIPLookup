package com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.csv;


import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CSVWriter {

    private static Logger LOGGER= Logger.getLogger(CSVWriter.class);
    private FileWriter csvWriter;
    private File file;


    public void setFile(File file){
        this.file=file;
        if (file.exists()){
            LOGGER.info("file exists!");
            try {
                csvWriter=new FileWriter(file, true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeHeader(List<String> row) throws IOException {
            //empty the file
            PrintWriter writer = new PrintWriter(file);
            writer.prin