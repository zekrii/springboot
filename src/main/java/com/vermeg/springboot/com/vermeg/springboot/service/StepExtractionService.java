package com.vermeg.springboot.com.vermeg.springboot.service;

import com.vermeg.springboot.com.vermeg.springboot.domain.DataWhJob;
import com.vermeg.springboot.com.vermeg.springboot.domain.SqleXTractionConfig;
import com.vermeg.springboot.com.vermeg.springboot.domain.TableExtracted;
import com.vermeg.springboot.com.vermeg.springboot.domain.XmlToCsv;
import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StepExtractionService {

    final static org.slf4j.Logger logger = LoggerFactory.getLogger(StepExtractionService.class);

    public void runningMode(String txt) {
        //  String txt="Running in FORCE LOAD mode !";

        String re0 = "(Executing)";
        String re1 = "(Running)";
        String re2 = "( )";
        String re3 = "(in)";
        String re4 = ".*?";
        String re5 = "((?:[a-z][a-z]+))";
        String re6 = ".*?";
        String re7 = "((?:[a-z][a-z]+))";
        String re8 = ".*?";
        String re9 = "((?:[a-z][a-z]+))";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Pattern p2 = Pattern.compile(re0 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        Matcher m2 = p.matcher(txt);
        if (m.find()) {
            String word1 = m.group(1);
            String ws1 = m.group(2);
            String usstate1 = m.group(3);
            String word2 = m.group(4);
            String word3 = m.group(5);
            String word4 = m.group(6);
            System.out.print(word1.toString() + "(" + ws1.toString() + ")" + "(" + usstate1.toString() + ")" + "(" + word2.toString() + ")" + "(" + word3.toString() + ")" + "(" + word4.toString() + ")" + "\n");
        }
    }

    public void executingMode(String txt) {
        String re1 = "(Executing)";
        String re2 = ".*?";
        String re3 = "(in)";
        String re4 = ".*?";
        String re5 = "((?:[a-z][a-z]+))";
        String re6 = ".*?";
        String re7 = "((?:[a-z][a-z]+))";
        String re8 = ".*?";
        String re9 = "((?:[a-z][a-z]+))";
        String re10 = ".*?";
        String re11 = "((?:[a-z][a-z]+))";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String word1 = m.group(1);
            String usstate1 = m.group(2);
            String word2 = m.group(3);
            String word3 = m.group(4);
            String word4 = m.group(5);
            String word5 = m.group(6);
            System.out.print("(" + word1.toString() + ")" + "(" + usstate1.toString() + ")" + "(" + word2.toString() + ")" + "(" + word3.toString() + ")" + "(" + word4.toString() + ")" + "(" + word5.toString() + ")" + "\n");
        }
    }

    public void jobReport(String txt) {
        String re1 = "(reporting)";
        String re2 = ".*?";
        String re3 = "(job)";
        String re4 = ".*?";
        String re5 = "(DWH)";
        String re6 = "(_)";
        String re7 = "((?:[a-z][a-z]+))";
        String re8 = ".*?";
        String re9 = "(ReportingJobId)";
        String re10 = "(=)";
        String re11 = "(\\d+)";
        String re12 = "(,)";
        String re13 = ".*?";
        String re14 = "(ExtractionBatchJobId)";
        String re15 = "(=)";
        String re16 = "(\\d+)";
        String re17 = ".*?";
        String re18 = "((?:[a-z][a-z]+))";
        String re19 = ".*?";
        String re20 = "((?:[a-z][a-z]+))";
        String re21 = ".*?";
        String re22 = "(in)";
        String re23 = ".*?";
        String re24 = "(\\d+)";
        String re25 = ".*?";
        String re26 = "(,)";
        String re27 = ".*?";
        String re28 = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24 + re25 + re26 + re27 + re28, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {

            String word1 = m.group(1);
            String word2 = m.group(2);
            String word3 = m.group(3);
            String c1 = m.group(4);
            String word4 = m.group(5);
            String word5 = m.group(6);
            String c2 = m.group(7);
            String int1 = m.group(8);
            String c3 = m.group(9);
            String var1 = m.group(10);
            String c4 = m.group(11);
            String int2 = m.group(12);
            String word6 = m.group(13);
            String word7 = m.group(14);
            String usstate1 = m.group(15);
            String int3 = m.group(16);
            String c5 = m.group(17);
            String float1 = m.group(18);
            /****************/
            DataWhJob d = new DataWhJob();
            d.setNom(m.group(3) + m.group(5));
            d.setJobId(m.group(8));
            if (word7 == "successfully") {
                d.setExecution(true);
            } else {
                d.setExecution(false);
            }

            d.setDuration(Integer.parseInt(float1.substring(0, float1.indexOf("."))) + 16 * 60);


            d.setExtractionBatchJobId(m.group(12));
            //System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+c1.toString()+")"+"("+word4.toString()+")"+"("+word5.toString()+")"+"("+c2.toString()+")"+"("+int1.toString()+")"+"("+c3.toString()+")"+"("+var1.toString()+")"+"("+c4.toString()+")"+"("+int2.toString()+")"+"("+word6.toString()+")"+"("+word7.toString()+")"+"("+usstate1.toString()+")"+"("+int3.toString()+")"+"("+c5.toString()+")"+"("+float1.toString()+")"+"\n");
            System.out.println(d);
        }
    }


    public void reportJobII(String txt) {
        String re1 = "(reporting)";
        String re2 = ".*?";
        String re3 = "(job)";
        String re4 = ".*?";
        String re5 = "(DWH)";
        String re6 = "(_)";
        String re7 = "((?:[a-z][a-z]+))";
        String re8 = ".*?";
        String re9 = "(ReportingJobId)";
        String re10 = "(=)";
        String re11 = "(\\d+)";
        String re12 = "(,)";
        String re13 = ".*?";
        String re14 = "(ExtractionBatchJobId)";
        String re15 = "(=)";
        String re16 = "(\\d+)";
        String re17 = ".*?";
        String re18 = "((?:[a-z][a-z]+))";
        String re19 = ".*?";
        String re20 = "((?:[a-z][a-z]+))";
        String re21 = ".*?";
        String re22 = "(in)";
        String re23 = ".*?";
        String re24 = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";    // Float 1

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re21 + re22 + re23 + re24, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String word1 = m.group(1);
            String word2 = m.group(2);
            String word3 = m.group(3);
            String c1 = m.group(4);
            String word4 = m.group(5);
            String word5 = m.group(6);
            String c2 = m.group(7);
            String int1 = m.group(8);
            String c3 = m.group(9);
            String var1 = m.group(10);
            String c4 = m.group(11);
            String int2 = m.group(12);
            String word6 = m.group(13);
            String word7 = m.group(14);
            String usstate1 = m.group(15);
            String float1 = m.group(16);
            /*********************************************/
            DataWhJob d = new DataWhJob();
            d.setNom(m.group(3) + m.group(5));
            d.setJobId(m.group(8));
            if (word7 == "successfully") {
                d.setExecution(true);
            } else {
                d.setExecution(false);
            }

            d.setDuration(Integer.parseInt(float1.substring(0, float1.indexOf("."))));


            d.setExtractionBatchJobId(m.group(12));
            //  System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+c1.toString()+")"+"("+word4.toString()+")"+"("+word5.toString()+")"+"("+c2.toString()+")"+"("+int1.toString()+")"+"("+c3.toString()+")"+"("+var1.toString()+")"+"("+c4.toString()+")"+"("+int2.toString()+")"+"("+word6.toString()+")"+"("+word7.toString()+")"+"("+usstate1.toString()+")"+"("+float1.toString()+")"+"\n");
            System.out.println(d);
        }


    }

    public void extractionInTables(String txt) {

        String re1 = "(-)";
        String re2 = "( )";
        String re3 = "((?:[a-z][a-z]+))";
        String re4 = "( )";
        String re5 = "((?:[a-z][a-z]+))";
        String re6 = "( )";
        String re7 = "(in)";
        String re8 = ".*?";
        String re9 = "(FULL)";
        String re10 = ".*?";
        String re11 = "(mode)";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);

        if (m.find()) {
            String c1 = m.group(1);
            String ws1 = m.group(2);
            String word1 = m.group(3);
            String ws2 = m.group(4);
            String word2 = m.group(5);
            String ws3 = m.group(6);
            String usstate1 = m.group(7);
            String word3 = m.group(8);
            String word4 = m.group(9);
            System.out.print("(" + c1.toString() + ")" + "(" + ws1.toString() + ")" + "(" + word1.toString() + ")" + "(" + ws2.toString() + ")" + "(" + word2.toString() + ")" + "(" + ws3.toString() + ")" + "(" + usstate1.toString() + ")" + "(" + word3.toString() + ")" + "(" + word4.toString() + ")" + "\n");
        }
    }

    public void ITKBasedExtractionStatus(String txt) {
        String re1 = "(ITK)";
        String re2 = "( )";
        String re3 = "(Based)";
        String re4 = "( )";
        String re5 = "(Extractions)";
        String re6 = "( )";
        String re7 = "(return)";
        String re8 = "( )";
        String re9 = "(status)";
        String re10 = "(\\s+)";
        String re11 = "(:)";
        String re12 = "(\\s+)";
        String re13 = "((?:[a-z][a-z]+))";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find()) {
            String word1 = m.group(1);
            String ws1 = m.group(2);
            String word2 = m.group(3);
            String ws2 = m.group(4);
            String word3 = m.group(5);
            String ws3 = m.group(6);
            String word4 = m.group(7);
            String ws4 = m.group(8);
            String word5 = m.group(9);
            String ws5 = m.group(10);
            String c1 = m.group(11);
            String ws6 = m.group(12);
            String word6 = m.group(13);
            System.out.print("(" + word1.toString() + ")" + "(" + ws1.toString() + ")" + "(" + word2.toString() + ")" + "(" + ws2.toString() + ")" + "(" + word3.toString() + ")" + "(" + ws3.toString() + ")" + "(" + word4.toString() + ")" + "(" + ws4.toString() + ")" + "(" + word5.toString() + ")" + "(" + ws5.toString() + ")" + "(" + c1.toString() + ")" + "(" + ws6.toString() + ")" + "(" + word6.toString() + ")" + "\n");
        }
    }

    /**
     * sql Setting method
     *
     * @param txt
     */

    public Date sqlecDateGetter(String txt) {
        SqleXTractionConfig sec = new SqleXTractionConfig();
        boolean if1 = true;
        String re1 = "(-)";
        String re2 = "(\\s+)";
        String re3 = "(on)";
        String re4 = ".*?";
        String re5 = "((?:2|1)\\d{3}(?:-|\\/)(?:(?:0[1-9])|(?:1[0-2]))(?:-|\\/)(?:(?:0[1-9])|(?:[1-2][0-9])|(?:3[0-1]))(?:T|\\s)(?:(?:[0-1][0-9])|(?:2[0-3])):(?:[0-5][0-9]):(?:[0-5][0-9]))";    // Time Stamp 1

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find() && if1) {
            String c1 = m.group(1);
            String ws1 = m.group(2);
            String word1 = m.group(3);
            String timestamp1 = m.group(4);
            // System.out.print("("+c1.toString()+")"+"("+ws1.toString()+")"+"("+word1.toString()+")"+"("+timestamp1.toString()+")"+"\n");

            PatternExtractor pe = new PatternExtractor();
            Date date = null;
            date = pe.timeExtractor(timestamp1);
            System.out.println(date);
            sec.setGenerated(date);
            if1 = false;
            return date;

        }
        return null;
    }

    public String generatorGetter(String txt) {
        String re21 = "(by)";
        String re22 = ".*?";
        String re23 = "(SQL)";
        String re24 = ".*?";
        String re25 = "(Code)";
        String re6 = ".*?";
        String re7 = "(Generator)";
        String re8 = ".*?";
        String re9 = "(\\d)";
        String re10 = "(\\.)";
        String re11 = "(\\d)";
        String re12 = "(\\.)";
        String re13 = "(\\d)";
        String re14 = "(-)";
        String re15 = "((?:[a-z][a-z]+))";
        String re16 = ".*?";
        String re17 = "(build)";
        String re18 = ".*?";
        String re19 = "(\\d)";
        String re20 = "(\\d)";
        String re221 = "(\\d)";
        String re222 = ".*?";
        String re223 = "((?:2|1)\\d{3}(?:-|\\/)(?:(?:0[1-9])|(?:1[0-2]))(?:-|\\/)(?:(?:0[1-9])|(?:[1-2][0-9])|(?:3[0-1]))(?:T|\\s)(?:(?:[0-1][0-9])|(?:2[0-3])):(?:[0-5][0-9]):(?:[0-5][0-9]))";    // Time Stamp 1

        Pattern p2 = Pattern.compile(re21 + re22 + re23 + re24 + re25 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13 + re14 + re15 + re16 + re17 + re18 + re19 + re20 + re221 + re222 + re223, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m2 = p2.matcher(txt);
        if (m2.find()) {
            String word1 = m2.group(1);
            String word2 = m2.group(2);
            String word3 = m2.group(3);
            String word4 = m2.group(4);
            String d1 = m2.group(5);
            String c1 = m2.group(6);
            String d2 = m2.group(7);
            String c2 = m2.group(8);
            String d3 = m2.group(9);
            String c3 = m2.group(10);
            String word5 = m2.group(11);
            String word6 = m2.group(12);
            String d4 = m2.group(13);
            String d5 = m2.group(14);
            String d6 = m2.group(15);
            String timestamp1 = m2.group(16);
            //           System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+word4.toString()+")"+"("+d1.toString()+")"+"("+c1.toString()+")"+"("+d2.toString()+")"+"("+c2.toString()+")"+"("+d3.toString()+")"+"("+c3.toString()+")"+"("+word5.toString()+")"+"("+word6.toString()+")"+"("+d4.toString()+")"+"("+d5.toString()+")"+"("+d6.toString()+")"+"("+timestamp1.toString()+")"+"\n");
            String s = (m2.group(5) + m2.group(6) + m2.group(7) + m2.group(8) + m2.group(9) + m2.group(10) +
                    m2.group(11) + m2.group(12) + m2.group(13) + m2.group(14) + m2.group(15) + m2.group(16));
            System.out.println(s);
            return s;

        }
        return null;
    }

    public String solifeMetaDataG(String txt) {

        String re31 = "(with)";
        String re32 = ".*?";
        String re33 = "(Solife)";
        String re34 = ".*?";
        String re35 = "(Metadata)";
        String re36 = ".*?";
        String re37 = "(from)";
        String re38 = ".*?";
        String re39 = "(\\d+)";
        String re310 = ".*?";
        String re311 = "(\\d+)";
        String re312 = ".*?";
        String re313 = "(\\d+)";
        String re314 = ".*?";
        String re315 = "((?:[a-z][a-z]+))";

        Pattern p3 = Pattern.compile(re31 + re32 + re33 + re34 + re35 + re36 + re37 + re38 + re39 + re310 + re311 + re312 + re313 + re314 + re315, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m3 = p3.matcher(txt);
        if (m3.find()) {
            String word1 = m3.group(1);
            String word2 = m3.group(2);
            String word3 = m3.group(3);
            String word4 = m3.group(4);
            String int1 = m3.group(5);
            String int2 = m3.group(6);
            String int3 = m3.group(7);
            String word5 = m3.group(8);
            //System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+word4.toString()+")"+"("+int1.toString()+")"+"("+int2.toString()+")"+"("+int3.toString()+")"+"("+word5.toString()+")"+"\n");
            String s = (int1 + "." + int2 + "." + int3 + "-" + word5);
            System.out.println(s);
            return s;
        }
        return null;
    }

    public String databaseRef(String txt) {
        String re41 = "(on)";
        String re42 = ".*?";
        String re43 = "(Reference)";
        String re44 = ".*?";
        String re45 = "(database)";
        String re46 = ".*?";
        String re47 = "((?:[a-z][a-z]+))";
        String re48 = ".*?";
        String re49 = "(@)";
        String re410 = ".*?";
        String re411 = "(jdbc)";
        String re412 = "(:)";
        String re413 = "(oracle)";
        String re414 = "(:)";
        String re415 = "((?:[a-z][a-z]+))";
        String re416 = "(:)";
        String re417 = "(@)";
        String re418 = "((?:[a-z][a-z0-9_]*))";
        String re419 = "(\\.)";
        String re420 = "(vermeg)";
        String re421 = "(\\.)";
        String re422 = "(com)";
        String re423 = ".*?";
        String re424 = "(\\d+)";
        String re425 = ".*?";
        String re426 = "((?:[a-z][a-z0-9_]*))";

        Pattern p4 = Pattern.compile(re41 + re42 + re43 + re44 + re45 + re46 + re47 + re48 + re49 + re410 + re411 + re412 + re413 + re414 + re415 + re416 + re417 + re418 + re419 + re420 + re421 + re422 + re423 + re424 + re425 + re426, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m4 = p4.matcher(txt);
        if (m4.find()) {
            String word1 = m4.group(1);
            String word2 = m4.group(2);
            String word3 = m4.group(3);
            String word4 = m4.group(4);
            String c1 = m4.group(5);
            String word5 = m4.group(6);
            String c2 = m4.group(7);
            String word6 = m4.group(8);
            String c3 = m4.group(9);
            String word7 = m4.group(10);
            String c4 = m4.group(11);
            String c5 = m4.group(12);
            String var1 = m4.group(13);
            String c6 = m4.group(14);
            String word8 = m4.group(15);
            String c7 = m4.group(16);
            String word9 = m4.group(17);
            String int1 = m4.group(18);
            String var2 = m4.group(19);
            // System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+word4.toString()+")"+"("+c1.toString()+")"+"("+word5.toString()+")"+"("+c2.toString()+")"+"("+word6.toString()+")"+"("+c3.toString()+")"+"("+word7.toString()+")"+"("+c4.toString()+")"+"("+c5.toString()+")"+"("+var1.toString()+")"+"("+c6.toString()+")"+"("+word8.toString()+")"+"("+c7.toString()+")"+"("+word9.toString()+")"+"("+int1.toString()+")"+"("+var2.toString()+")"+"\n");
            String s = word4 + c1 + word5 + c2 + word6 + c3 + word7 + c4 + c5 + var1 + c6 + word8 + c7 + word9 + int1 + var2;
            System.out.println(s);

            return s;
        }
        return null;
    }

    public String databaseUrl(String txt) {
        String re51 = "(URL)";
        String re52 = "(:)";
        String re53 = ".*?";
        String re54 = "(jdbc)";
        String re55 = "(:)";
        String re56 = "(oracle)";
        String re57 = "(:)";
        String re58 = "((?:[a-z][a-z]+))";
        String re59 = "(:)";
        String re510 = "(@)";
        String re511 = "((?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?))(?![\\d])";    // IPv4 IP Address 1
        String re512 = "(:)";
        String re513 = "(\\d)";
        String re514 = "(\\d)";
        String re515 = "(\\d)";
        String re516 = "(\\d)";
        String re517 = "(:)";
        String re518 = "(orcl)";
        String re519 = ".*?";
        String re520 = "(USER)";
        String re521 = ".*?";
        String re522 = "((?:vb[a-z][a-z0-9_]*))";

        Pattern p5 = Pattern.compile(re51 + re52 + re53 + re54 + re55 + re56 + re57 + re58 + re59 + re510 + re511 + re512 + re513 + re514 + re515 + re516 + re517 + re518 + re519 + re520 + re521 + re522, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m5 = p5.matcher(txt);
        if (m5.find()) {
            String word1 = m5.group(1);
            String c1 = m5.group(2);
            String word2 = m5.group(3);
            String c2 = m5.group(4);
            String word3 = m5.group(5);
            String c3 = m5.group(6);
            String word4 = m5.group(7);
            String c4 = m5.group(8);
            String c5 = m5.group(9);
            String ipaddress1 = m5.group(10);
            String c6 = m5.group(11);
            String d1 = m5.group(12);
            String d2 = m5.group(13);
            String d3 = m5.group(14);
            String d4 = m5.group(15);
            String c7 = m5.group(16);
            String var1 = m5.group(17);
            String word5 = m5.group(18);
            String var2 = m5.group(19);
            //  System.out.print("("+word1.toString()+")"+"("+c1.toString()+")"+"("+word2.toString()+")"+"("+c2.toString()+")"+"("+word3.toString()+")"+"("+c3.toString()+")"+"("+word4.toString()+")"+"("+c4.toString()+")"+"("+c5.toString()+")"+"("+ipaddress1.toString()+")"+"("+c6.toString()+")"+"("+d1.toString()+")"+"("+d2.toString()+")"+"("+d3.toString()+")"+"("+d4.toString()+")"+"("+c7.toString()+")"+"("+var1.toString()+")"+"("+word5.toString()+")"+"("+var2.toString()+")"+"\n");
            String s = (word2 + c2 + word3 + c3 + word4 + c4 + c5 + ipaddress1 + c6 + d1 + d2 + d3 + d4 + c7 + var1 + word5 + var2);
            System.out.println(s);
            return s;
        }
        return null;
    }

    public SqleXTractionConfig launchingSQLExtraction(String txt) {
        SqleXTractionConfig sec = new SqleXTractionConfig();
        boolean if1 = true;
        boolean if2 = true;
        boolean if3 = true;
        boolean if4 = true;
        boolean if5 = true;
        if (sqlecDateGetter(txt) != null && if1) {
            sec.setGenerated(sqlecDateGetter(txt));
            if1 = false;

        }
        if (generatorGetter(txt) != null && if2) {
            sec.setGenarator(generatorGetter(txt));
            if2 = false;
        }
        if (solifeMetaDataG(txt) != null && if3) {

            sec.setSolifeMetadata(solifeMetaDataG(txt));
            if3=false;
            //System.out.println(sec);h
        }
        sec.setDatabaseRef(databaseRef(txt));
        sec.setDataBaseUrl(databaseUrl(txt));
        return null;
    }
    /*********************************GROUP ALL*******************************************/
    public String groupAllduration(String txt){


        String re1="(Group)";
        String re2="( )";
        String re3="(ALL)";
        String re4="(             )";
        String re5="(in)";
        String re6=".*?";
        String re7="((?:(?:[0-1][0-9])|(?:[2][0-3])|(?:[0-9])):(?:[0-5][0-9])(?::[0-5][0-9])?(?:\\s?(?:am|AM|pm|PM))?)";	// HourMinuteSec 1
        String re8="(\\.)";
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
            String time1=m.group(6);
            String c1=m.group(7);
            String int1=m.group(8);
            System.out.print("("+word1.toString()+")"+"("+ws1.toString()+")"+"("+word2.toString()+")"+"("+ws2.toString()+")"+"("+usstate1.toString()+")"+"("+time1.toString()+")"+"("+c1.toString()+")"+"("+int1.toString()+")"+"\n");
            return time1+c1+int1;
        }
        return null;
    }
    public void tableExtracted(String txt){

        String re1="(-)";
        String re2="( )";
        String re3="((?:[a-z][a-z0-9_]*))";
        String re4=".*?";
        String re5="(starting)";
        String re6=".*?";
        String re7="(in)";
        String re8=".*?";
        String re9="(FULL)";
        String re10=".*?";
        String re11="(mode)";

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String c1=m.group(1);
            String ws1=m.group(2);
            String var1=m.group(3);
            String word1=m.group(4);
            String usstate1=m.group(5);
            String word2=m.group(6);
            String word3=m.group(7);
            System.out.print("("+c1.toString()+")"+"("+ws1.toString()+")"+"("+var1.toString()+")"+"("+word1.toString()+")"+"("+usstate1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"\n");
        }
    }
    public void satats(String txt){
        String re1="(-)";
        String re2="( )";
        String re3="((?:[a-z][a-z]+))";
        String re4=".*?";
        String re5="(\\[.*?\\])";	// Square Braces 1
        String re6=".*?";
        String re7="(finished)";
        String re8="(\\s+)";
        String re9="(:)";
        String re10=".*?";
        String re11="(\\d+)";
        String re12=".*?";
        String re13="(rows)";
        String re14=".*?";
        String re15="(extracted)";
        String re16=".*?";
        String re17="(in)";
        String re18=".*?";
        String re19="(\\d+)";
        String re20=".*?";
        String re21="((?:[a-z][a-z0-9_]*))";	// Variable Name 1
        String re22=".*?";
        String re23="(-)";
        String re24=".*?";
        String re25="(\\d+)";
        String re26=".*?";
        String re27="((?:[a-z][a-z]+))";

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7+re8+re9+re10+re11+re12+re13+re14+re15+re16+re17+re18+re19+re20+re21+re22+re23+re24+re25+re26+re27,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String c1=m.group(1);
            String ws1=m.group(2);
            String word1=m.group(3);
            String sbraces1=m.group(4);
            String word2=m.group(5);
            String ws2=m.group(6);
            String c2=m.group(7);
            String int1=m.group(8);
            String word3=m.group(9);
            String word4=m.group(10);
            String word5=m.group(11);
            String int2=m.group(12);
            String var1=m.group(13);
            String c3=m.group(14);
            String int3=m.group(15);
            String word6=m.group(16);
            //System.out.println(word1.toString()+"||"+sbraces1.toString()+"||"+word2.toString()+"||"+ws2.toString()+"||"+c2.toString()+"||"+int1.toString()+"||"+word3.toString()+"||"+word4.toString()+"||"+word5.toString()+"||"+int2.toString()+"||"+var1.toString()+"||"+c3.toString()+"||"+int3.toString()+"||"+word6.toString());
            TableExtracted te=new TableExtracted();
            String s =sbraces1.substring(1,sbraces1.length()-1);
            te.setName(s);
            te.setNbrRows(Long.parseLong(int1) );
            te.setDuration(Integer.parseInt(int2));
            te.setStatus(word2);
            te.setSize(Integer.parseInt(int3));
            te.setBitesPerSeconds();
            te.setRowsPerSecond();
            System.out.println(te);
        }


    }
    public void xmlToCsv(String txt) {

        boolean if1 = true;
        boolean if2 = true;
        String re1 = "(Converting)";
        String re2 = ".*?";
        String re3 = "(file)";
        String re4 = ".*?";
        String re5 = "(DWH)";
        String re6 = "(_)";
        String re7 = "((?:[a-z][a-z\\.\\d\\-]+)\\.(?:[a-z][a-z\\-]+))(?![\\w\\.])";    // Fully Qualified Domain Name 1
        String re8 = ".*?";
        String re9 = "(business)";
        String re10 = ".*?";
        String re11 = "(concept)";
        String re12 = ".*?";
        String re13 = "((?:[a-z][a-z]+))";

        Pattern p = Pattern.compile(re1 + re2 + re3 + re4 + re5 + re6 + re7 + re8 + re9 + re10 + re11 + re12 + re13, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find() && if1 == true) {
            String word1 = m.group(1);
            String word2 = m.group(2);
            String word3 = m.group(3);
            String c1 = m.group(4);
            String fqdn1 = m.group(5);
            String word4 = m.group(6);
            String word5 = m.group(7);
            String word6 = m.group(8);
            System.out.print("(" + word1.toString() + ")" + "(" + word2.toString() + ")" + "(" + word3.toString() + ")" + "(" + c1.toString() + ")" + "(" + fqdn1.toString() + ")" + "(" + word4.toString() + ")" + "(" + word5.toString() + ")" + "(" + word6.toString() + ")" + "\n");
            if1 = false;
        }
        String re21 = ".*?";
        String re22 = "(conversion)";
        String re32 = ".*?";
        String re42 = "(of)";
        String re52 = ".*?";
        String re62 = "(DWH)";
        String re72 = "(_)";
        String re82 = "((?:[a-z][a-z\\.\\d\\-]+)\\.(?:[a-z][a-z\\-]+))(?![\\w\\.])";    // Fully Qualified Domain Name 1
        String re92 = ".*?";
        String re102 = "((?:[a-z][a-z]+))";
        String re112 = ".*?";
        String re122 = "((?:[a-z][a-z]+))";
        String re132 = ".*?";
        String re142 = "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";    // Float 1
        String re152 = ".*?";
        String re162 = "(seconds)";

        Pattern p2 = Pattern.compile(re21 + re22 + re32 + re42 + re52 + re62 + re72 + re82 + re92 + re102 + re112 + re122 + re132 + re142 + re152 + re162, Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m2 = p2.matcher(txt);
        if (m.find() && if2 == true) {
            String word1 = m2.group(1);
            String word2 = m2.group(2);
            String word3 = m2.group(3);
            String c1 = m2.group(4);
            String fqdn1 = m2.group(5);
            String word4 = m2.group(6);
            String word5 = m2.group(7);
            String float1 = m2.group(8);
            String word6 = m2.group(9);
            System.out.print("(" + word1.toString() + ")" + "(" + word2.toString() + ")" + "(" + word3.toString() + ")" + "(" + c1.toString() + ")" + "(" + fqdn1.toString() + ")" + "(" + word4.toString() + ")" + "(" + word5.toString() + ")" + "(" + float1.toString() + ")" + "(" + word6.toString() + ")" + "\n");
            if2 = false;

        }
    }
    public void xmlToCsvII(String txt){
        String re21=".*?";String s="(conversion)"+".*?"+
        "(of)"+
        ".*?"+
        "(DWH)"+
        "(_)"+
        "((?:[a-z][a-z\\.\\d\\-]+)\\.(?:[a-z][a-z\\-]+))(?![\\w\\.])"+
        ".*?"+
        "((?:[a-z][a-z]+))"+
        ".*?"+
        "((?:[a-z][a-z]+))"+
        ".*?"+
        "([+-]?\\d*\\.\\d+)(?![-+0-9\\.])"+
        ".*?"+
        "(seconds)";
        String re22="(conversion)";
        String re32=".*?";
        String re42="(of)";
        String re52=".*?";
        String re62="(DWH)";
        String re72="(_)";
        String re82="((?:[a-z][a-z\\.\\d\\-]+)\\.(?:[a-z][a-z\\-]+))(?![\\w\\.])";	// Fully Qualified Domain Name 1
        String re92=".*?";
        String re102="((?:[a-z][a-z]+))";
        String re112=".*?";
        String re122="((?:[a-z][a-z]+))";
        String re132=".*?";
        String re142="([+-]?\\d*\\.\\d+)(?![-+0-9\\.])";	// Float 1
        String re152=".*?";
        String re162="(seconds)";

        Pattern p = Pattern.compile(re21+re22+re32+re42+re52+re62+re72+re82+re92+re102+re112+re122+re132+re142+re152+re162,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String word1=m.group(1);
            String word2=m.group(2);
            String word3=m.group(3);
            String c1=m.group(4);
            String fqdn1=m.group(5);
            String word4=m.group(6);
            String word5=m.group(7);
            String float1=m.group(8);
            String word6=m.group(9);
           // System.out.print("("+word1.toString()+")"+"("+word2.toString()+")"+"("+word3.toString()+")"+"("+c1.toString()+")"+"("+fqdn1.toString()+")"+"("+word4.toString()+")"+"("+word5.toString()+")"+"("+float1.toString()+")"+"("+word6.toString()+")"+"\n");
            //if2=false;
            XmlToCsv x=new XmlToCsv();
            x.setName(word3+c1+fqdn1);
            x.setStatus(word4);
            x.setDuration(Float.parseFloat(float1));
            System.out.println(x);
        }


    }




    public static void main(String[] args) throws IOException {

        StepExtractionService ses = new StepExtractionService();

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
        int counter = 0;
        int nbr=0;

        while ((strLine  = br.readLine()) != null) {
            ses.xmlToCsvII(strLine);
        if (strLine.contains("reporting job DWH_")){
            if(strLine.contains("minutes")){
                ses.jobReport(strLine);
            }
            else
          //  System.out.println("a");

            ses.reportJobII(strLine);
        }
            // ses.extractionInTables(strLine);
            //ses.runningMode(strLine);
            //ses.executingMode(strLine);
            //  ses.ITKBasedExtractionStatus(strLine);

            if (strLine.contains("[extractor.Extraction]")) {
                String s=strLine.replace(",","");
                String ss=s.substring(56,s.length());

               //System.out.println(ss);

                //ses.groupAllduration(strLine);
            //   ses.tableExtracted(strLine);
               //ses.satats(ss);

            }
            if (strLine.contains("DWH_TaxType-2152-018-02-07.xml")){

             //  ses.xmlToCsv(strLine);


                counter++;


            }

        }
        System.out.println(counter);



            /*if (strLine.contains("not executed (by configuration in ExtractionsConfiguration JSON)")){
                System.out.println(counter+"---"+strLine);
            }
*/



        in.close();
        //java888888888888888888888888888888888888888888888888888

        /*try (Stream<String> stream = Files.lines(Paths.get(filepath))) {

            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
        ///////////////////////////////////////////////////////
        List<String> list = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(filepath))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> line.startsWith("2018-02-07T10:42:02"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
        }

        list.forEach(c->c.split("(Executing)"));*/


    }
}