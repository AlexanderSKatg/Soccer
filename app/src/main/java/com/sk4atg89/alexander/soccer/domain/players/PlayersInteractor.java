package com.sk4atg89.alexander.soccer.domain.players;

import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Single;

public class PlayersInteractor {

    private PlayersRepository mPlayersRepository;

    @Inject
    PlayersInteractor(PlayersRepository playersRepository) {
        this.mPlayersRepository = playersRepository;
    }

    public Single<List<PlayerEntity>> getTeamPlayersById(int id) {
        return mPlayersRepository.get(id)
                .flatMap(playerEntities -> {
                    if (playerEntities == null || playerEntities.isEmpty()) {
                        return Single.error(new NoPlayersException("The team doesn't have players"));
                    }
                    return Single.just(playerEntities);
                });
    }

}

