package com.demo.jaden.employapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.network.NetworkManager;

public class LoginActivity extends BaseActivity {

    EditText editAccountId;

    EditText editPassWord;

    Button btnLogin;

    Button btnRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        initData();
    }

    private void initView(){
        setContentView(R.layout.activity_login);

        editAccountId = findViewById(R.id.account_edit);

        editPassWord = findViewById(R.id.pwd_edit);

        btnLogin = findViewById(R.id.btn_login);

        btnRegister = findViewById(R.id.btn_register);

    }

    private void initData(){

    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            doLogin();
        }
        else if(view == btnRegister){

        }
    }

    private void doLogin() {

        NetworkManager.getInstance().doLogin(editAccountId.getText().toString(), editPassWord.getText().toString());
    }
}
