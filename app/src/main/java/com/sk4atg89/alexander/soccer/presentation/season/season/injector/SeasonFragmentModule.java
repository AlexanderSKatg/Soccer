package com.sk4atg89.alexander.soccer.presentation.season.season.injector;

import com.sk4atg89.alexander.soccer.presentation.season.SeasonRouter;
import com.sk4atg89.alexander.soccer.presentation.season.season.SeasonContract;

import dagger.Module;
import dagger.Provides;

@Module
public class SeasonFragmentModule {

    @Provides
    SeasonContract.EventDelegate provideRouter(SeasonRouter router) {
        return router;
    }

}
