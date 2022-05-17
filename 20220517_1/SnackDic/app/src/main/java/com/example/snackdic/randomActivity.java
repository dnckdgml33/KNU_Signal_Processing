package com.example.snackdic;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import com.bumptech.glide.Glide;


public class randomActivity extends AppCompatActivity {

    int random;
    Button buttonhome,buttonretry,buttonpopup;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        buttonhome = findViewById(R.id.rbuttonhome);
        buttonretry = findViewById(R.id.rbuttonretry);
        buttonpopup = findViewById(R.id.rbuttonpopup);

        // 홈으로
        buttonhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        // 다시 돌리기
        buttonretry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), randomActivity.class);
                startActivity(intent);
            }
        });

        random = randommaker();

        getImgfromFirebase();
        readFromExcel();
        readFromTxt();

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

            TextView textView = (TextView) findViewById(R.id.rtext);
            textView.setText(word[random]);

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

    // 랜덤 난수 생성기
    public int randommaker(){
        int randomNum = (int) (Math.random() * 218);
        return randomNum;
    }

    // 파이어베이스에서 이미지 가져오는 함수
    public void getImgfromFirebase(){
        ImageView load;
        String str1 = "snackimg/";
        String to = Integer.toString(random);
        str1 = str1.concat(to);
        str1 =  str1.concat(".jpg");

        load = (ImageView)findViewById(R.id.rimageView);
        FirebaseStorage storage = FirebaseStorage.getInstance("gs://snackdic-ee898.appspot.com/");
        StorageReference storageReference = storage.getReference();
        storageReference.child(str1).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(load);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
            }
        });

    }

}
