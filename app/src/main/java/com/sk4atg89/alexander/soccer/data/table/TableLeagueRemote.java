package com.sk4atg89.alexander.soccer.data.table;

import com.sk4atg89.alexander.soccer.data.network.SoccerApi;
import com.sk4atg89.alexander.soccer.data.network.errors.RetrofitErrorHandler;
import com.sk4atg89.alexander.soccer.data.network.mapper.LeagueTableMapper;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class TableLeagueRemote {

    private SoccerApi mSoccerApi;
    private LeagueTableMapper mapper;
    private RetrofitErrorHandler<Object> mErrorHandler;

    @Inject
    TableLeagueRemote(SoccerApi mSoccerApi,
                      LeagueTableMapper mapper,
                      RetrofitErrorHandler<Object> errorHandler) {
        this.mSoccerApi = mSoccerApi;
        this.mapper = mapper;
        mErrorHandler = errorHandler;
    }

    Single<LeagueTableEntity> getTable(int id) {
        return mSoccerApi.getTable(id)
                .compose(mErrorHandler.castSingle())
                .map(mapper::transform);
    }

}
