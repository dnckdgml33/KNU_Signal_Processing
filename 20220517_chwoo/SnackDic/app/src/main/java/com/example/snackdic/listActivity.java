package com.example.snackdic;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class listActivity extends AppCompatActivity {

    private ArrayList<TestVo> mArrayList;

    // 어댑터 선언
    private TestRecyclerViewAdapter mAdapter;
    int dataCount = -1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        RecyclerView mRecyclerView = findViewById(R.id.recycler_view);

        // 리사이클러뷰에 LinearLayoutManager 지정(vertical)
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        //mRecyclerView.setHasFixedSize(true);
        //setHasFixedSize(true) 메서드는 리사이클러뷰 안 아이템들의 크기를 가변적으로 적용할지, 일정한 고정 크기를 적용할지를 지정한다.
        //만약 false값으로 적용하면 매번 아이템들의 크기를 계산해야 하므로 성능 저하가 발생할 수 있다.


        // 수평으로 리사이클러뷰 아이템을 배치하고자 할때..
        //mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)) ;

        // 리사이클러뷰에 뿌려줄 데이터를 담을 ArrayList를 초기화
        mArrayList = new ArrayList<TestVo>();

        // 데이터 읽어 옴
        readFromExcel();
        readFromTxt();

        // 어댑터에 리스트에 뿌려줄 ArrayList를 적용.
        mAdapter = new TestRecyclerViewAdapter( mArrayList);
        mRecyclerView.setAdapter(mAdapter);

        // 하나씩 추가할 경우에 대한 테스트
        mAdapter.addItem(new TestVo(String.valueOf(101), "별도샘플" + String.valueOf(101)));

        // notifyDataSetChanged를 호출하여 adapter의 값이 변경되었다는 것을 알려준다.
        mAdapter.notifyDataSetChanged();
    }

    // 뒤로가기 버튼 누르면 스택 쌓인곳으로 가지말고 메인으로
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
        finish();
    }

    // 엑셀에서 읽어오는 함수 인코딩형식 UTF-8
    public void readFromExcel() {
        try {
            InputStream is = getBaseContext().getResources().getAssets().open("snack_list_bytab.xls");
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
                        for(int col=0;col<colTotal;col++) {
                            String contents = sheet.getCell(col, row).getContents();
                            sb.append("col"+col+" : "+contents+" , ");

                            if(col==1) // 대분류(ex. 패스트푸드, 분식, ...)
                            {
                                mArrayList.add(new TestVo(String.valueOf(row), contents + String.valueOf(row)));
                            }
                        }
                        Log.i("test", sb.toString());
                    }
                }
            }
        } catch (IOException | BiffException e) {
            e.printStackTrace();
        }
    }

    // txt에서 읽어오는 함수
    public void readFromTxt(){
        AssetManager am = getResources().getAssets();
        InputStream is = null;
        byte buf[] = new byte[5120];
        String text = "";

        try{
            is = am.open("snack_list_byname.txt");

            if(is.read(buf) > 0){
                text = new String(buf);
            }

            String[] word = text.split("\n");

            StringBuilder sb;
            for(int i = 0; i < word.length; ++i) {
                sb = new StringBuilder();
                sb.append("i is"+i+" : "+word[i]);
                Log.i("test", sb.toString());
            }

            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(is!=null){
            try{
                is.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }


}
