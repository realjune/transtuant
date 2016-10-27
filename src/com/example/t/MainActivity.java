package com.example.t;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){public void run(){
            String url=APIConfig.generateRequestIndexParam("0");
            LogUtils.d("quest ..."+url);
            APIConfig.loadIndex(MainActivity.this);
            APIConfig.loadBycate(MainActivity.this);
        LogUtils.d("back with volley ");
        }}.start();
    }
}
