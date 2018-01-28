package com.sk4atg89.alexander.soccer.data.players;


import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;
import com.sk4atg89.alexander.soccer.domain.players.PlayersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PlayersRepositoryImpl implements PlayersRepository {

    private PlayersRemote mPlayersRemote;

    @Inject
    PlayersRepositoryImpl(PlayersRemote playersRemote) {
        mPlayersRemote = playersRemote;
    }

    @Override
    public Single<List<PlayerEntity>> get(int id) {
        return mPlayersRemote.getPlayers(id);
    }
}
