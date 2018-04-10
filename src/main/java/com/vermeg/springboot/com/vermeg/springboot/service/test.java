package com.vermeg.springboot.com.vermeg.springboot.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
    public static void main(String[] args)
    {
        String txt="2018-02-07T10:42:02,831";

        String re1="((?:2|1)\\d{3}(?:-|\\/)(?:(?:0[1-9])|(?:1[0-2]))(?:-|\\/)(?:(?:0[1-9])|(?:[1-2][0-9])|(?:3[0-1]))(?:T|\\s)(?:(?:[0-1][0-9])|(?:2[0-3])):(?:[0-5][0-9]):(?:[0-5][0-9]))";	// Time Stamp 1

        Pattern p = Pattern.compile(re1);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String timestamp1=m.group(1);
            System.out.print("("+timestamp1.toString()+")"+"\n");
        }
    }
}
