package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.SoccerSeasonsDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;

import javax.inject.Inject;

public class SoccerMapper implements Transformer<SoccerSeasonsDTO, SeasonEntity> {

    @Inject
    SoccerMapper() {
    }

    @Override
    public SeasonEntity transform(SoccerSeasonsDTO from) {
        return new SeasonEntity(from.id,
                from.caption,
                from.league,
                from.year,
                from.currentMatchday,
                from.numberOfMatchdays,
                from.numberOfTeams,
                from.numberOfGames,
                from.lastUpdated);
    }
}
