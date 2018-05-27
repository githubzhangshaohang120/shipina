package com.example.asus.thelistshows.base;

public interface BaseContract {
    //拿到所有Presenter中的特性，比如绑定与解绑
    interface BasePresenter<T extends BaseView>{
        //显示进度条
        void attchView(T view);
        //关闭进度条
        void deletView();
    }
    //拿到View层的特性，比如显示进度条与关闭进度条
    interface BaseView{
        //显示进度条
        void showLoading();
        //关闭进度条
        void dismissLoading();
    }
}
