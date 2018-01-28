package com.sk4atg89.alexander.soccer.presentation.team.team;

import com.sk4atg89.alexander.soccer.domain.team.TeamInteractor;
import com.sk4atg89.alexander.soccer.presentation.base.BasePresenter;
import com.sk4atg89.alexander.soccer.presentation.common.SoccerErrorHandler;
import com.sk4atg89.alexander.soccer.utils.RxComposeSheduler;
import com.sk4atg89.alexander.soccer.utils.RxManage;

import javax.inject.Inject;

public class TeamPresenter implements BasePresenter<TeamContract.View>, TeamContract.EventListener {

    private TeamContract.View mView;
    private final TeamContract.EventDelegate mEventDelegate;
    private final TeamInteractor mTeamInteractor;
    private final int mId;
    private SoccerErrorHandler mErrorHandler;

    @Inject
    TeamPresenter(TeamInteractor teamInteractor
            , TeamContract.EventDelegate eventDelegate
            , SoccerErrorHandler errorHandler
            , int id) {
        mTeamInteractor = teamInteractor;
        mEventDelegate = eventDelegate;
        mErrorHandler = errorHandler;
        mId = id;
    }

    @Override
    public void attachView(TeamContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView.hideLoadingProgress();
        RxManage.unsubscribe(this);
        mView = null;
    }

    @Override
    public void getTeam() {
        RxManage.manage(this, mTeamInteractor.getTeam(mId)
                .compose(RxComposeSheduler.applySchedulersSingle())
                .doOnSubscribe(disposable -> mView.showLoadingProgress())
                .doAfterTerminate(() -> mView.hideLoadingProgress())
                .subscribe(teamEntity -> mView.setTeam(teamEntity),
                        throwable -> mErrorHandler
                                .handleError(throwable, info -> mView.showMessage(info))));
    }

    @Override
    public void openPlayers() {
        mEventDelegate.openPlayers(mId);
    }

}
