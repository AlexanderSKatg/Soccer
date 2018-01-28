package com.sk4atg89.alexander.soccer.presentation.table;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.di.activity.ActivityScope;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.domain.table.TableInteractor;
import com.sk4atg89.alexander.soccer.presentation.base.BaseRouter;
import com.sk4atg89.alexander.soccer.presentation.common.SoccerErrorHandler;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueContract;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueFragment;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableContract;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableFragment;
import com.sk4atg89.alexander.soccer.presentation.team.TeamActivity;
import com.sk4atg89.alexander.soccer.utils.RxComposeSheduler;
import com.sk4atg89.alexander.soccer.utils.RxManage;

import javax.inject.Inject;

@ActivityScope
public class LeagueTableRouter extends BaseRouter
        implements LeagueTableContract.EventDelegate
        , ChampionLeagueContract.EventDelegate {

    private TableInteractor mTableInteractor;
    private SoccerErrorHandler mErrorHandler;
    private LeagueTableActivity mActivity;

    @Inject
    LeagueTableRouter(LeagueTableActivity activity
            , SoccerErrorHandler errorHandler
            , TableInteractor tableInteractor) {
        super(activity.getSupportFragmentManager());
        mActivity = activity;
        mErrorHandler = errorHandler;
        mTableInteractor = tableInteractor;
    }

    @Override
    public void openClub(int id) {
        mActivity.startActivity(TeamActivity.getIntent(mActivity, id));
    }

    void openTable(int id) {
        RxManage.manage(this, mTableInteractor.getTable(id)
                .compose(RxComposeSheduler.applySchedulersSingle())
                .doOnSubscribe(disposable -> mActivity.showLoadingProgress())
                .doAfterTerminate(() -> mActivity.hideLoadingProgress())
                .subscribe(this::openTable,
                        throwable -> mErrorHandler
                                .handleError(throwable, info -> mActivity.showMessage(info))));
    }

    void cleanRxManage() {
        RxManage.unsubscribe(this);
    }

    private void openTable(LeagueTableEntity leagueTableEntity) {
        if (leagueTableEntity.getStandings() == null) {
            openLeagueTable(leagueTableEntity);
        } else {
            openChampionLeagueTable(leagueTableEntity);
        }
    }

    private void openLeagueTable(LeagueTableEntity leagueTableEntity) {
//        if (!isFragmentExist("LeagueTableFragment")) {
        replaceFragment(R.id.container, LeagueTableFragment.newInstance(leagueTableEntity), "LeagueTableFragment");
//        }
    }

    private void openChampionLeagueTable(LeagueTableEntity leagueTableEntity) {
//        if (!isFragmentExist("ChampionLeagueFragment")) {
        replaceFragment(R.id.container, ChampionLeagueFragment.newInstance(leagueTableEntity), "ChampionLeagueFragment");
//        }
    }

}
