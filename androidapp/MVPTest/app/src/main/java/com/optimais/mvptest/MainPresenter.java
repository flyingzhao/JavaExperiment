package com.optimais.mvptest;

/**
 * Created by tzhao on 2016/7/29.
 */

public class MainPresenter {
    MainView mainView;
    TaskManager taskData;
    public MainPresenter(){
        this.taskData=new TaskManager(new TaskDataSourceImpl());
    }
    public MainPresenter test(){
        this.taskData=new TaskManager(new TaskDataSourceTestImpl());
        return this;
    }
    public MainPresenter addTaskListener(MainView viewListener){
        this.mainView=viewListener;
        return this;
    }
    public void getString(){
        String str=taskData.getShowContent();
        mainView.onShowString(str);
    }

}
