package com.demo.jaden.employapplication.network;

import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class AsyncTask implements AsyncTaskInterface{

    private static ScheduledExecutorService executorService;

    private OkHttpClient httpClient;

    public AsyncTask(){
        if(null == executorService){
            executorService = new ScheduledThreadPoolExecutor(20);
        }

        httpClient = new OkHttpClient();
    }

    @Override
    public Request.Builder createHead() {
         Request.Builder builder = new Request.Builder().addHeader("numb", "12345678901");
        return builder;
    }

    public void get(){

        final Request request = createHead().build();

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                try {
                    Response respose = httpClient.newCall(request).execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }, 0, TimeUnit.SECONDS);

    }

    public void post(Callback callback){

        RequestBody body = createBody();
        Request request = createHead().method("POST", body).build();

        Call call = httpClient.newCall(request);
        call.enqueue(callback);
    }
}
