package com.demo.jaden.employapplication.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SPreferenceUtil {

    private static final String TAG = "SPreferenceUtil";

    private SharedPreferences sPrefers;

    private SharedPreferences.Editor editor;

    public SPreferenceUtil(Context context){
        sPrefers = context.getSharedPreferences(TAG, Context.MODE_PRIVATE);
        editor = sPrefers.edit();
    }

    public SPreferenceUtil(Context context, String spName){
        sPrefers = context.getSharedPreferences(spName, Context.MODE_PRIVATE);
        editor = sPrefers.edit();
    }

    public void put(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }

    public void put(String key, int value){
        editor.putInt(key, value);
        editor.commit();
    }

    public void put(String key, boolean value){
        editor.putBoolean(key, value);
        editor.commit();
    }

    public String getString(String key){
        return sPrefers.getString(key, null);
    }

    public String getString(String key, String defaultValue){
        return sPrefers.getString(key, defaultValue);
    }

    public int getInt(String key, int defaultValue){
        return sPrefers.getInt(key, defaultValue);
    }

    public boolean getBoolean(String key, boolean defaultValue){
        return sPrefers.getBoolean(key, defaultValue);
    }

    public void remove(String key){
        editor.remove(key).commit();
    }
}
