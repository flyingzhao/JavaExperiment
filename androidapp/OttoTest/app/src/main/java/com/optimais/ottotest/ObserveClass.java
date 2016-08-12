package com.optimais.ottotest;

import android.util.Log;

import com.squareup.otto.Subscribe;

/**
 * Created by tzhao on 2016/7/28.
 */
public class ObserveClass {
    public ObserveClass(){
        OttoClass.getInstance().register(this);
    }

    @Subscribe
    public void onObserve(String s){
        Log.d("thread observe",Thread.currentThread().getName());
        Log.d("observe","123");
    }

}
