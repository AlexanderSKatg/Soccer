package com.sk4atg89.alexander.soccer.presentation.season.detail.injector;

import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.presentation.season.detail.SeasonDetailFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent
public interface SeasonDetailComponent extends AndroidInjector<SeasonDetailFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<SeasonDetailFragment> {
//        @Override
//        public void seedInstance(SeasonDetailFragment instance) {
//            SeasonEntity entity = instance.getArguments().getParcelable(SeasonDetailFragment.SEASON_DETAIL_KEY);
//            season(entity);
//        }
//
//        @BindsInstance
//        public abstract Builder season(SeasonEntity entity);

    }



}
