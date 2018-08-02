package com.demo.jaden.employapplication.utils;

public class StringUtil {

    public StringUtil(){}

    public static boolean isEmpty(String str){
        if (null == str || str.isEmpty()){
            return true;
        }
        return false;
    }
}
