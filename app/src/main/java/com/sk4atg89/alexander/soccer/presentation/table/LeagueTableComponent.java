package com.sk4atg89.alexander.soccer.presentation.table;

import com.sk4atg89.alexander.soccer.di.activity.ActivityScope;
import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueFragment;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.injector.ChampionLeagueModule;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableFragment;
import com.sk4atg89.alexander.soccer.presentation.table.table.injector.LeagueTableFragmentModule;

import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;

@ActivityScope
@Subcomponent(modules = {LeagueTableComponent.FragmentBindingsModule.class})
public interface LeagueTableComponent extends AndroidInjector<LeagueTableActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LeagueTableActivity> {

//        @Override
//        public void seedInstance(LeagueTableActivity instance) {
//            leagueId(instance.getIntent().getIntExtra("LEAGUE_ID", -1));
//        }
//
//        @BindsInstance
//        public abstract LeagueTableFragmentComponent.Builder leagueId(Integer id);

    }

    @Module
    interface FragmentBindingsModule {

        @FragmentScope
        @ContributesAndroidInjector(modules = {ChampionLeagueModule.class})
        ChampionLeagueFragment contributeChampionLeagueFragment();

        @FragmentScope
        @ContributesAndroidInjector(modules = {LeagueTableFragmentModule.class})
        LeagueTableFragment contributeLeagueTableFragment();

//
//        @Binds
//        @FragmentKey(ChampionLeagueFragment.class)
//        @IntoMap
//        AndroidInjector.Factory<? extends Fragment> provideChampionLeagueComponentBuilder(ChampionLeagueComponent.Builder builder);
//
//        @Binds
//        @FragmentKey(LeagueTableFragment.class)
//        @IntoMap
//        AndroidInjector.Factory<? extends Fragment> provideLeagueTableFragmentComponentBuilder(LeagueTableFragmentComponent.Builder builder);
//

    }
}