package com.example.t;

import android.util.Log;

/**
 * Created by junxuwang on 16-9-4.
 */
public final class LogUtils {
    private static final String TAG="abc_l";
    public static void d(String tag,String msg){
        Log.d(tag,msg);
    }
    public static void d(String msg){
        d(TAG,msg);
    }
}
