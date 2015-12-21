package com.github.uryyyyyyy.javaSamples.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import java.io.*;

public class Sample2_1{
    public static void main(String[] args){
        Workbook wb = new HSSFWorkbook();

        FileOutputStream out = null;
        try{
            out = new FileOutputStream("sample2_1.xls");
            wb.write(out);
        }catch(IOException e){
            System.out.println(e.toString());
        }finally{
            try {
                assert out != null;
                out.close();
            }catch(IOException e){
                System.out.println(e.toString());
            }
        }
    }
}