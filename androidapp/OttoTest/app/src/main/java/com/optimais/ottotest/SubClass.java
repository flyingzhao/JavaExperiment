package com.optimais.ottotest;

import android.util.Log;

import com.squareup.otto.Bus;
import com.squareup.otto.Produce;

/**
 * Created by optima1 on 2016/7/18.
 */
public class SubClass {
    SubClass(){    }

    public void startPost(){

            Log.d("Thread POst",Thread.currentThread().getName());
            OttoClass.getInstance().post("This is from subclass");
            Log.d("SubClass","123");

    }
}
