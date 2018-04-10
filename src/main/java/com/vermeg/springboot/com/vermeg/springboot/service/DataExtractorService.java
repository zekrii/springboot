package com.vermeg.springboot.com.vermeg.springboot.service;

import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.logging.Logger;

public class DataExtractorService {
    final static org.slf4j.Logger logger = LoggerFactory.getLogger(DataExtractorService.class);


    public int numberOfLines(String filepath) throws IOException {

        FileInputStream in = null;
        try {
            in = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine;
        int counter = 0;

        while ((strLine = br.readLine()) != null)
        {
            counter++;
        }

        in.close();


        return counter;
    }
    private static Logger LOGGER = Logger.getLogger("InfoLogging");

    public static void main(String[] args) throws Exception {

        PatternExtractor pe=new PatternExtractor();

// Set file name & path
        String filepath = "C:\\Users\\user\\Desktop\\STAGE PFE\\logs/ExtractDwhData_2018-02-07_104202.log";
       // filepath.replace("\\","/");



        // Read in file to determine how many lines it has
        FileInputStream in = new FileInputStream(filepath);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine;
        int counter = 0;

        while ((strLine = br.readLine()) != null)
        {
            System.out.println(counter+" "+strLine);
            counter++;
        }

        in.close();

// Read in file
        /*FileInputStream in2 = new FileInputStream(filepath);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String strLine2;

// Declare array
        String[] myarray;
        myarray = new String[counter];

// Add each line to the array
        for (int i = 0; i < myarray.length; i++){
            myarray[i] = br2.readLine();
        }

        in2.close();
    int count=0;
// Loop through array looking for the correct text, format & print
        for (int c = 0; c < myarray.length; c++){

            *//*if(myarray[c].contains("ExtractDwhData")){
                count++;
                System.out.println("line n°:"+count +pe.timeExtractor(myarray[c]));

            }*//*

        }




*/
    }

}
