package com.example.asus.thelistshows.pice.presenter;

import android.util.Log;
import android.view.View;

import com.example.asus.thelistshows.base.BaseContract;
import com.example.asus.thelistshows.base.BasePresenter;
import com.example.asus.thelistshows.bean.UserBean;
import com.example.asus.thelistshows.net.Api;
import com.example.asus.thelistshows.net.PiceApi;
import com.example.asus.thelistshows.pice.contract.PiceContract;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PicePresenter extends BasePresenter<PiceContract.View> implements PiceContract.Presenter{

    private PiceApi piceApi;

    @Inject
    public PicePresenter(PiceApi piceApi){
        this.piceApi=piceApi;
    }


    @Override
    public void getAd() {
        piceApi.getAd()
        .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(UserBean userBean) {
                            mView.PiceSuccess(userBean);
                        Log.i("+++++++++++++8",userBean.getData().toString());
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }



}
