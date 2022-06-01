package com.example.snackdic.FBTI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.snackdic.MainActivity;
import com.example.snackdic.R;

public class testActivity extends AppCompatActivity {

    private MBTILibrary mMBTILibrary = new MBTILibrary();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;
    private Button mButtonChoice5;
    private Button mButtonChoice6;
    private Button mButtonChoice7;
    private Button mButtonGoback;

    private int mScore_rich = 0;
    private int mScore_sensitive = 0;
    private int mScore_challenge = 0;
    private int mScore_much = 0;
    private int ans[] = new int[17];
    public int mQuestionNumber = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        mQuestionNumber = 0;
        mScoreView = (TextView) findViewById(R.id.score);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);
        mButtonChoice5 = (Button) findViewById(R.id.choice5);
        mButtonChoice6 = (Button) findViewById(R.id.choice6);
        mButtonChoice7 = (Button) findViewById(R.id.choice7);
        mButtonGoback = (Button) findViewById(R.id.goback);

        updateQuestion();

        mButtonGoback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mQuestionNumber--;
                if(mQuestionNumber == 0){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
                updateScore(mQuestionNumber);
                mQuestionView.setText(mMBTILibrary.getQuestion(mQuestionNumber - 1));
            }
        });

        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 1;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });
        mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 2;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 3;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 4;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });

        mButtonChoice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 5;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });
        mButtonChoice6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 6;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });
        mButtonChoice7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans[mQuestionNumber] = 7;

                if(mQuestionNumber == 15){
                    mScore_sensitive = mMBTILibrary.getSen(ans[1],ans[5],ans[9],ans[13]);
                    mScore_rich = mMBTILibrary.getRic(ans[2],ans[6],ans[10],ans[14]);
                    mScore_much = mMBTILibrary.getMuc(ans[3],ans[7],ans[11],ans[15]);
                    mScore_challenge = mMBTILibrary.getCha(ans[4],ans[8],ans[12]);
                    Intent intent2 = new Intent(getApplicationContext(), MBTIRes.class);
                    intent2.putExtra("Sensitive",mScore_sensitive);
                    intent2.putExtra("Rich",mScore_rich);
                    intent2.putExtra("Much",mScore_much);
                    intent2.putExtra("Challenge",mScore_challenge);
                    startActivity(intent2);
                    mQuestionNumber--;
                }

                updateQuestion();
                updateScore(mQuestionNumber);
            }
        });

    }

    private void updateQuestion(){
        mQuestionView.setText(mMBTILibrary.getQuestion(mQuestionNumber));

        mQuestionNumber++;
    }



    private void updateScore(int point){
        mScoreView.setText("진행도 : " + mQuestionNumber + " / 15");
    }

}
