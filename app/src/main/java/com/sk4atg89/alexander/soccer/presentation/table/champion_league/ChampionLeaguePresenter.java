package com.sk4atg89.alexander.soccer.presentation.table.champion_league;

import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTablePresenter;

import javax.inject.Inject;

public class ChampionLeaguePresenter extends BaseTablePresenter<ChampionLeagueContract.View>
        implements ChampionLeagueContract.EventListener {


    @Inject
    ChampionLeaguePresenter(ChampionLeagueContract.EventDelegate eventDelegate) {
        super(eventDelegate);
    }

    @Override
    public void attachView(ChampionLeagueContract.View view) {
        super.attachView(view);
    }


}
