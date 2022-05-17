package com.example.snackdic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 분류별 보기 버튼 클릭시 액티비티 전환
        Button list_btn = (Button) findViewById(R.id.button_list);
        list_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), listActivity.class);
                startActivity(intent);
            }
        });

        // 랜덤 버튼 클릭시 액티비티 전환
        Button random_btn = (Button) findViewById(R.id.button_random);
        random_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), randomActivity.class);
                startActivity(intent);
            }
        });

        // 스무고개 버튼 클릭시 액티비티 전환
        Button akinator_btn = (Button) findViewById(R.id.button_akinator);
        akinator_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), akinatorActivity.class);
                startActivity(intent);
            }
        });

        // 성향검사 버튼 클릭시 액티비티 전환
        Button test_btn = (Button) findViewById(R.id.button_test);
        test_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), testActivity.class);
                startActivity(intent);
            }
        });

    }



}