package com.sk4atg89.alexander.soccer.presentation.team.players;


import com.sk4atg89.alexander.soccer.domain.players.PlayersInteractor;
import com.sk4atg89.alexander.soccer.presentation.base.BasePresenter;
import com.sk4atg89.alexander.soccer.presentation.common.SoccerErrorHandler;
import com.sk4atg89.alexander.soccer.utils.RxComposeSheduler;
import com.sk4atg89.alexander.soccer.utils.RxManage;

import javax.inject.Inject;

public class PlayersPresenter implements BasePresenter<PlayersContract.View>
        , PlayersContract.EventListener {

    private PlayersContract.View mView;
    private final PlayersInteractor mPlayersInteractor;
    private final SoccerErrorHandler mErrorHandler;
    private final int mId;

    @Inject
    PlayersPresenter(PlayersInteractor playersInteractor
            , SoccerErrorHandler errorHandler
            , int id) {
        mPlayersInteractor = playersInteractor;
        mErrorHandler = errorHandler;
        mId = id;
    }

    @Override
    public void attachView(PlayersContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView.hideLoadingProgress();
        RxManage.unsubscribe(this);
        mView = null;
    }

    @Override
    public void getPlayers() {
        RxManage.manage(this, mPlayersInteractor
                .getTeamPlayersById(mId)
                .compose(RxComposeSheduler.applySchedulersSingle())
                .doOnSubscribe(disposable -> mView.showLoadingProgress())
                .doAfterTerminate(() -> mView.hideLoadingProgress())
                .subscribe(playerEntities -> mView.setPlayers(playerEntities),
                        throwable -> mErrorHandler
                                .handleError(throwable, info -> mView.showMessage(info))));
    }
}
