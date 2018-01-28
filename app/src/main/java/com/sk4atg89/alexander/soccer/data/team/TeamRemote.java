package com.sk4atg89.alexander.soccer.data.team;


import com.sk4atg89.alexander.soccer.data.network.SoccerApi;
import com.sk4atg89.alexander.soccer.data.network.errors.RetrofitErrorHandler;
import com.sk4atg89.alexander.soccer.data.network.mapper.TeamMapper;
import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class TeamRemote {

    private SoccerApi mSoccerApi;
    private TeamMapper mTeamMapper;
    private RetrofitErrorHandler<Object> mErrorHandler;


    @Inject
    TeamRemote(SoccerApi soccerApi,
               TeamMapper teamMapper,
               RetrofitErrorHandler<Object> errorHandler) {
        this.mSoccerApi = soccerApi;
        mTeamMapper = teamMapper;
        mErrorHandler = errorHandler;
    }

    Single<TeamEntity> getTeam(int id) {
        return mSoccerApi.getTeams(id)
                .compose(mErrorHandler.castSingle())
                .map(mTeamMapper::transform);
    }
}
