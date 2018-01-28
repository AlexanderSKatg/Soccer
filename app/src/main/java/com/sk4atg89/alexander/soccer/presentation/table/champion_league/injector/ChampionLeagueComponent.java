package com.sk4atg89.alexander.soccer.presentation.table.champion_league.injector;

import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableRouter;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTableFragment;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueContract;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueFragment;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = ChampionLeagueComponent.ChampionLeagueModule.class)
public interface ChampionLeagueComponent extends AndroidInjector<ChampionLeagueFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<ChampionLeagueFragment> {
        @Override
        public void seedInstance(ChampionLeagueFragment instance) {
            LeagueTableEntity entity = instance.getArguments().getParcelable(BaseTableFragment.LEAGUE_ENTITY_ENTITY);
            leagueTableEntity(entity);
        }

        @BindsInstance
        public abstract Builder leagueTableEntity(LeagueTableEntity entity);
    }

    @Module
    class ChampionLeagueModule {

        @Provides
        ChampionLeagueContract.EventDelegate provideRouter(LeagueTableRouter router) {
            return router;
        }

    }
}