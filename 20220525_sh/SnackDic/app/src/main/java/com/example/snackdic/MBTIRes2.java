package com.example.snackdic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MBTIRes2 extends AppCompatActivity {

    private MBTILibrary mMBTILibrary = new MBTILibrary();
    Intent intent5;

    private int Rich;
    private int Sensitive;
    private int Challenge;
    private int Much;
    private String mbti;
    private String fbti;
    private int mbtinum;

    private ProgressBar progressBar_Rich;
    private ProgressBar progressBar_Sensitive;
    private ProgressBar progressBar_Challenge;
    private ProgressBar progressBar_Much;

    private TextView mRichView;
    private TextView mSensitiveView;
    private TextView mChallengeView;
    private TextView mMuchView;
    private TextView mEconomyView;
    private TextView mNonsensitiveView;
    private TextView mFixedView;
    private TextView mLittleView;

    private TextView mMbti1;
    private TextView mMbti2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtires2);

        intent5 = getIntent();
        Rich = intent5.getIntExtra("Rich",0);
        Sensitive = intent5.getIntExtra("Sensitive",0);
        Challenge = intent5.getIntExtra("Challenge",0);
        Much = intent5.getIntExtra("Much",0);
        mbti = intent5.getStringExtra("Mbti");
        fbti = intent5.getStringExtra("Fbti");
        mbtinum = intent5.getIntExtra("num",0);

        progressBar_Rich = (ProgressBar) findViewById(R.id.Rich_Bar);
        progressBar_Sensitive = (ProgressBar) findViewById(R.id.Sensitive_Bar);
        progressBar_Challenge = (ProgressBar) findViewById(R.id.Challenge_Bar);
        progressBar_Much = (ProgressBar) findViewById(R.id.Much_Bar);

        mRichView = (TextView) findViewById(R.id.rich_per);
        mSensitiveView = (TextView) findViewById(R.id.sensitive_per);
        mChallengeView = (TextView) findViewById(R.id.challenge_per);
        mMuchView = (TextView) findViewById(R.id.much_per);
        mEconomyView = (TextView) findViewById(R.id.economy_per);
        mNonsensitiveView = (TextView) findViewById(R.id.nonsensitive_per);
        mFixedView = (TextView) findViewById(R.id.fixed_per);
        mLittleView = (TextView) findViewById(R.id.little_per);
        mMbti1 = (TextView) findViewById(R.id.Mbti1);
        mMbti2 = (TextView) findViewById(R.id.simple);

        mRichView.setText("Rich ("+Rich+"%)");
        mSensitiveView.setText("Sensitive ("+Sensitive+"%)");
        mChallengeView.setText("Challenge ("+Challenge+"%)");
        mMuchView.setText("Much ("+Much+"%)");

        mEconomyView.setText("("+(100-Rich)+"%) Economy");
        mNonsensitiveView.setText("("+(100-Sensitive)+"%) Non-sensitive");
        mFixedView.setText("("+(100-Challenge)+"%) Fixed");
        mLittleView.setText("("+(100-Much)+"%) Little");

        mMbti1.setText(mbti + " - " + fbti);
        mMbti2.setText(mMBTILibrary.getSimple(mbtinum));

        progressBar_Rich.setProgress(Rich);
        progressBar_Rich.setMax(100);
        progressBar_Sensitive.setProgress(Sensitive);
        progressBar_Sensitive.setMax(100);
        progressBar_Challenge.setProgress(Challenge);
        progressBar_Challenge.setMax(100);
        progressBar_Much.setProgress(Much);
        progressBar_Much.setMax(100);


    }

}