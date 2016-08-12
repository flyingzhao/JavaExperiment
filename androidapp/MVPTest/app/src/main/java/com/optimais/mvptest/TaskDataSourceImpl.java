package com.optimais.mvptest;

/**
 * Created by tzhao on 2016/7/29.
 */
public class TaskDataSourceImpl implements TaskDataSource {
    @Override
    public String getStringFromRemote() {
        return "hello";
    }

    @Override
    public String getStringFromCache() {
        return "world ";
    }
}
