package com.sk4atg89.alexander.soccer.presentation.table.table.injector;

import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableRouter;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableContract;

import dagger.Module;
import dagger.Provides;

@Module
public class LeagueTableFragmentModule {

    @Provides
    LeagueTableContract.EventDelegate provideRouter(LeagueTableRouter router) {
        return router;
    }

}