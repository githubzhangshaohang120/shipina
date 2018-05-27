package com.example.asus.thelistshows.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.asus.thelistshows.inter.IBase;
import com.example.asus.thelistshows.R;

import javax.inject.Inject;

public abstract class BaseActivity<T extends BaseContract.BasePresenter> extends AppCompatActivity implements IBase,BaseContract.BaseView {

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        //注入
        inject();
            mPresenter.attchView(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解绑
            mPresenter.deletView();
    }

    @Override
    public void initView(View view) {

    }

    public void  showLoading(){

    }

    public void dismissLoading(){

    }
}
