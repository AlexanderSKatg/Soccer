package com.sk4atg89.alexander.soccer.presentation.team.team.injector;

import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.presentation.team.TeamRouter;
import com.sk4atg89.alexander.soccer.presentation.team.team.TeamContract;
import com.sk4atg89.alexander.soccer.presentation.team.team.TeamFragment;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = TeamFragmentComponent.TeamFragmentModule.class)
public interface TeamFragmentComponent extends AndroidInjector<TeamFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TeamFragment> {

        @Override
        public void seedInstance(TeamFragment instance) {
            int entity = instance.getArguments().getInt("TEAM_ID_KEY", -1);
            teamId(entity);
        }

        @BindsInstance
        public abstract void teamId(int id);

    }


    @Module
    class TeamFragmentModule {

        @Provides
        TeamContract.EventDelegate provideRouter(TeamRouter router) {
            return router;
        }

    }
}