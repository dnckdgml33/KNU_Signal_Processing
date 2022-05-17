package com.example.snackdic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MBTIRes extends AppCompatActivity {

    private testActivity mTestActivity = new testActivity();
    Intent intent3;

        private int Rich;
        private int Sensitive;
        private int Challenge;
        private int Much;

        private TextView mRichView;
        private TextView mSensitiveView;
        private TextView mChallengeView;
        private TextView mMuchView;

        private Button details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbtires);

        mRichView = (TextView) findViewById(R.id.score_rich);
        mSensitiveView = (TextView) findViewById(R.id.score_sensitive);
        mChallengeView = (TextView) findViewById(R.id.score_challenge);
        mMuchView = (TextView) findViewById(R.id.score_much);

        details =(Button) findViewById(R.id.details);

        intent3 = getIntent();
        Rich = intent3.getIntExtra("Rich",0);
        Sensitive = intent3.getIntExtra("Sensitive",0);
        Challenge = intent3.getIntExtra("Challenge",0);
        Much = intent3.getIntExtra("Much",0);

        mRichView.setText(""+Rich);
        mSensitiveView.setText(""+Sensitive);
        mChallengeView.setText(""+Challenge);
        mMuchView.setText(""+Much);


        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(getApplicationContext(), MBTIRes2.class);
                intent4.putExtra("Sensitive",Sensitive);
                intent4.putExtra("Rich",Rich);
                intent4.putExtra("Much",Much);
                intent4.putExtra("Challenge",Challenge);
                startActivity(intent4);
            }
        });
    }

}