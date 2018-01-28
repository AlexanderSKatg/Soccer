package com.sk4atg89.alexander.soccer.presentation.team.players.injector;

import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.presentation.team.TeamRouter;
import com.sk4atg89.alexander.soccer.presentation.team.players.PlayersContract;
import com.sk4atg89.alexander.soccer.presentation.team.players.PlayersFragment;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = PlayersComponent.PlayersModule.class)
public interface PlayersComponent extends AndroidInjector<PlayersFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<PlayersFragment> {

        @Override
        public void seedInstance(PlayersFragment instance) {
            int entity = instance.getArguments().getInt("PLAYERS_ID_KEY", -1);
            teamId(entity);
        }

        @BindsInstance
        public abstract void teamId(int id);

    }


    @Module
    class  PlayersModule {

        @Provides
        PlayersContract.EventDelegate provideRouter(TeamRouter router) {
            return router;
        }

    }
}