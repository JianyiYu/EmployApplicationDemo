package com.demo.jaden.employapplication.utils;

import android.util.Log;

import com.demo.jaden.employapplication.constants.Constants;

public class LogUtil {

    private static final String TAG = Constants.LOG_TAG;


    private final static boolean all = true;
    /**
     * info Log print on-off
     */
    private final static boolean i = true;
    /**
     * debug Log print on-off
     */
    private final static boolean d = true;
    /**
     * err Log print on-off
     */
    private final static boolean e = true;
    /**
     * verbose Log print on-off
     */
    private final static boolean v = true;
    /**
     * warn Log print on-off
     */
    private final static boolean w = true;

    private LogUtil() {
    }


    /**
     * info Log print
     *
     * @param TAG :print TAG
     * @param msg :print message
     */
    public static void i(String TAG, String msg) {
        if (all && i) {
            Log.i(TAG, msg);
        }
    }

    /**
     * debug Log print,default print TAG
     *
     * @param msg :print message
     */
    public static void d(String msg) {
        if (all && d) {
            Log.d(TAG, msg);
        }
    }

    /**
     * debug Log print
     *
     * @param TAG :print TAG
     * @param msg :print message
     */
    public static void d(String TAG, String msg) {
        if (all && d) {
            Log.d(TAG, msg);
        }
    }

    /**
     * err Log print,default print TAG
     *
     * @param msg :print message
     */
    public static void e(String msg) {
        if (all && e) {
            try {
                Log.e(TAG, msg);
            } catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    /**
     * err Log print
     *
     * @param TAG :print TAG
     * @param msg :print message
     */
    public static void e(String TAG, String msg) {
        if (all && e) {
            Log.e(TAG, msg);
        }
    }

    /**
     * verbose Log print,default print TAG
     *
     * @param msg :print message
     */
    public static void v(String msg) {
        if (all && v) {
            Log.v(TAG, msg);
        }
    }

    /**
     * verbose Log print
     *
     * @param TAG :print TAG
     * @param msg :print message
     */
    public static void v(String TAG, String msg) {
        if (all && v) {
            Log.v(TAG, msg);
        }
    }

    /**
     * warn Log print,default print TAG
     *
     * @param msg :print message
     */
    public static void w(String msg) {
        if (all && w) {
            Log.w(TAG, msg);
        }
    }

    /**
     * warn Log print
     *
     * @param TAG :print TAG
     * @param msg :print message
     */
    public static void w(String TAG, String msg) {
        if (all && w) {
            Log.w(TAG, msg);
        }
    }
}
