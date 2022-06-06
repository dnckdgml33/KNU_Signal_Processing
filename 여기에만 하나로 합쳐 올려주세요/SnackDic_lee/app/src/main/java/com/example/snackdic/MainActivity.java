package com.example.snackdic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.snackdic.FBTI.testActivity;
import com.example.snackdic.akinator.akinatorActivity;
import com.example.snackdic.random.randomActivity;
import com.example.snackdic.random.randompickActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 분류별 보기 버튼 클릭시 액티비티 전환
        LinearLayout list_btn = (LinearLayout) findViewById(R.id.button_list);
        list_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), listActivity.class);
                startActivity(intent);
            }
        });

        // 랜덤 버튼 클릭시 액티비티 전환
        LinearLayout random_btn = (LinearLayout) findViewById(R.id.button_random);
        random_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), randomActivity.class);
                startActivity(intent);
            }
        });

        // 스무고개 버튼 클릭시 액티비티 전환
        LinearLayout akinator_btn = (LinearLayout) findViewById(R.id.button_akinator);
        akinator_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), akinatorActivity.class);
                startActivity(intent);
            }
        });

        // 성향검사 버튼 클릭시 액티비티 전환
        LinearLayout test_btn = (LinearLayout) findViewById(R.id.button_test);
        test_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), testActivity.class);
                startActivity(intent);
            }
        });


        // 커스텀 다이얼로그를 호출할 버튼을 정의한다.
        ImageButton question_btn = (ImageButton) findViewById(R.id.button_question);

        // 커스텀 다이얼로그 호출할 클릭 이벤트 리스너 정의
        question_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 커스텀 다이얼로그를 생성한다. 사용자가 만든 클래스이다.
                CustomDialog2 customDialog = new CustomDialog2(MainActivity.this);

                // 커스텀 다이얼로그를 호출한다.
                customDialog.callFunction();
            }
        });
    }


    // 뒤로가기 버튼 누르면 즉시 종료
    @Override
    public void onBackPressed() {
        // super.onBackPressed();
        finishAffinity();
        System.runFinalization();
        System.exit(0);
    }

}