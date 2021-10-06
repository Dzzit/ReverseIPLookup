package com.farshad.algotrading.core.openFinDeskStore.csv.stocksInputData.csv;


import java.io.*;



public class CSVReader {

    private BufferedReader csvReader;
    private BufferedReader csvReader2;

    private int lines;

    private String absolutePath;

     public void setFileName(String fileName){
         String filePath = new File("").getAbsolutePath();
         absolutePath=filePath+fileName;
         try {
             csvReader = new BufferedReader(new FileReader(absolutePath));
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         }
     }

    public int getLines() throws IOException {

        try {
            csvReader2 = new BufferedReader(new FileReader(absolutePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        lines = 0;
        while (csvReader2.readLine() != null) {
            line