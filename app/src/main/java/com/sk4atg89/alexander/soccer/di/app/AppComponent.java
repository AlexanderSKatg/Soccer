package com.sk4atg89.alexander.soccer.di.app;


import com.sk4atg89.alexander.soccer.SoccerApp;
import com.sk4atg89.alexander.soccer.di.activity.ActivityBindingsModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Component(modules = {AppModule.class
        , ActivityBindingsModule.class
        , AndroidSupportInjectionModule.class
        , DataModule.class
        , NetworkModule.class
})
@Singleton
interface AppComponent extends AndroidInjector<SoccerApp> {

    @Component.Builder
    abstract class Builder extends dagger.android.AndroidInjector.Builder<SoccerApp> {
        public abstract Builder appModule(AppModule appModule);
    }
}
