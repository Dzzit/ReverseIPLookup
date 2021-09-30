package com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.csv;


import java.io.*;



public class CSVReader {

    private BufferedReader csvReader;
    private BufferedReader csvReader2;

    private int lines;

    private String absolutePath;

     public void setFileName(String fileName){
         String