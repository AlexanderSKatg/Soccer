package com.sk4atg89.alexander.soccer.presentation.season.detail.injector;

import com.sk4atg89.alexander.soccer.presentation.season.SeasonRouter;
import com.sk4atg89.alexander.soccer.presentation.season.detail.SeasonDetailContract;

import dagger.Module;
import dagger.Provides;

@Module
public class SeasonDetailModule {

    @Provides
    SeasonDetailContract.EventDelegate provideRouter(SeasonRouter router) {
        return router;
    }

}
