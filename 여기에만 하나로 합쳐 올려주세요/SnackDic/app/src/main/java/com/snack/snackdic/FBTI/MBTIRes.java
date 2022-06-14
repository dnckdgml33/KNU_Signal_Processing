package com.snack.snackdic.FBTI;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.snack.snackdic.MainActivity;
import com.snack.snackdic.R;

public class MBTIRes extends AppCompatActivity {

    Intent intent3;

    private int Rich;
    private int Sensitive;
    private int Challenge;
    private int Much;
    private String re, sn, cf, ml;
    private String mbti;
    private String fbti;
    private int num;

    private TextView mResult;
    private TextView mResult_fbti;

    private Button details;
    private Button gohome;

    ImageView imageview = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtires);

        mResult = (TextView) findViewById(R.id.result2);
        mResult_fbti = (TextView) findViewById(R.id.fbti_res);
        details =(Button) findViewById(R.id.details);
        gohome = (Button) findViewById(R.id.goHome);
        imageview = (ImageView) findViewById(R.id.img);

        intent3 = getIntent();
        Rich = intent3.getIntExtra("Rich",0);
        Sensitive = intent3.getIntExtra("Sensitive",0);
        Challenge = intent3.getIntExtra("Challenge",0);
        Much = intent3.getIntExtra("Much",0);

        Rich *= 2;
        if(Rich >= 0) Rich++;
        else Rich--;
        Sensitive *= 2;
        if(Sensitive >= 0) Sensitive++;
        else Sensitive--;
        Challenge *= 2;
        if(Challenge > 0) Challenge++;
        else Challenge--;
        Much *= 2;
        if(Much >= 0) Much++;
        else Much--;

        Rich +=50;
        Sensitive += 50;
        Challenge += 50;
        Much += 50;

        if(Rich > 50) re = "R";
        else re = "E";
        if(Sensitive > 50) sn = "S";
        else sn = "N";
        if(Challenge > 50) cf = "C";
        else cf = "F";
        if(Much > 50) ml = "M";
        else ml = "L";
        mbti = re+sn+cf+ml;

        if(Rich <= 50) num += 8;
        if(Sensitive <= 50) num += 4;
        if(Challenge <= 50) num += 2;
        if(Much <= 50) num++;

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;

        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.image2, options);

        if(mbti.equals("RSCM")){
            fbti = "정열적인 모험가";
            Glide.with(this).load(R.drawable.image0).into(imageview);
        }
        else if(mbti.equals("RSCL")){
            fbti = "여유로운 여행객";
            Glide.with(this).load(R.drawable.image1).into(imageview);
        }
        else if(mbti.equals("RSFM")) {
            fbti = "푸근한 연예인";
            Glide.with(this).load(R.drawable.image2).into(imageview);
        }
        else if(mbti.equals("RSFL")) {
            fbti = "우아한 요리사";
            Glide.with(this).load(R.drawable.image3).into(imageview);
        }
        else if(mbti.equals("RNCM")) {
            fbti = "4차원 노찌롱";
            Glide.with(this).load(R.drawable.image4).into(imageview);
        }
        else if(mbti.equals("RNCL")) {
            fbti = "호기심 많은 제리";
            Glide.with(this).load(R.drawable.image5).into(imageview);
        }
        else if(mbti.equals("RNFM")) {
            fbti = "소 잡는 씨름선수";
            Glide.with(this).load(R.drawable.image6).into(imageview);
        }
        else if(mbti.equals("RNFL")) {
            fbti = "느긋한 스님";
            Glide.with(this).load(R.drawable.image7).into(imageview);
        }
        else if(mbti.equals("ESCM")) {
            fbti = "경쾌한 투우사";
            Glide.with(this).load(R.drawable.image8).into(imageview);
        }
        else if(mbti.equals("ESCL")) {
            fbti = "고독한 미식가";
            Glide.with(this).load(R.drawable.image9).into(imageview);
        }
        else if(mbti.equals("ESFM")) {
            fbti = "묵직한 여고생";
            Glide.with(this).load(R.drawable.image10).into(imageview);
        }
        else if(mbti.equals("ESFL")) {
            fbti = "사랑에 빠진 음유시인";
            Glide.with(this).load(R.drawable.image11).into(imageview);
        }
        else if(mbti.equals("ENCM")) {
            fbti = "본능적인 격투가";
            Glide.with(this).load(R.drawable.image12).into(imageview);
        }
        else if(mbti.equals("ENCL")) {
            fbti = "섬세한 예술가";
            imageview.setImageResource(R.drawable.image13);
        }
        else if(mbti.equals("ENFM")) {
            fbti = "상남자 남고생";
            Glide.with(this).load(R.drawable.image14).into(imageview);
        }
        else if(mbti.equals("ENFL")) {
            fbti = "평화로운 자연인";
            Glide.with(this).load(R.drawable.image15).into(imageview);
        }

        mResult_fbti.setText(fbti);
        mResult.setText(""+mbti);



        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), MBTIRes2.class);
                intent4.putExtra("Sensitive",Sensitive);
                intent4.putExtra("Rich",Rich);
                intent4.putExtra("Much",Much);
                intent4.putExtra("Challenge",Challenge);
                intent4.putExtra("Mbti", mbti);
                intent4.putExtra("Fbti", fbti);
                intent4.putExtra("num", num);
                startActivity(intent4);
            }
        });
        gohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}