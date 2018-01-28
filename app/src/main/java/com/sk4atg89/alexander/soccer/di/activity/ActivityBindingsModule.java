package com.sk4atg89.alexander.soccer.di.activity;

import android.app.Activity;

import com.sk4atg89.alexander.soccer.presentation.season.SeasonActivity;
import com.sk4atg89.alexander.soccer.presentation.season.SeasonComponent;
import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableActivity;
import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableComponent;
import com.sk4atg89.alexander.soccer.presentation.team.TeamActivity;
import com.sk4atg89.alexander.soccer.presentation.team.TeamComponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector.Factory;
import dagger.multibindings.IntoMap;

@Module(subcomponents = {SeasonComponent.class, LeagueTableComponent.class, TeamComponent.class})
public abstract class ActivityBindingsModule {

    @Binds
    @IntoMap
    @ActivityKey(SeasonActivity.class)
    public abstract Factory<? extends Activity> seasonActivityComponentBuilder(SeasonComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(LeagueTableActivity.class)
    public abstract Factory<? extends Activity> leagueTableActivityComponentBuilder(LeagueTableComponent.Builder builder);

    @Binds
    @IntoMap
    @ActivityKey(TeamActivity.class)
    public abstract Factory<? extends Activity> teamActivityComponentBuilder(TeamComponent.Builder builder);

}