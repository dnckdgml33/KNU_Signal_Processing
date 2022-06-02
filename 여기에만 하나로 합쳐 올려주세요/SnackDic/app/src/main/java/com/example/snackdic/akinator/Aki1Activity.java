package com.example.snackdic.akinator;

import static com.example.snackdic.akinator.akiLibrary.akiScores;

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
import com.example.snackdic.MainActivity;
import com.example.snackdic.R;
import com.example.snackdic.popupActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class Aki1Activity extends AppCompatActivity {
    public static final String SCORES="SCORES";
    private int cost;
    private int amount=0;
    int mname;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aki1);

        TextView score = findViewById(R.id.score);
        Button mainButton = findViewById(R.id.aki_mainbutton);
        Button shopButton = findViewById(R.id.aki_shopbutton);
        ImageView picture = findViewById(R.id.aki_pic);
        TextView akiname = findViewById(R.id.aki_name);
        int[] answerList=getIntent().getIntArrayExtra(SCORES);//답안 저장하는 배열
        int money = answerList[0];
        int people = answerList[1];
        int how = answerList[2];
        int temp = answerList[3];
        int taste = answerList[4];
        for(int i=0;i<akiScores.length;i++) {
            amount+=akiScores[i][answerList[i+5]-1];
        }//양 계산
        Snack result= ExcelReader.readFromExcel(this, money, how, temp, taste,amount,people);//계산한 값을 가져옴


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
            Toast.makeText(Aki1Activity.this, "존재하지 않는 간식입니다", Toast.LENGTH_SHORT).show();//답변 미선택시 팝업
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            return;
        }

        shopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 간식 이름 클립보드 복사 위해 popupActivity로 전달
                Intent intent = new Intent(Aki1Activity.this, popupActivity.class);
                intent.putExtra("snack_name",result.getName());
                startActivity(intent);

            }
        });

    }
    public void getImgfromFirebase(){
        ImageView load;
        String str1 = "snackimg/";
        String to = Integer.toString(mname-1);
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

