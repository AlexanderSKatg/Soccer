package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.ChampionLeagueStandingDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.ChampionLeagueStandingEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;

import javax.inject.Inject;

public class ChampionLeagueStandingMapper implements Transformer<ChampionLeagueStandingDTO, ChampionLeagueStandingEntity> {

    @Inject
    ChampionLeagueStandingMapper() {
    }

    @Override
    public ChampionLeagueStandingEntity transform(ChampionLeagueStandingDTO from) {
        return new ChampionLeagueStandingEntity(from.group,
                from.rank,
                from.team,
                from.teamId,
                from.playedGames,
                from.crestURI,
                from.points,
                from.goals,
                from.goalsAgainst,
                from.goalDifference
        );
    }
}
