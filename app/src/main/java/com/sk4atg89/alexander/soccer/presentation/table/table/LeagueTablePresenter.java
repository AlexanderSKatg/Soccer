package com.sk4atg89.alexander.soccer.presentation.table.table;

import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTablePresenter;

import javax.inject.Inject;

@FragmentScope
public class LeagueTablePresenter extends BaseTablePresenter<LeagueTableContract.View>
        implements LeagueTableContract.EventListener {

    @Inject
    LeagueTablePresenter(LeagueTableContract.EventDelegate eventDelegate) {
        super(eventDelegate);
    }

}
