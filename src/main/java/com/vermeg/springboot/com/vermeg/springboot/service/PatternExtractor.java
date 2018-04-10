package com.vermeg.springboot.com.vermeg.springboot.service;


import com.sun.org.apache.xml.internal.utils.StringBufferPool;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PatternExtractor {

    public Date timeExtractor(String txt) {
        String re1 = "((?:2|1)\\d{3}(?:-|\\/)(?:(?:0[1-9])|(?:1[0-2]))(?:-|\\/)(?:(?:0[1-9])|(?:[1-2][0-9])|(?:3[0-1]))(?:T|\\s)(?:(?:[0-1][0-9])|(?:2[0-3])):(?:[0-5][0-9]):(?:[0-5][0-9]))";    // Time St0amp 1

        //String re2="\"((?:[a-z][a-z]+))\"";
        Pattern p = Pattern.compile(re1);

        Matcher m = p.matcher(txt);

        Date dateR = null;
        if (m.find()) {
            String timestamp1 = m.group(1);
            String date = timestamp1.replace("T", " ");
            // System.out.print(date);


            try {
                dateR = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(date);

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return dateR;


        }
        return dateR;
    }
    /****************************************************/
    public void versionITKDWH(String txt) {
       // String txt="build #265 on 2018-01-04 08:22:32";

        String re1="(build)";	// Word 1
        String re2=".*?";
        String re3="(#)";
        String re4="(2)";
        String re5="(\\d)";
        String re6="(\\d)";
        String re7=".*?";
        String re8="((?:[a-z][a-z]+))";	// Word 2
        String re9=".*?";
        String re10="((?:2|1)\\d{3}(?:-|\\/)(?:(?:0[1-9])|(?:1[0-2]))(?:-|\\/)(?:(?:0[1-9])|(?:[1-2][0-9])|(?:3[0-1]))(?:T|\\s)(?:(?:[0-1][0-9])|(?:2[0-3])):(?:[0-5][0-9]):(?:[0-5][0-9]))";	// Time Stamp 1

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String word1=m.group(1);
            String c1=m.group(2);
            String d1=m.group(3);
            String d2=m.group(4);
            String d3=m.group(5);
            String word2=m.group(6);
            String timestamp1=m.group(7);
            System.out.print("("+word1.toString()+")"+"("+c1.toString()+")"+"("+d1.toString()+")"+"("+d2.toString()+")"+"("+d3.toString()+")"+"("+word2.toString()+")"+"("+timestamp1.toString()+")"+"\n");
        }
    }
    /**
     * Specified option
     */
    public void extractionOptions(String txt){
       // String txt="Specified options: -G -SS";

        String re1="(Specified)";	// Word 1
        String re2="(\\s+)";	// White Space 1
        String re3="(options)";	// Word 2
        String re4="(.)";
        String re5="(\\s+)";
        String re6="(.)";
        String re7="((?:[a-z][a-z0-9_]*))";
        String re8="(\\s+)";
        String re9="(.)";
        String re10="((?:[a-z][a-z0-9_]*))";	// Variable Name 2

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String word1=m.group(1);
            String ws1=m.group(2);
            String word2=m.group(3);
            String c1=m.group(4);
            String ws2=m.group(5);
            String c2=m.group(6);
            String var1=m.group(7);
            String ws3=m.group(8);
            String c3=m.group(9);
            String var2=m.group(10);
            System.out.print("("+word1.toString()+")"+"("+ws1.toString()+")"+"("+word2.toString()+")"+"("+c1.toString()+")"+"("+ws2.toString()+")"+"("+c2.toString()+")"+"("+var1.toString()+")"+"("+ws3.toString()+")"+"("+c3.toString()+")"+"("+var2.toString()+")"+"\n");
        }
    }
    public void loadingConfigState(String txt){
      //  String txt="Configuration successfully loaded!";

        String re1="(Configuration)";
        String re2=".*?";
        String re3="(successfully)";
        String re4=".*?";
        String re5="(loaded)";

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String word1=m.group(1);
            String word2=m.group(2);
            String word3=m.group(3);
            System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"\n");
        }
    }



    public static void main(String[] args) throws IOException {
        PatternExtractor pe = new PatternExtractor();




            String filepath = "C:\\Users\\user\\Desktop\\STAGE PFE\\logs/ExtractDwhData_2018-02-07_104202.log";


            // Read in file to determine how many lines it has
            FileInputStream in = null;
            try {
                in = new FileInputStream(filepath);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            int counter = 1;

            while ((strLine = br.readLine()) != null) {
            if(strLine.contains("[INFO  ]")) {
                pe.extractionOptions(strLine);
                pe.versionITKDWH(strLine);
                pe.loadingConfigState(strLine);
                //System.out.println("line N°" + counter +"" + pe.timeExtractor(strLine));
                counter++;
            }
            }

            in.close();

    }
}
