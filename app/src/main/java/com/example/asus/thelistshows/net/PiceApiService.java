package com.example.asus.thelistshows.net;

import com.example.asus.thelistshows.bean.UserBean;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface PiceApiService {
    @GET("satinApi?type=1&page=1")
    Observable<UserBean> getAd();
}
