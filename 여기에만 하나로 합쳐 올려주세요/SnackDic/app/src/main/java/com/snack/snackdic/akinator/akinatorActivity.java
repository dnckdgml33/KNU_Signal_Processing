package com.snack.snackdic.akinator;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.snack.snackdic.MainActivity;
import com.snack.snackdic.R;

public class akinatorActivity extends AppCompatActivity {
    private TextView akiQues;
    private Button akiAns1;
    private Button akiAns2;
    private Button akiAns3;
    private Button akiAns4;
    private Button goback;
    private TextView akiProgress;
    private int current=0;
    private int[] answerList=new int[11];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_akinator);
        akiQues=findViewById(R.id.aki_ques);
        akiAns1=findViewById(R.id.aki_ans1);
        akiAns2=findViewById(R.id.aki_ans2);
        akiAns3=findViewById(R.id.aki_ans3);
        akiAns4=findViewById(R.id.aki_ans4);
        goback=findViewById(R.id.goback1);
        akiProgress=findViewById(R.id.aki_progress);

        goback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(current == 0){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                current--;
                update();
            }
        });

        update();
        akiAns1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selectAnswer(view,1);
                current++;
                if(current>= akiLibrary.END){
                    Intent intent = new Intent(getApplicationContext(), Aki1Activity.class);
                    intent.putExtra(Aki1Activity.SCORES,answerList);
                    startActivity(intent);
                    return;
                }//????????? ??? ??????????????? ?????????????????? ??????

                update();
            }
        });
        akiAns2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selectAnswer(view,2);
                current++;
                if(current>= akiLibrary.END){
                    Intent intent = new Intent(getApplicationContext(), Aki1Activity.class);
                    intent.putExtra(Aki1Activity.SCORES,answerList);
                    startActivity(intent);
                    return;
                }//????????? ??? ??????????????? ?????????????????? ??????

                update();
            }
        });
        akiAns3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selectAnswer(view,3);
                current++;
                if(current>= akiLibrary.END){
                    Intent intent = new Intent(getApplicationContext(), Aki1Activity.class);
                    intent.putExtra(Aki1Activity.SCORES,answerList);
                    startActivity(intent);
                    return;
                }//????????? ??? ??????????????? ?????????????????? ??????

                update();
            }
        });
        akiAns4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                selectAnswer(view,4);
                current++;
                if(current>= akiLibrary.END){
                    Intent intent = new Intent(getApplicationContext(), Aki1Activity.class);
                    intent.putExtra(Aki1Activity.SCORES,answerList);
                    startActivity(intent);
                    return;
                }//????????? ??? ??????????????? ?????????????????? ??????

                update();
            }
        });


    }
    @SuppressLint("SetTextI18n")
    private void update(){
        akiQues.setText(akiLibrary.akiQuestion[current]);
        akiAns1.setText(akiLibrary.akiAnswer[current][0]);
        akiAns2.setText(akiLibrary.akiAnswer[current][1]);
        akiAns3.setText(akiLibrary.akiAnswer[current][2]);
        akiAns4.setText(akiLibrary.akiAnswer[current][3]);
        LinearLayout buttons=findViewById(R.id.buttons);

        akiProgress.setText(current+1+"/10");
    }//??????????????? ?????????????????????
    private void selectAnswer(View view,int num){
        ViewGroup parent= (ViewGroup) view.getParent();


        answerList[current]=num;
    }//?????? ???????????? ????????? ????????? ?????????
}