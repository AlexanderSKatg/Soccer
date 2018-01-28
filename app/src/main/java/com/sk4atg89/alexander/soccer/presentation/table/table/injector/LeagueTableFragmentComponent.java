package com.sk4atg89.alexander.soccer.presentation.table.table.injector;

import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableRouter;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTableFragment;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableContract;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableFragment;

import dagger.BindsInstance;
import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;

@FragmentScope
@Subcomponent(modules = LeagueTableFragmentComponent.LeagueTableFragmentModule.class)
public interface LeagueTableFragmentComponent extends AndroidInjector<LeagueTableFragment> {

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<LeagueTableFragment> {
        @Override
        public void seedInstance(LeagueTableFragment instance) {
            LeagueTableEntity entity = instance.getArguments().getParcelable(BaseTableFragment.LEAGUE_ENTITY_ENTITY);
            leagueTableEntity(entity);
        }

        @BindsInstance
        public abstract Builder leagueTableEntity(LeagueTableEntity entity);

    }


    @Module
    class LeagueTableFragmentModule {

        @Provides
        LeagueTableContract.EventDelegate provideRouter(LeagueTableRouter router) {
            return router;
        }

    }
}