package com.sk4atg89.alexander.soccer;

import android.app.Activity;
import android.support.multidex.MultiDexApplication;

import com.sk4atg89.alexander.soccer.di.common.AppInjector;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class SoccerApp extends MultiDexApplication implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> mAndroidInjector;

    public void onCreate() {
        super.onCreate();
        AppInjector.init(this);

    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mAndroidInjector;
    }
}
