package com.sk4atg89.alexander.soccer.data.season;

import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.domain.season.SeasonRepository;
import com.sk4atg89.alexander.soccer.utils.RxComposeSheduler;
import com.sk4atg89.alexander.soccer.utils.RxEmptyAction;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.subjects.PublishSubject;

@Singleton
public class SeasonRepositoryImpl implements SeasonRepository {

    private SeasonRemote mSeasonRemote;
    private PublishSubject<List<SeasonEntity>> mItemSubject;
    private boolean hasToWaitForResponse;

    @Inject
    SeasonRepositoryImpl(SeasonRemote seasonRemote) {
        mSeasonRemote = seasonRemote;
        mItemSubject = PublishSubject.create();

    }

    @Override
    public Observable<List<SeasonEntity>> subscribeToSeasons() {
        return mItemSubject;
    }

    @Override
    public void updateSeasons(boolean isRefresh) {
        if (isRefresh || !hasToWaitForResponse) {
            mSeasonRemote.getSeasons()
                    .compose(RxComposeSheduler.applySchedulersObservable())
                    .doOnSubscribe(disposable -> hasToWaitForResponse = true)
                    .doAfterTerminate(() -> hasToWaitForResponse = false)
                    .subscribe(this::sendItems, RxEmptyAction.ERROR, RxEmptyAction.COMPLETE);
        }
    }

    @Override
    public Single<SeasonEntity> get(int id) {
        return mSeasonRemote.getSeasonDetailById(id);
    }

    private void sendItems(List<SeasonEntity> entities) {
        mItemSubject.onNext(entities);
    }
}
