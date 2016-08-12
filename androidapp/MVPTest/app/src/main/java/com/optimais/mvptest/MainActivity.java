package com.optimais.mvptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainView{

    MainPresenter presenter;
    TextView mShowText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowText=(TextView)findViewById(R.id.text1);
        loadDatas();
    }
    public void loadDatas(){
        presenter=new MainPresenter();
        presenter.addTaskListener(this);
        presenter.getString();

    }

    @Override
    public void onShowString(String str) {
        mShowText.setText(str);
    }
}
