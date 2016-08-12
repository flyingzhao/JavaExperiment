package com.optimais.ottotest;

import android.os.Handler;
import android.os.Looper;

import com.squareup.otto.Bus;


/**
 * Created by tzhao on 2016/7/22.
 */
public class BusProvider {
    private static final Bus bus=new MainThreadBus();
    public static Bus getInstance(){
        return bus;
    }
    public static class MainThreadBus extends Bus{
        private final Handler handler=new Handler(Looper.getMainLooper());
        @Override
        public void post(final Object event){
            if (Looper.myLooper()==Looper.getMainLooper()){
                super.post(event);
            }else{
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        MainThreadBus.super.post(event);
                    }
                });
            }
        }
    }

}
