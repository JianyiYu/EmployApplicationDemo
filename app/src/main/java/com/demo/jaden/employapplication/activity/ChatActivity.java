package com.demo.jaden.employapplication.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.demo.jaden.employapplication.R;
import com.demo.jaden.employapplication.adapter.ChatMessageAdapter;
import com.demo.jaden.employapplication.model.MessageContent;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends BaseActivity {

    private RecyclerView msgRecyclerView;

    private List<MessageContent> msgList = new ArrayList<>();
    private ChatMessageAdapter msgListAdapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        initData();
        initView();
    }

    private void initView(){
        msgRecyclerView = (RecyclerView) findViewById(R.id.chat_message_list);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        msgRecyclerView.setLayoutManager(linearLayoutManager);
        msgRecyclerView.setAdapter(msgListAdapter);
    }

    private void initData(){
        for(int i=0; i < 30 ; i++){
            MessageContent msg = new MessageContent("hello " + i + " time", i%2);
            msgList.add(msg);
        }
        msgListAdapter = new ChatMessageAdapter(msgList);
    }
}
