package com.demo.jaden.employapplication.login;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.activity.BaseActivity;
import com.demo.jaden.employapplication.activity.MainActivity;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class PhoneLoginActivity extends BaseActivity {

    private EditText phoneNumberView;

    private EditText securityCodeView;

    private Button sendSecurityBtn;

    private Button phoneLoginBtn;

    private TextView errorTipsView;

    private String phoneNumber;

    private String securityCode;

    private String errorTips;

    private Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            return false;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_phone_login);

        initView();
    }

    private void initView(){

        phoneNumberView = findViewById(R.id.phone_number_edit);
        securityCodeView = findViewById(R.id.security_code_edit);
        sendSecurityBtn = findViewById(R.id.send_security_code_btn);
        phoneLoginBtn = findViewById(R.id.phone_login_btn);
        errorTipsView = findViewById(R.id.error_tips_text);

        sendSecurityBtn.setOnClickListener(this);
        phoneLoginBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        super.onClick(view);

        if(view == sendSecurityBtn){

            phoneNumber = phoneNumberView.getText().toString();
            sendSecurityCode(phoneNumber, handler);
        }
        else if(view == phoneLoginBtn){

            securityCode = securityCodeView.getText().toString();
            phoneNumberLogin(securityCode, handler);
        }
    }

    private void sendSecurityCode(String nmb, Handler handler){

    }

    private void phoneNumberLogin(String code, Handler handler){

//        Intent intent = new Intent(this, MainActivity.class);
//        startActivity(intent);

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("https://www.baidu.com").get().build();
        final Call call = client.newCall(request);

        //异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.d("aqua", "async call fail");
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.d("aqua", "async call success");
                Intent intent = new Intent(PhoneLoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
