package com.optimais.ottotest;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * Created by optima1 on 2016/7/18.
 */
public class OttoClass {
    private static Bus bus;
    public static Bus getInstance(){
        if (bus==null){
            bus=new Bus(ThreadEnforcer.ANY);
        }
        return bus;
    }
}
