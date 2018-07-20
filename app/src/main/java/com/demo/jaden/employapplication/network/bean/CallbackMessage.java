package com.demo.jaden.employapplication.network.bean;

import com.demo.jaden.employapplication.network.HttpInfo;
import com.demo.jaden.employapplication.network.callback.BaseCallback;

import okhttp3.Call;

/**
 * 响应回调信息体
 * @author zhousf
 */
public class CallbackMessage extends OkMessage{

    public BaseCallback callback;
    public HttpInfo info;
    public Call call;


    public CallbackMessage(int what, BaseCallback callback, HttpInfo info,
                           String requestTag, Call call) {
        this.what = what;
        this.callback = callback;
        this.info = info;
        super.requestTag = requestTag;
        this.call = call;
    }


}