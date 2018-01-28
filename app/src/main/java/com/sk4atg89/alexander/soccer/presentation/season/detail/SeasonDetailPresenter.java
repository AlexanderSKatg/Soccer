package com.sk4atg89.alexander.soccer.presentation.season.detail;

import com.sk4atg89.alexander.soccer.domain.season.SeasonInteractor;
import com.sk4atg89.alexander.soccer.presentation.base.BasePresenter;
import com.sk4atg89.alexander.soccer.presentation.common.SoccerErrorHandler;
import com.sk4atg89.alexander.soccer.utils.RxComposeSheduler;
import com.sk4atg89.alexander.soccer.utils.RxManage;

import javax.inject.Inject;

public class SeasonDetailPresenter implements BasePresenter<SeasonDetailContract.View>, SeasonDetailContract.EventListener {

    private SeasonDetailContract.View mView;
    private final SeasonDetailContract.EventDelegate mEventDelegate;
    private final SeasonInteractor mSeasonInteractor;
    private SoccerErrorHandler mErrorHandler;

    @Inject
    SeasonDetailPresenter(SeasonDetailContract.EventDelegate eventDelegate
            , SeasonInteractor seasonInteractor
            , SoccerErrorHandler errorHandler) {
        mEventDelegate = eventDelegate;
        mErrorHandler = errorHandler;
        mSeasonInteractor = seasonInteractor;
    }

    @Override
    public void attachView(SeasonDetailContract.View view) {
        mView = view;
    }

    @Override
    public void detachView() {
        mView.hideLoadingProgress();
        RxManage.unsubscribe(this);
        mView = null;
    }

    @Override
    public void refresh(int id) {
        RxManage.manage(this, mSeasonInteractor
                .getSeasonDetailById(id)
                .compose(RxComposeSheduler.applySchedulersSingle())
                .doOnSubscribe(disposable -> mView.showLoadingProgress())
                .doAfterTerminate(() -> mView.hideLoadingProgress())
                .subscribe(seasonEntities -> mView.setSeasonDetail(seasonEntities),
                        throwable -> mErrorHandler
                                .handleError(throwable, info -> mView.showMessage(info)))
        );
    }

    @Override
    public void details(int id) {
        mEventDelegate.openDetails(id);
    }

}
