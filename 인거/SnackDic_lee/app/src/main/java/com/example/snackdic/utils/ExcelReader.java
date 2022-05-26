package com.example.snackdic.utils;

import android.content.Context;

import com.example.snackdic.data.Snack;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {

    public static Snack readFromExcel(Context context,int money,int how,int temp,int taste,int amount) {
        ArrayList<Snack> snacks=new ArrayList<>();

        try {
            InputStream is = context.getResources().getAssets().open("snack_list_bytab.xls");
            Workbook wb = Workbook.getWorkbook(is);

            if(wb != null) {
                Sheet sheet = wb.getSheet(0);   // 시트 불러오기
                if(sheet != null) {
                    int colTotal = sheet.getColumns();    // 전체 컬럼
                    int rowIndexStart = 1;                  // row 인덱스 시작
                    int rowTotal = sheet.getColumn(colTotal-1).length;

                    StringBuilder sb;
                    for(int row=rowIndexStart;row<rowTotal;row++) {
                        sb = new StringBuilder();
                        String name = sheet.getCell(1, row).getContents();

                        int ncost = Integer.parseInt(sheet.getCell(4, row).getContents());
                        int nhow = Integer.parseInt(sheet.getCell(6, row).getContents());
                        int ntemp = Integer.parseInt(sheet.getCell(8, row).getContents());
                        int ntaste = Integer.parseInt(sheet.getCell(10, row).getContents());
                        int namount = Integer.parseInt(sheet.getCell(9, row).getContents());

                        if(ncost>money||namount>amount){
                            continue;
                        }//나머지 if문 처리

                        snacks.add(new Snack(name,"uri"));
                    }
                    //랜덤으로 뽑기
                }
            }
            return null;
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
        return null;

    }
}
