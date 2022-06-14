package com.snack.snackdic.random;

import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.snack.snackdic.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class randompickActivity extends AppCompatActivity {

    int random;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randompick);

        getImgfromFirebase(); // 이미지 표시

    }


    // 랜덤 난수 생성기
    public int randommaker(){
        int randomNum = (int) (Math.random() * 10);
        return randomNum;
    }

    // 파이어베이스에서 이미지 가져오는 함수
    public void getImgfromFirebase() {
        random = randommaker(); // 난수 생성

            ImageView load;
            String str1 = "randompick/";
            String to = Integer.toString(random);
            str1 = str1.concat(to);
            str1 = str1.concat(".jpg");

            load = (ImageView) findViewById(R.id.rpimageView);
            FirebaseStorage storage = FirebaseStorage.getInstance("gs://snackdic-ee898.appspot.com/");
            StorageReference storageReference = storage.getReference();
            String finalStr = str1;
            storageReference.child(str1).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Glide.with(getApplicationContext()).load(uri).into(load);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            deleteImgfromFirebase(finalStr);
                        }
                    }, 3000);// 0.6초 정도 딜레이를 준 후 시작
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(getApplicationContext(), "사용된 기프티콘", Toast.LENGTH_SHORT).show();
                    load.setImageResource(R.drawable.ic_baseline_not_interested_24);
                    getImgfromFirebase();
                }
            });
    }

    // 파이어베이스 이미지 삭제
    public void deleteImgfromFirebase(String deldirectory) {
        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReference();

        StorageReference deleteRef = storageRef.child(deldirectory);
        deleteRef.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                Toast.makeText(getApplicationContext(),"삭제성공",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"삭제실패",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
