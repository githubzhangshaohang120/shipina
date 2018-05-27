package com.example.asus.thelistshows.base;

public class BasePresenter<T extends BaseContract.BaseView> implements BaseContract.BasePresenter<T> {

    protected T mView;

    @Override
    public void attchView(T view) {
        this.mView=view;
    }

    @Override
    public void deletView() {
        if (mView!=null){
            mView=null;
        }
    }
}
