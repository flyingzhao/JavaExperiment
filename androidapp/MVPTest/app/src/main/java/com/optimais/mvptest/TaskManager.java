package com.optimais.mvptest;

/**
 * Created by tzhao on 2016/7/29.
 */
public class TaskManager {
    TaskDataSource dataSource;
    public TaskManager(TaskDataSource dataSource){
        this.dataSource=dataSource;
    }
    public String getShowContent(){
        return dataSource.getStringFromRemote()+dataSource.getStringFromCache();
    }
}
