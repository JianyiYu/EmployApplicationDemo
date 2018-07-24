package com.demo.jaden.employapplication;

import android.app.Application;

import com.demo.jaden.employapplication.objectbox.entity.MyObjectBox;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

public class EmployApplication extends Application {

    private BoxStore boxStore;

    @Override
    public void onCreate() {
        super.onCreate();
        initBoxStore();
    }

    private void initBoxStore(){

        boxStore = MyObjectBox.builder().androidContext(EmployApplication.this).build();
        if (BuildConfig.DEBUG) {
            new AndroidObjectBrowser(boxStore).start(this);
        }
    }

    public BoxStore getBoxStore() {
        return boxStore;
    }
}
