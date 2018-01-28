package com.sk4atg89.alexander.soccer.presentation.season;

import com.sk4atg89.alexander.soccer.di.activity.ActivityScope;
import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.presentation.season.detail.SeasonDetailFragment;
import com.sk4atg89.alexander.soccer.presentation.season.detail.injector.SeasonDetailModule;
import com.sk4atg89.alexander.soccer.presentation.season.season.SeasonFragment;
import com.sk4atg89.alexander.soccer.presentation.season.season.injector.SeasonFragmentModule;

import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;

@ActivityScope
@Subcomponent(modules = {SeasonComponent.FragmentBindingsModule.class})
public interface SeasonComponent extends AndroidInjector<SeasonActivity> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SeasonActivity> {
    }

    @Module
    interface FragmentBindingsModule {
        @FragmentScope
        @ContributesAndroidInjector(modules = {SeasonDetailModule.class})
        SeasonDetailFragment contributeSeasonDetailFragment();

        @FragmentScope
        @ContributesAndroidInjector(modules = {SeasonFragmentModule.class})
        SeasonFragment contributeSeasonFragment();

//        @Binds
//        @FragmentKey(SeasonDetailFragment.class)
//        @IntoMap
//        public abstract AndroidInjector.Factory<? extends Fragment> provideDetailsFragmentComponentBuilder(SeasonDetailComponent.Builder builder);


    }
}