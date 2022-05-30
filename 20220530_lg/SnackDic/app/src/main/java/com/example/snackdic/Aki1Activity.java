package com.example.snackdic;

import static com.example.snackdic.akiLibrary.akiScores;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.snackdic.Snack;
import com.example.snackdic.ExcelReader;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Aki1Activity extends AppCompatActivity {
    public static final String SCORES="SCORES";
    private int money;//1
    private int people;//2
    private int cost;
    private int how;//3
    private int temp;//4
    private int taste;//5
    private int amount=0;
    int mname;

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
            mname=result.getUri();
            getImgfromFirebase();
        }
        else{
            akiname.setText("오류발생");
        }

    }
    public void getImgfromFirebase(){
        ImageView load;
        String str1 = "snackimg/";
        String to = Integer.toString(mname);
        str1 = str1.concat(to);
        str1 =  str1.concat(".jpg");

        load = (ImageView)findViewById(R.id.aki_pic);
        FirebaseStorage storage = FirebaseStorage.getInstance("gs://snackdic-ee898.appspot.com/");
        StorageReference storageReference = storage.getReference();
        storageReference.child(str1).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Glide.with(getApplicationContext()).load(uri).into(load);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"fail",Toast.LENGTH_SHORT).show();
            }
        });

    }
}

