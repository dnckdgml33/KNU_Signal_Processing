package com.example.snackdic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.security.PrivateKey;

public class MBTIRes extends AppCompatActivity {

    private testActivity mTestActivity = new testActivity();
    Intent intent3;

        private int Rich;
        private int Sensitive;
        private int Challenge;
        private int Much;
        private String re, sn, cf, ml;
        private String mbti;
        private String fbti;

        private TextView mRichView;
        private TextView mSensitiveView;
        private TextView mChallengeView;
        private TextView mMuchView;
        private TextView mResult;
        private TextView mResult_fbti;

        private Button details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtires);

        mRichView = (TextView) findViewById(R.id.score_rich);
        mSensitiveView = (TextView) findViewById(R.id.score_sensitive);
        mChallengeView = (TextView) findViewById(R.id.score_challenge);
        mMuchView = (TextView) findViewById(R.id.score_much);
        mResult = (TextView) findViewById(R.id.result2);
        mResult_fbti = (TextView) findViewById(R.id.fbti_res);
        details =(Button) findViewById(R.id.details);

        intent3 = getIntent();
        Rich = intent3.getIntExtra("Rich",0);
        Sensitive = intent3.getIntExtra("Sensitive",0);
        Challenge = intent3.getIntExtra("Challenge",0);
        Much = intent3.getIntExtra("Much",0);

        if(Rich > 50) re = "R";
        else re = "E";
        if(Sensitive > 50) sn = "S";
        else sn = "N";
        if(Challenge > 50) cf = "C";
        else cf = "F";
        if(Much > 50) ml = "M";
        else ml = "L";
        mbti = re+sn+cf+ml;

        if(mbti.equals("RSCM")) fbti = "정열적인 모험가";
        else if(mbti.equals("RSCL")) fbti = "여유로운 여행객";
        else if(mbti.equals("RSFM")) fbti = "푸근한 연예인";
        else if(mbti.equals("RSFL")) fbti = "우아한 요리사";
        else if(mbti.equals("RNCM")) fbti = "4차원 노찌롱";
        else if(mbti.equals("RNCL")) fbti = "호기심 많은 제리";
        else if(mbti.equals("RNFM")) fbti = "소잡는 씨름선수";
        else if(mbti.equals("RNFL")) fbti = "느긋한 스님";
        else if(mbti.equals("ESCM")) fbti = "경쾌한 투우사";
        else if(mbti.equals("ESCL")) fbti = "고독한 미식가";
        else if(mbti.equals("ESFM")) fbti = "묵직한 여고생";
        else if(mbti.equals("ESFL")) fbti = "사랑에 빠진 음유시인";
        else if(mbti.equals("ENCM")) fbti = "본능적인 격투가";
        else if(mbti.equals("ENCL")) fbti = "섬세한 예술가";
        else if(mbti.equals("ENFM")) fbti = "상남자 남고생";
        else if(mbti.equals("ENFL")) fbti = "평화로운 자연인";

        mResult_fbti.setText(fbti);
        mResult.setText(""+mbti);

        mRichView.setText(""+Rich);
        mSensitiveView.setText(""+Sensitive);
        mChallengeView.setText(""+Challenge);
        mMuchView.setText(""+Much);


        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), MBTIRes2.class);
                intent4.putExtra("Sensitive",Sensitive);
                intent4.putExtra("Rich",Rich);
                intent4.putExtra("Much",Much);
                intent4.putExtra("Challenge",Challenge);
                startActivity(intent4);
            }
        });
    }

}