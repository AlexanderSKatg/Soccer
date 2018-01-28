package com.sk4atg89.alexander.soccer.data.season;

import com.sk4atg89.alexander.soccer.data.network.SoccerApi;
import com.sk4atg89.alexander.soccer.data.network.errors.RetrofitErrorHandler;
import com.sk4atg89.alexander.soccer.data.network.mapper.ListSoccerMapper;
import com.sk4atg89.alexander.soccer.data.network.mapper.SoccerMapper;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class SeasonRemote {
    private SoccerApi mSoccerApi;
    private ListSoccerMapper mListSoccerMapper;
    private SoccerMapper mSoccerMapper;
    private RetrofitErrorHandler<Object> mErrorHandler;

    @Inject
    SeasonRemote(SoccerApi soccerApi,
                 ListSoccerMapper listSoccerMapper,
                 SoccerMapper soccerMapper,
                 RetrofitErrorHandler<Object> errorHandler) {
        mSoccerApi = soccerApi;
        mListSoccerMapper = listSoccerMapper;
        mSoccerMapper = soccerMapper;
        mErrorHandler = errorHandler;
    }

    Observable<List<SeasonEntity>> getSeasons() {
        return mSoccerApi.getSeasons()
                .compose(mErrorHandler.castSingle())
                .map(mListSoccerMapper::transform)
                .toObservable();
    }

    Single<SeasonEntity> getSeasonDetailById(int id) {
        return mSoccerApi.getSeasonDetail(id)
                .compose(mErrorHandler.castSingle())
                .map(mSoccerMapper::transform);
    }

}
