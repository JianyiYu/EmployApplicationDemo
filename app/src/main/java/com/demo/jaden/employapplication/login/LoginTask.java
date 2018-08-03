package com.demo.jaden.employapplication.login;

import com.demo.jaden.employapplication.network.AsyncTask;
import com.google.gson.JsonObject;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LoginTask extends AsyncTask {

    private static final String url = "https://baidu.com";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private String accountId;

    private String passWord;

    public LoginTask(String accountId, String passWord){

        this.accountId = accountId;
        this.passWord = passWord;
    }


    @Override
    public Request createPostRequest() {

        RequestBody body = createBody();
        Request request = new Request.Builder().url(url).post(body).build();

        return request;
    }

    @Override
    public RequestBody createBody(){

        // 根据需求创建`Request`对象.
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("accountId", this.accountId);
        jsonObject.addProperty("password", this.passWord);


        return RequestBody.create(JSON, jsonObject.toString());
    }
}
