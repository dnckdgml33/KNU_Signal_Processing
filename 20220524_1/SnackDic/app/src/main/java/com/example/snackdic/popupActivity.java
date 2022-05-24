package com.example.snackdic;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class popupActivity extends AppCompatActivity {

    Button near, appconnect, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
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
        finish();
    }

    // 배달앱 연결 버튼 클릭
    public void mAppConnect(View v){
        Intent intentword = getIntent();
        String snack_name = intentword.getStringExtra("snack_name");

        ClipboardManager clipboard = (ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("label",snack_name);
        clipboard.setPrimaryClip(clip);

        if(getPackageList()){
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


    public boolean getPackageList() {
        boolean isExist = false;

        PackageManager pkgMgr = getPackageManager();
        List<ResolveInfo> mApps;
        Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
        mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        mApps = pkgMgr.queryIntentActivities(mainIntent, 0);

        try {
            for (int i = 0; i < mApps.size(); i++) {
                if(mApps.get(i).activityInfo.packageName.startsWith("com.sampleapp")){
                    isExist = true;
                    break;
                }
            }
        }
        catch (Exception e) {
            isExist = false;
        }
        return isExist;
    }
}
