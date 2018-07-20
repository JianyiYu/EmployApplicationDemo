package com.demo.jaden.employapplication.network;

import com.demo.jaden.employapplication.login.LoginTask;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.Response;

public class NetworkManager {

    private static NetworkManager instance;

    private NetworkManager(){}

    public static NetworkManager getInstance(){

        synchronized (NetworkManager.class){
            if(null == instance){
                instance = new NetworkManager();
            }

            return instance;
        }
    }

    public void doLogin(String accountId, String passWord){

        if(null == accountId || null == passWord)
        {
            return;
        }

        final LoginTask loginTask = new LoginTask(accountId, passWord);

        new Thread(new Runnable() {
            @Override
            public void run() {
                loginTask.post(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        System.out.println(e);
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {

                        //获取响应结果并解析
                        if (!response.isSuccessful()) {
                            System.out.println(response);
                            return;
                        }

                        Headers responseHeaders = response.headers();
                        for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                            System.out.println(responseHeaders.name(i) + ": "
                                    + responseHeaders.value(i));
                        }

                        System.out.println(response.body().string());
                    }
                });
            }
        }).start();


    }

    public void syncGet(){

    }
}
