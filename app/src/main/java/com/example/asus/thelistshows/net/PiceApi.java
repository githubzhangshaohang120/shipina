package com.example.asus.thelistshows.net;

import com.example.asus.thelistshows.bean.UserBean;

import io.reactivex.Observable;

/**
 * 单利模式
 */
public class PiceApi {
    private static PiceApi piceApi;
    private PiceApiService piceApiService;
    public PiceApi(PiceApiService piceApiService){
        this.piceApiService=piceApiService;
    }

    public static PiceApi getPiceApi(PiceApiService piceApiService) {
        //判断piceApi是否等于空，如果等于空就创建一个piceApiService
        if (piceApi==null){
            piceApi=new PiceApi(piceApiService);
        }
        return piceApi;
    }

    public Observable<UserBean> getAd(){
        return piceApiService.getAd();
    }
}
