package com.sk4atg89.alexander.soccer.data.players;


import com.sk4atg89.alexander.soccer.data.network.SoccerApi;
import com.sk4atg89.alexander.soccer.data.network.errors.RetrofitErrorHandler;
import com.sk4atg89.alexander.soccer.data.network.mapper.ListPlayerMapper;
import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PlayersRemote {

    private SoccerApi mSoccerApi;
    private ListPlayerMapper mMapper;
    private RetrofitErrorHandler<Object> mErrorHandler;

    @Inject
    PlayersRemote(SoccerApi soccerApi,
                  ListPlayerMapper mapper,
                  RetrofitErrorHandler<Object> errorHandler) {
        mSoccerApi = soccerApi;
        mMapper = mapper;
        mErrorHandler = errorHandler;
    }

    Single<List<PlayerEntity>> getPlayers(int id) {
        return mSoccerApi.getPlayers(id)
                .compose(mErrorHandler.castSingle())
                .map(teamPlayersDTO -> teamPlayersDTO.players)
                .map(mMapper::transform);
    }

}
