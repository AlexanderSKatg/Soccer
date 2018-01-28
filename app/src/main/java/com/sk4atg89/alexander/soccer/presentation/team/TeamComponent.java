package com.sk4atg89.alexander.soccer.presentation.team;

import android.support.v4.app.Fragment;

import com.sk4atg89.alexander.soccer.di.activity.ActivityScope;
import com.sk4atg89.alexander.soccer.presentation.team.players.PlayersFragment;
import com.sk4atg89.alexander.soccer.presentation.team.players.injector.PlayersComponent;
import com.sk4atg89.alexander.soccer.presentation.team.team.TeamFragment;
import com.sk4atg89.alexander.soccer.presentation.team.team.injector.TeamFragmentComponent;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

@ActivityScope
@Subcomponent(modules = {TeamComponent.FragmentBindingsModule.class})
public interface TeamComponent extends AndroidInjector<TeamActivity> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<TeamActivity> {

//        @Override
//        public void seedInstance(TeamActivity instance) {
//            int entity = instance.getIntent().getIntExtra("TEAM_ID", -1);
//            teamId(entity);
//        }
//
//        @BindsInstance
//        public abstract void teamId(@Named("TeamID") int id);

    }

    @Module(subcomponents = {TeamFragmentComponent.class, PlayersComponent.class})
    interface FragmentBindingsModule {

        @Binds
        @FragmentKey(PlayersFragment.class)
        @IntoMap
        AndroidInjector.Factory<? extends Fragment> providePlayersComponentBuilder(PlayersComponent.Builder builder);

        @Binds
        @FragmentKey(TeamFragment.class)
        @IntoMap
        AndroidInjector.Factory<? extends Fragment> provideTeamFragmentComponentBuilder(TeamFragmentComponent.Builder builder);


    }
}
