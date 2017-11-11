package com.bwie.test.liuhaifeng201711111;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

/**
 * 刘海峰.10:06
 */

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
