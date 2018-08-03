package com.demo.jaden.employapplication.model;

public class MessageContent {

    private String msg;
    private String userId;
    private int type;

    public static final int MESSAGE_TYPE_RECEIVED = 0;
    public static final int MESSAGE_TYPE_SEND = 1;

    public MessageContent(String msg, int type){
        this.msg = msg;
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
