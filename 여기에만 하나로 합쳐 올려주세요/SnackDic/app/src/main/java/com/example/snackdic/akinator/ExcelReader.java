package com.example.snackdic.akinator;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelReader {
    int row;
    public static Snack readFromExcel(Context context, int money, int how, int temp, int taste, int amount, int people) {
        ArrayList<Snack> snacks=new ArrayList<Snack>();
        if (money*people<=4){
            money=money*people;
        }
        else if(money*people>4){
            money=4;
        }
        try {
            InputStream is = context.getResources().getAssets().open("snack_list_bytab1.xls");
            Workbook wb = Workbook.getWorkbook(is);

            if(wb != null) {
                Sheet sheet = wb.getSheet(0);   // 시트 불러오기
                if(sheet != null) {
                    int colTotal = sheet.getColumns();    // 전체 컬럼
                    int rowIndexStart = 0;                  // row 인덱스 시작
                    int rowTotal = sheet.getColumn(colTotal-1).length;

                    StringBuilder sb;
                    for(int row=rowIndexStart;row<rowTotal;row++) {
                        sb = new StringBuilder();
                        String name = sheet.getCell(3, row).getContents();
                        int nuri=Integer.parseInt(sheet.getCell(0, row).getContents());
                        int ncost = Integer.parseInt(sheet.getCell(6, row).getContents());
                        int nhow = Integer.parseInt(sheet.getCell(8, row).getContents());
                        int ntemp = Integer.parseInt(sheet.getCell(11, row).getContents());
                        int ntaste = Integer.parseInt(sheet.getCell(10, row).getContents());
                        int namount = Integer.parseInt(sheet.getCell(9, row).getContents());
                        int ncal = Integer.parseInt(sheet.getCell(7, row).getContents());

                        if(ncost<=money&&namount<=amount){
                            if(temp==4||temp==ntemp) {
                                if (taste == 4 || taste == ntaste) {
                                    if(how==4){
                                        snacks.add(new Snack(name,nuri,ncal));
                                    }
                                    else if(how==nhow){
                                        snacks.add(new Snack(name,nuri,ncal));
                                    }
                                    else{
                                        continue;
                                    }
                                }
                            }
                        }

                    }
                }
            }

            int lent=snacks.size();
            if(lent==0){
                return null;
            }
            else {
                int num = (int) (Math.random() * (lent));
                return snacks.get(num);


            }
        }
        catch (IOException | BiffException e) {
            e.printStackTrace();
        }


        return null;
    }
}
