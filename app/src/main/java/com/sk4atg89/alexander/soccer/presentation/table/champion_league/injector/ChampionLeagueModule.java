package com.sk4atg89.alexander.soccer.presentation.table.champion_league.injector;

import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableRouter;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueContract;

import dagger.Module;
import dagger.Provides;

@Module
public class ChampionLeagueModule {

    @Provides
    ChampionLeagueContract.EventDelegate provideRouter(LeagueTableRouter router) {
        return router;
    }

}