package com.sk4atg89.alexander.soccer.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.presentation.season.SeasonActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        startActivity(new Intent(this, SeasonActivity.class));
        finish();
    }
}
