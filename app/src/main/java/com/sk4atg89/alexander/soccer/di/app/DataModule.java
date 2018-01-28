package com.sk4atg89.alexander.soccer.di.app;

import com.sk4atg89.alexander.soccer.data.players.PlayersRepositoryImpl;
import com.sk4atg89.alexander.soccer.data.season.SeasonRepositoryImpl;
import com.sk4atg89.alexander.soccer.data.table.TableLeagueRepository;
import com.sk4atg89.alexander.soccer.data.team.TeamRepositoryImpl;
import com.sk4atg89.alexander.soccer.domain.players.PlayersRepository;
import com.sk4atg89.alexander.soccer.domain.season.SeasonRepository;
import com.sk4atg89.alexander.soccer.domain.table.TableRepository;
import com.sk4atg89.alexander.soccer.domain.team.TeamRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class DataModule {

    @Singleton
    @Provides
    SeasonRepository provideSeasonRepository(SeasonRepositoryImpl repository) {
        return repository;
    }

    @Singleton
    @Provides
    TableRepository provideTableLeagueRepository(TableLeagueRepository repository) {
        return repository;
    }

    @Singleton
    @Provides
    TeamRepository provideTeamRepository(TeamRepositoryImpl repository) {
        return repository;
    }

    @Singleton
    @Provides
    PlayersRepository providePlayersRepository(PlayersRepositoryImpl repository) {
        return repository;
    }

}
