package com.github.uryyyyyyy.javaSamples.poi;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class Sample2_1{
    public static void main(String[] args){
        try {
            exec();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void exec() throws IOException {
        try(Workbook wb = new HSSFWorkbook()){
            createWB(wb);
        }
    }

    private static void createWB(Workbook wb) throws IOException {
        try(FileOutputStream out = new FileOutputStream("sample2_1.xls");){
            wb.write(out);
        }
    }
}