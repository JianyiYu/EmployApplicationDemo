package com.demo.jaden.employapplication.activity;

import android.content.Intent;
import android.os.Bundle;

import com.demo.jaden.employapplication.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        if(!isLogin()) {

        }
        toLogin();

        finish();
    }

    private boolean isLogin() {
        return true;
    }

    private void toLogin() {
        Intent intent = new Intent(this, PhoneLoginActivity.class);
        startActivity(intent);
    }
}
