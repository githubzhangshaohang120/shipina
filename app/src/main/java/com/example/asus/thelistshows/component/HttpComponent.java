package com.example.asus.thelistshows.component;

import com.example.asus.thelistshows.MainActivity;
import com.example.asus.thelistshows.model.HttpModel;
import com.example.asus.thelistshows.pice.PiceActivity;

import dagger.Component;

@Component(modules = HttpModel.class)
public interface HttpComponent {
    void inject(MainActivity mainActivity);
}
