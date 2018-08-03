package com.demo.jaden.employapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.demo.jaden.employapplication.R;

public class JobDetailActivity extends BaseActivity {

    private Button btnStartCommunicate;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        initView();
    }

    private void initView(){

        btnStartCommunicate = (Button) findViewById(R.id.btn_start_communicate);

        btnStartCommunicate.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == btnStartCommunicate){
            Intent intent = new Intent(this, ChatActivity.class);
            startActivity(intent);
        }
        super.onClick(view);
    }
}
