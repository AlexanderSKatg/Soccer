package com.sk4atg89.alexander.soccer.data.network.mapper;


import com.sk4atg89.alexander.soccer.data.network.dto.PlayerDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;

import javax.inject.Inject;

public class PlayerMapper implements Transformer<PlayerDTO, PlayerEntity> {

    @Inject
    PlayerMapper() {

    }

    @Override
    public PlayerEntity transform(PlayerDTO from) {
        return new PlayerEntity(
                from.name,
                from.position,
                from.jerseyNumber,
                from.dateOfBirth,
                from.nationality,
                from.contractUntil
        );
    }
}
