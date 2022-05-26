package com.example.snackdic;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class emptyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        //인텐트 선언 및 정의
        String text = "true";
        Intent intent = new Intent(emptyActivity.this, MainActivity.class);
        //입력한 input값을 intent로 전달한다.
        intent.putExtra("chk", text);
        //액티비티 이동
        startActivity(intent);
    }
}
