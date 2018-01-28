package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.StandingDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.StandingEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;

import javax.inject.Inject;

public class StandingMapper implements Transformer<StandingDTO, StandingEntity> {

    private HomeAwayMapper mapper;

    @Inject
    StandingMapper(HomeAwayMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public StandingEntity transform(StandingDTO from) {
        return new StandingEntity(
                from.linkDTO.team.href,
                from.position,
                from.teamName,
                from.crestURI,
                from.playedGames,
                from.points,
                from.goals,
                from.goalsAgainst,
                from.goalDifference,
                from.wins,
                from.draws,
                from.losses,
                mapper.transform(from.home),
                mapper.transform(from.away)
        );
    }
}
