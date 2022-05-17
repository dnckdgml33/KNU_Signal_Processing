package com.example.snackdic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

    private int mScore_rich = 50;
    private int mScore_sensitive = 50;
    private int mScore_challenge = 50;
    private int mScore_much = 50;
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
        updateQuestion();
        mButtonChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mQuestionNumber % 4 == 1){
                    if(mQuestionNumber > 8) mScore_sensitive++;
                    mScore_sensitive -= 13;
                }
                else if(mQuestionNumber % 4 == 2){
                    if(mQuestionNumber < 9) mScore_rich++;
                    mScore_rich -= 13;
                }
                else if(mQuestionNumber % 4 == 3){
                    if(mQuestionNumber < 9) mScore_much++;
                    mScore_much -= 13;
                }
                else if(mQuestionNumber % 4 == 0){
                    if(mQuestionNumber == 4) mScore_challenge -= 16;
                    else mScore_challenge += 17;
                }
                if(mQuestionNumber == 15){
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
                if(mQuestionNumber % 4 == 1){
                    mScore_sensitive -= 8;
                }
                else if(mQuestionNumber % 4 == 2){
                    mScore_rich -= 8;
                }
                else if(mQuestionNumber % 4 == 3){
                    mScore_much -= 8;
                }
                else if(mQuestionNumber % 4 == 0){
                    if(mQuestionNumber == 4) mScore_challenge -= 11;
                    else mScore_challenge += 11;
                }
                if(mQuestionNumber == 15){
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
                if(mQuestionNumber % 4 == 1){
                    mScore_sensitive -= 4;
                }
                else if(mQuestionNumber % 4 == 2){
                    mScore_rich -= 4;
                }
                else if(mQuestionNumber % 4 == 3){
                    mScore_much -= 4;
                }
                else if(mQuestionNumber % 4 == 0){
                    if(mQuestionNumber == 4) mScore_challenge -= 6;
                    else mScore_challenge += 5;
                }
                if(mQuestionNumber == 15){
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
                if(mQuestionNumber == 1) mScore_sensitive++;
                if(mQuestionNumber == 6) mScore_rich++;
                if(mQuestionNumber == 11) mScore_much++;
                if(mQuestionNumber == 4) mScore_challenge++;
                if(mQuestionNumber == 15){
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
                if(mQuestionNumber % 4 == 1){
                    if(mQuestionNumber < 9) mScore_sensitive++;
                    mScore_sensitive += 4;
                }
                else if(mQuestionNumber % 4 == 2){
                    mScore_rich += 4;
                }
                else if(mQuestionNumber % 4 == 3){
                    if(mQuestionNumber == 11) mScore_much++;
                    mScore_much += 4;
                }
                else if(mQuestionNumber % 4 == 0){
                    if(mQuestionNumber == 4) mScore_challenge += 6;
                    else mScore_challenge -= 5;
                }
                if(mQuestionNumber == 15){
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
                if(mQuestionNumber % 4 == 1){
                    if(mQuestionNumber < 9) mScore_sensitive++;
                    mScore_sensitive += 8;
                }
                else if(mQuestionNumber % 4 == 2){
                    mScore_rich += 8;
                }
                else if(mQuestionNumber % 4 == 3){
                    if(mQuestionNumber == 11) mScore_much++;
                    mScore_much += 8;
                }
                else if(mQuestionNumber % 4 == 0){
                    if(mQuestionNumber == 4) mScore_challenge += 12;
                    else mScore_challenge -= 11;
                }
                if(mQuestionNumber == 15){
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
                if(mQuestionNumber % 4 == 1){
                    if(mQuestionNumber > 8) mScore_sensitive--;
                    mScore_sensitive += 13;
                }
                else if(mQuestionNumber % 4 == 2){
                    if(mQuestionNumber < 9) mScore_rich--;
                    mScore_rich += 13;
                }
                else if(mQuestionNumber % 4 == 3){
                    if(mQuestionNumber < 9) mScore_much--;
                    mScore_much += 13;
                }
                else if(mQuestionNumber % 4 == 0){
                    if(mQuestionNumber == 4) mScore_challenge += 16;
                    else mScore_challenge -= 17;
                }
                if(mQuestionNumber == 15){
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
        mScoreView.setText("" + mQuestionNumber + " / 15");
    }

}
