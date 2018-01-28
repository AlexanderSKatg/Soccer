package com.sk4atg89.alexander.soccer.domain.season;

import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SeasonInteractor {

    private SeasonRepository mRepository;

    @Inject
    SeasonInteractor(SeasonRepository repository) {
        this.mRepository = repository;
    }

    public Observable<List<SeasonEntity>> subscribeToSeasons() {
        return mRepository.subscribeToSeasons();
    }

    public Single<SeasonEntity> getSeasonDetailById(int id) {
        return mRepository.get(id);
    }

    public void updateSeasons(boolean isRefresh) {
        mRepository.updateSeasons(isRefresh);
    }
}
