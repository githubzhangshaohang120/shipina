package com.example.asus.thelistshows;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.asus.thelistshows.base.BaseActivity;
import com.example.asus.thelistshows.bean.UserBean;
import com.example.asus.thelistshows.component.DaggerHttpComponent;
import com.example.asus.thelistshows.model.HttpModel;
import com.example.asus.thelistshows.pice.PiceActivity;
import com.example.asus.thelistshows.pice.adapter.MyAdapter;
import com.example.asus.thelistshows.pice.contract.PiceContract;
import com.example.asus.thelistshows.pice.presenter.PicePresenter;

import java.util.List;

public class MainActivity extends BaseActivity<PicePresenter> implements PiceContract.View {

    /**
     * 跳转
     */
    private Button mBtn;
    private RecyclerView mMRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.getAd();
        //找到控件
        mBtn =  findViewById(R.id.btn);
        mMRv =  findViewById(R.id.mRv);
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this);
        mMRv.setLayoutManager(linearLayoutManager);
        mBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PiceActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .httpModel(new HttpModel())
                .build()
                .inject(this);
    }

    @Override
    public void initView(View view) {




    }

    @Override
    public void PiceSuccess(UserBean userBean) {
        List<UserBean.DataBean> list=userBean.getData();
        MyAdapter adapter=new MyAdapter(this,list);
        mMRv.setAdapter(adapter);
    }


}
