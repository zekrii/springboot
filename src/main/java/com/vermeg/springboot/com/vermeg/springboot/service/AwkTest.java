package com.vermeg.springboot.com.vermeg.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AwkTest {

    public static void main(String[] args) throws IOException {

/*
        Runtime r = Runtime.getRuntime();
        Process p = null;
        try {
            p = r.exec("awk -F\":\" '/in/ {print $3}' script.awk");

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            p.waitFor();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        System.out.println("esto es una \"prueba\"");
        String valor = "";
        while ((valor = in.readLine()) != null) {
            System.out.println(valor);
        }*/
        String command="awk  ' /[/','/]/'  E:/ExtractDwhData_2018-02-07_104202.log > E:/doc.txt";



       String c="awk  \" /Solife DWH data EXTRACTION/\",/REPORT/  E:/ExtractDwhData_2018-02-07_104202.log > E:/doc.txt";

        try {
            Process process = Runtime.getRuntime().exec(c);
            System.out.println("the output stream is "+process.getOutputStream());
            BufferedReader reader=new BufferedReader( new InputStreamReader(process.getInputStream()));
            String s;
            while ((s = reader.readLine()) != null){
                System.out.println("The inout stream is " + s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
