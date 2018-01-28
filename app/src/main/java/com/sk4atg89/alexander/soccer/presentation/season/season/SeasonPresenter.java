package com.sk4atg89.alexander.soccer.presentation.season.season;


import com.sk4atg89.alexander.soccer.di.fragment.FragmentScope;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.domain.season.SeasonInteractor;
import com.sk4atg89.alexander.soccer.presentation.base.BasePresenter;
import com.sk4atg89.alexander.soccer.presentation.common.SoccerErrorHandler;
import com.sk4atg89.alexander.soccer.utils.RxComposeSheduler;
import com.sk4atg89.alexander.soccer.utils.RxEmptyAction;
import com.sk4atg89.alexander.soccer.utils.RxManage;

import javax.inject.Inject;

@FragmentScope
public class SeasonPresenter implements BasePresenter<SeasonContract.View>
        , SeasonContract.EventListener {

    private SeasonContract.View mView;
    private final SeasonContract.EventDelegate mEventDelegate;
    private final SeasonInteractor mSeasonInteractor;
    private SoccerErrorHandler mErrorHandler;

    @Inject
    SeasonPresenter(SeasonContract.EventDelegate eventDelegate,
                    SoccerErrorHandler errorHandler,
                    SeasonInteractor seasonInteractor) {
        mEventDelegate = eventDelegate;
        mSeasonInteractor = seasonInteractor;
        mErrorHandler = errorHandler;
    }

    @Override
    public void attachView(SeasonContract.View view) {
        mView = view;
        RxManage.manage(this, mSeasonInteractor.subscribeToSeasons()
                .compose(RxComposeSheduler.applySchedulersObservable())
                .doOnNext(i -> mView.refresh(false))
                .doOnError(t -> mView.refresh(false))
                .subscribe(seasonEntities -> mView.setSeasons(seasonEntities),
                        throwable -> mErrorHandler
                                .handleError(throwable, info -> mView.showMessage(info)), RxEmptyAction.COMPLETE));
    }

    @Override
    public void detachView() {
        mView.refresh(false);
        RxManage.unsubscribe(this);
        mView = null;
    }

    @Override
    public void getSeasons(boolean isRefresh) {
        mSeasonInteractor.updateSeasons(isRefresh);
    }

    @Override
    public void openSeasonDetails(SeasonEntity entity) {
        mEventDelegate.openSeasonDetails(entity);
    }
}
