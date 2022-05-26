package com.example.snackdic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String checker = "false"; // retry 체크

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 유튜브 오류 해결위해 emptyActivity에서 받아오는 식으로 구현 시도중
        Intent intentget = getIntent();
        checker = intentget.getStringExtra("chk");
        //checker = "false";
        Toast.makeText(getApplicationContext(), checker, Toast.LENGTH_SHORT).show();

        String tmp = "true";
        /*if(checker.equals(tmp)){
            Toast.makeText(getApplicationContext(), checker, Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(getApplicationContext(), randomActivity.class);
            //startActivity(intent);
        }*/

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

        // 랜덤뽑기 버튼 클릭시 액티비티 전환
        Button pick_btn = (Button) findViewById(R.id.button_pick);
        pick_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(),"결제 성공 시 기프티콘 표시",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), randompickActivity.class);
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