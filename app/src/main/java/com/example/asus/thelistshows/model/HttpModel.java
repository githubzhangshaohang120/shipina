package com.example.asus.thelistshows.model;

import com.example.asus.thelistshows.net.Api;
import com.example.asus.thelistshows.net.PiceApi;
import com.example.asus.thelistshows.net.PiceApiService;
import com.example.asus.thelistshows.utils.MyInterceptor;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class HttpModel {

    @Provides
    OkHttpClient.Builder providesOkHttpClientBuilder(){
//        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(20,TimeUnit.SECONDS)
                .readTimeout(20,TimeUnit.SECONDS);
                //.addInterceptor(new MyInterceptor());
    }

    @Provides
    PiceApi providesPiceApi(OkHttpClient.Builder builder){
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://www.apiopen.top/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(builder.build())
                .build();
        PiceApiService piceApiService=retrofit.create(PiceApiService.class);
        return PiceApi.getPiceApi(piceApiService);
    }



}
