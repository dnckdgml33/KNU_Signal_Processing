package com.example.snackdic;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class emptyActivity extends AppCompatActivity {

    private String TAG = "VideoActivity";
    VideoView vv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);

        vv= findViewById(R.id.rvideoview);
        Uri videoUri= Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.sample_test);
        vv.setVideoURI(videoUri);

        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                //비디오 시작
                vv.start();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(emptyActivity.this, randomActivity.class);
                //입력한 input값을 intent로 전달한다.
                //액티비티 이동
                startActivity(intent);
                //딜레이 후 시작할 코드 작성
            }
        }, 3000);// 3초 정도 딜레이를 준 후 시작


    }
}
