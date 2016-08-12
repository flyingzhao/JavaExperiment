package com.optimais.mvptest;

/**
 * Created by tzhao on 2016/7/29.
 */
public interface TaskDataSource {
    String getStringFromRemote();
    String getStringFromCache();
}
