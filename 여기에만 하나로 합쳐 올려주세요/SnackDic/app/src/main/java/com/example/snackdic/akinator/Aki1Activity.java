package com.example.snackdic.akinator;

import static com.example.snackdic.akinator.akiLibrary.akiScores;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
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
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class Aki1Activity extends YouTubeBaseActivity{
    public static final String SCORES="SCORES";
    private int cost;
    private int amount=0;
    int mname;
    private Intent intent;

    //객체 선언
    YouTubePlayerView playerView;
    YouTubePlayer player;
    //유튜브 API KEY와 동영상 ID 변수 설정
    private static String API_KEY = "AIzaSyBHoQH3xkRiQz7UMR9qYaASxJBPPo0-LBs";
    //https://www.youtube.com/watch?v=hl-ii7W4ITg ▶ 유튜브 동영상 v= 다음 부분이 videoId
    private static String videoId = "t2rmf3LRajw";
    //logcat 사용 설정
    private static final String TAG = "listEndActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aki1);

        TextView score = findViewById(R.id.score);
        Button mainButton = findViewById(R.id.aki_mainbutton);
        Button shopButton = findViewById(R.id.aki_shopbutton);
        ImageView picture = findViewById(R.id.aki_pic);
        TextView akiname = findViewById(R.id.aki_name);
        TextView akikcal=findViewById(R.id.aki_kcal);
        int[] answerList=getIntent().getIntArrayExtra(SCORES);//답안 저장하는 배열
        int money = answerList[0];
        int people = answerList[1];
        int how = answerList[2];
        int temp = answerList[3];
        int taste = answerList[4];

        initPlayer();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                playVideo();
                //딜레이 후 시작할 코드 작성
            }
        }, 3000);// 3초 정도 딜레이를 준 후 시작

        for(int i=0;i<akiScores.length;i++) {
            amount+=akiScores[i][answerList[i+5]-1];
        }//양 계산
        Snack result= ExcelReader.readFromExcel(this, money, how, temp, taste,amount,people);//계산한 값을 가져옴


        if(result != null) {
            score.setText(amount + "점");//점수
            akikcal.setText(result.getKcal() + "kcal");
        }
        else{
            Toast.makeText(Aki1Activity.this, "현재 저희 앱에 존재하지 않는 간식이에요 ㅠㅠ", Toast.LENGTH_LONG).show();//답변 미선택시 팝업
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
            //finish();
            return;
        }


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
                System.out.println(result.getSearch());
                intent.putExtra("snack_name",result.getName());
                intent.putExtra("snack_search",result.getSearch());
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
        Glide.with(this).load(R.raw.ic_loading_img).into(load);
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
                load.setImageResource(R.drawable.ic_baseline_not_interested_24);
            }
        });

    }
    private void playVideo() {
        if(player != null) {
            if(player.isPlaying()) {
                player.pause();
            }
            player.cueVideo(videoId);
        }
    }
    //유튜브 플레이어 메서드
    private void initPlayer() {
        playerView = findViewById(R.id.youTubePlayerView3);
        playerView.initialize(API_KEY, new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                player = youTubePlayer;
                player.setPlayerStateChangeListener(new YouTubePlayer.PlayerStateChangeListener() {
                    @Override
                    public void onLoading() {
                    }
                    @Override
                    public void onLoaded(String id) {
                        Log.d(TAG, "onLoaded: " + id);
                        player.play();
                    }
                    @Override
                    public void onAdStarted() {
                    }
                    @Override
                    public void onVideoStarted() {
                    }
                    @Override
                    public void onVideoEnded() {
                    }
                    @Override
                    public void onError(YouTubePlayer.ErrorReason errorReason) {
                        Log.d(TAG, "onError: " + errorReason);
                    }
                });
            }
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        });
    }
}
