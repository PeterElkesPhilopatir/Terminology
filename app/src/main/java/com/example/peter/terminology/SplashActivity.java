package com.example.peter.terminology;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final TextView present = (TextView) findViewById(R.id.presenting);
        present.setVisibility(View.INVISIBLE);
        final ImageView group = (ImageView) findViewById(R.id.groupImage);

        Handler h1 = new Handler();
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                present.setVisibility(View.VISIBLE);
                present.setText("PRESENTS");
                group.setVisibility(View.INVISIBLE);
                Log.d("awel", "awelThread");
            }
        };

        h1.postDelayed(r1,1000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                final Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(mainIntent);
                SplashActivity.this.finish();
            }
        }, 2000);
    }
}
