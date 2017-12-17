package com.dheeraj.weatherapp;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    private static int TIME_OUT = 3000;
    private static boolean splashLoaded = false;
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!splashLoaded) {
            setContentView(R.layout.activity_splash);
            mHandler.postDelayed(() -> {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }, TIME_OUT);
            splashLoaded = true;
        } else {
            Intent intent = new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
