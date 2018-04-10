package com.vermeg.springboot.com.vermeg.springboot.service;

import com.sun.xml.internal.fastinfoset.util.CharArray;
import javafx.scene.paint.Stop;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SettingsService {
    public void confInitialisation(String txt) {
        //   String txt="Settings for current execution:";

        String re1 = "(Settings)";
        String re2 = ".*?";
        String re3 = "(for)";
        String re4 = ".*?";
        String re5 = "(current)";
        String re6 = ".*?";
        String re7 = "(execution)";
        String re8 = "(:)";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String word1 = m.group(1);
            String word2 = m.group(2);
            String word3 = m.group(3);
            String word4 = m.group(4);
            String c1 = m.group(5);
            System.out.print("(" + word1.toString() + ")" + "(" + word2.toString() + ")" + "(" + word3.toString() + ")" + "(" + word4.toString() + ")" + "(" + c1.toString() + ")" + "\n");
        }
    }

    public void currentSettings(String txt) {
        String re1 = "(extractionRootFolderPath)";
        String re2 = ".*?";
        String re3 = "(:)";
        String re4 = "( )";
        String re5 = "(E)";
        String re6 = "(:)";
        String re7 = "((?:\\\\/[\\\\w\\\\.\\\\-]+)+)";    // Unix Path 1

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String word1 = m.group(1);
            String c1 = m.group(2);
            String ws1 = m.group(3);
            String var1 = m.group(4);
            String c2 = m.group(5);
            String unixpath1 = m.group(6);
            System.out.print("(" + word1.toString() + ")" + "(" + c1.toString() + ")" + "(" + ws1.toString() + ")" + "(" + var1.toString() + ")" + "(" + c2.toString() + ")" + "(" + unixpath1.toString() + ")" + "\n");
        }
    }
    /**
     * windows path
     */
    public void windowsPath(String txt){
        String re1="([a-z]:\\\\(?:[-\\w\\.\\d]+\\\\)*(?:[-\\w\\.\\d]+)?)";	// Windows Path

        Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String winpath1=m.group(1);
            System.out.print("("+winpath1.toString()+")"+"\n");
        }
    }
    public void checkingJarInstallation(String txt){
        //String txt="checkIsSuccessfull = true";

        String re1="(checkIsSuccessfull)";
        String re2=".*?";
        String re3="(=)";
        String re4=".*?";
        String re5="((?:[a-z][a-z]+))";
        String re6="";

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {

            String word1=m.group(1);
            String c1=m.group(2);
            String word2=m.group(3);
            System.out.print("("+word1.toString()+")"+"("+c1.toString()+")"+"("+word2.toString()+")"+"\n");
        }
    }
    public void directoryCreation(String txt){
        String re1="(Creating)";
        String re2=".*?";
        String re3="(EXTRACTION)";
        String re4=".*?";
        String re5="(directory)";
        String re6=".*?";
        String re7="(structure)";

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String word1=m.group(1);
            String word2=m.group(2);
            String word3=m.group(3);
            String word4=m.group(4);
            System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+word4.toString()+")"+"\n");
        }
    }
    public void batchID(String txt){
        String re1="(Extraction)";
        String re2="( )";
        String re3="(batch)";
        String re4="( )";
        String re5="(ID)";
        String re6="( )";
        String re7="(:)";
        String re8="( )";
        String re9="(\\d+)";

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String word1=m.group(1);
            String ws1=m.group(2);
            String word2=m.group(3);
            String ws2=m.group(4);
            String usstate1=m.group(5);
            String ws3=m.group(6);
            String c1=m.group(7);
            String ws4=m.group(8);
            String int1=m.group(9);
            System.out.print("("+word1.toString()+")"+"("+ws1.toString()+")"+"("+word2.toString()+")"+"("+ws2.toString()+")"+"("+usstate1.toString()+")"+"("+ws3.toString()+")"+"("+c1.toString()+")"+"("+ws4.toString()+")"+"("+int1.toString()+")"+"\n");
        }

    }

    public static void main(String[] args) throws IOException {
        SettingsService ss = new SettingsService();


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
            if (strLine.contains("extractionRootFolderPath")) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                char[] tab=strLine.toCharArray();
                String ex="extractionRootFolderPath";
                System.out.println(strLine.indexOf("extractionRootFolderPath")+""+tab[59]);
               // strLine.substring(59+ex.length(),);
            }
            if(strLine.contains("Folder")&& strLine.contains("successfully created")){
                System.out.println("ok");
            }


               // ss.confInitialisation(strLine);
                //ss.currentSettings(strLine);
                //ss.windowsPath(strLine);
                ss.checkingJarInstallation(strLine);
                ss.batchID(strLine);
              //  ss.directoryCreation(strLine);


                counter++;
                //System.out.println();

        }

        in.close();


    }

}
