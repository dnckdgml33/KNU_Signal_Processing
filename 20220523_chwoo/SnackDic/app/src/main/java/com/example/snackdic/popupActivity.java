package com.example.snackdic;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class popupActivity extends AppCompatActivity {

    Button near, appconnect, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_popup);

        near = (Button) findViewById(R.id.near_Button);
        appconnect = (Button) findViewById(R.id.app_Button);
        cancel = (Button) findViewById(R.id.cancel_Button);
    }

    // 주변보기 버튼 클릭
    public void mNear(View v){

        finish();
    }

    // 배달앱 연결 버튼 클릭
    public void mAppConnect(View v){

        finish();
    }

    // 닫기 연결 버튼 클릭
    public void mCancel(View v){
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        // 바깥레이어 클릭시 닫히지 않게
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        // 안드로이드 백버튼 막기
        return;
    }

}
