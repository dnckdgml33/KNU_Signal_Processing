package com.example.snackdic;

import static com.example.snackdic.akiLibrary.akiScores;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.snackdic.data.Snack;
import com.example.snackdic.utils.ExcelReader;

public class Aki1Activity extends AppCompatActivity {
    public static final String SCORES="SCORES";
    private int money;//1
    private int people;//2
    private int cost;
    private int how;//3
    private int temp;//4
    private int taste;//5
    private int amount=0;

    private TextView score;
    private Button mainButton;
    private Button shopButton;
    private ImageView picture;
    private TextView akiname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aki1);

        score=findViewById(R.id.score);
        mainButton=findViewById(R.id.aki_mainbutton);
        shopButton=findViewById(R.id.aki_shopbutton);
        picture=findViewById(R.id.aki_pic);
        akiname=findViewById(R.id.aki_name);
        int[] answerList=getIntent().getIntArrayExtra(SCORES);//답안 저장하는 배열
        money=answerList[0];
        people=answerList[1];
        how=answerList[2];
        temp=answerList[3];
        taste=answerList[4];
        for(int i=0;i<akiScores.length;i++) {
            amount+=akiScores[i][answerList[i+5]-1];
        }//양 계산
        Snack result= ExcelReader.readFromExcel(this,money,how,temp,taste,amount);//계산한 값을 가져옴


        score.setText(amount+"");//점수
        mainButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }//메인화면으로 전환
        });
        if(result!=null){
            akiname.setText(result.getName());
            //picture.setImageResource(result.getUri());//이미지 처리
        }
        else{
            akiname.setText("오류발생");
        }

    }
}
