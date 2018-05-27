package com.example.asus.thelistshows.pice.contract;

import com.example.asus.thelistshows.base.BaseContract;
import com.example.asus.thelistshows.bean.UserBean;

public interface PiceContract {

    interface View extends BaseContract.BaseView{
        void PiceSuccess(UserBean userBean);
    }
    interface Presenter extends BaseContract.BasePresenter<View>{
        void getAd();
    }
}
