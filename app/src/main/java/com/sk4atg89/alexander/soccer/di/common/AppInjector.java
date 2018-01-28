package com.sk4atg89.alexander.soccer.di.common;


import com.sk4atg89.alexander.soccer.SoccerApp;
import com.sk4atg89.alexander.soccer.di.app.AppModule;
import com.sk4atg89.alexander.soccer.di.app.DaggerAppComponent;

public class AppInjector {
    public static void init(SoccerApp soccerApp) {
        DaggerAppComponent.builder()
                .appModule(new AppModule(soccerApp))
                .create(soccerApp)
                .inject(soccerApp);
    }
}
