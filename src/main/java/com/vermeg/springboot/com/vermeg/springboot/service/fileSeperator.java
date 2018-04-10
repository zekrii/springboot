package com.vermeg.springboot.com.vermeg.springboot.service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileSeperator {
    private int Id;
    private String directory;
    private String fileName;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public fileSeperator() {
    }

    public void fileReader(fileSeperator f) throws IOException {
        String filepathR = f.getDirectory() + f.getFileName();
        String filepath = "C:\\Users\\user\\Desktop\\STAGE PFE\\logs/ExtractDwhData_2018-02-07_104202.log";
        FileInputStream in = null;
        try {
            in = new FileInputStream(filepath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(in));

        String strLine;
        int counter = 0;
        int edwh = 0;
        int hexl = 0;
        int sqle = 0;
        int eec = 0;
        int extrator = 0;
        List<String> extractDwhDatas = new ArrayList<>();
        List<String> hExtractionsLaunchers = new ArrayList<>();
        List<String> tractorSqlExtractors = new ArrayList<>();
        List<String> xmlToCsvConverters = new ArrayList<>();
        List<String> extractorExtractions = new ArrayList<>();
        while ((strLine = br.readLine()) != null) {
            //System.out.println(counter+" "+strLine);
            counter++;
            if (strLine.contains("[      ExtractDwhData]")) {
                extractDwhDatas.add(strLine);
                edwh++;
            } else if (strLine.contains("[hExtractionsLauncher]")) {
                hExtractionsLaunchers.add(strLine);
                hexl++;
            } else if (strLine.contains("[tractor.SqlExtractor]")) {

                tractorSqlExtractors.add(strLine);
                sqle++;
            } else if (strLine.contains("[   XmlToCsvConverter]")) {
                xmlToCsvConverters.add(strLine);
                eec++;
            }
            if (strLine.contains(" [extractor.Extraction]")) {
                extractorExtractions.add(strLine);
                extrator++;

            }
        }
        in.close();
        for (String n : tractorSqlExtractors) {
            System.out.println(n);
        }
        //System.out.println(extractDwhDatas.toString()/*""+hExtractionsLaunchers+""+tractorSqlExtractors+""+xmlToCsvConverters*/);
        System.out.println(edwh + "//" + hexl + "//" + sqle + "//" + eec + "//" + extrator);
    }






    public static void main(String[] args) throws Exception {


// Set file name & path
        String filepath = "C:\\Users\\user\\Desktop\\STAGE PFE\\logs/ExtractDwhData_2018-02-07_104202.log";
        int counter = 0;
        counter++;
        fileSeperator fs=new fileSeperator();
        fs.fileReader(fs);





        FileInputStream in2 = new FileInputStream(filepath);
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String strLine2;
        String[] myarrayDWH;
        myarrayDWH = new String[counter];
        String[] extractionArray;
        extractionArray = new String[counter];
        for (int i = 0; i < myarrayDWH.length; i++) {
        }
        in2.close();
        int count = 0;
        for (int c = 0; c < myarrayDWH.length; c++) {
            count++;
        }


    }
}
