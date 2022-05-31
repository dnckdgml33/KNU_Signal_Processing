package com.example.snackdic;

import android.Manifest;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.List;

public class popupActivity extends AppCompatActivity {

    Button near, appconnect, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 현재 위치 찾기
        int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);

        if(permissionCheck == PackageManager.PERMISSION_DENIED){ //위치 권한 확인
            //위치 권한 요청
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }

        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        Location loc_cur = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

/*
        double cur_lat = loc_cur.getLatitude(); // 위도
        double cur_lon = loc_cur.getLongitude(); // 경도

        Toast.makeText(getApplicationContext(), Double.toString(cur_lat),Toast.LENGTH_SHORT).show();
*/

        // 상태바 제거
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_popup);

        near = (Button) findViewById(R.id.near_Button);
        appconnect = (Button) findViewById(R.id.app_Button);
        cancel = (Button) findViewById(R.id.cancel_Button);

    }


    // 주변보기 버튼 클릭
    public void mNear(View v){
        String PACKAGE_NAME_kakaomap = "net.daum.android.map";
        String PACKAGE_NAME_navermap = "com.nhn.android.nmap";

        PackageManager pm = getPackageManager();
        if (isPackageInstalled(PACKAGE_NAME_kakaomap, pm)) { // 카카오맵 설치되어 있으면
            // URL Scheme 활용 가게 검색
            String url = "kakaomap://search?q=제육볶음&p=35.888836,128.6102997";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
        else if (isPackageInstalled(PACKAGE_NAME_navermap, pm)) { // 네이버지도 설치되어 있으면
            // URL Scheme 활용 가게 검색
            String url = "nmap://search?query=제육볶음&appname=com.example.snackdic";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }
        else { // 둘 다 설치되어 있지 않으면
            // 네이버 지도 웹버전으로 검색
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("https://map.naver.com/v5/search/제육볶음"); // 링크
            intent.setData(uri);
            startActivity(intent);
        }

        finish();
    }

    // 배달앱 연결 버튼 클릭
    public void mAppConnect(View v){
        String PACKAGE_NAME_kakaomap = "com.sampleapp";

        Intent intentword = getIntent();
        String snack_name = intentword.getStringExtra("snack_name");

        // 클립보드 복사
        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label",snack_name);
        clipboard.setPrimaryClip(clip);

        PackageManager pm = getPackageManager();
        if(isPackageInstalled(PACKAGE_NAME_kakaomap, pm)){
            Intent intent = getPackageManager().getLaunchIntentForPackage("com.sampleapp");
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else{
            String url = "market://details?id=" + "com.sampleapp";
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(i);
        }
        finish();
    }

    // 닫기 연결 버튼 클릭
    public void mCancel(View v){
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        // 바깥레이어 클릭시 닫히지 않게
        if(event.getAction() == MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed(){
        // 안드로이드 백버튼 막기
        return;
    }

    // 앱 설치여부 확인
    private boolean isPackageInstalled(String packageName, PackageManager packageManager) {
        try {
            packageManager.getPackageInfo(packageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

}
