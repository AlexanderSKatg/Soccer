package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.TeamDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;

import javax.inject.Inject;

public class TeamMapper implements Transformer<TeamDTO, TeamEntity> {

    @Inject
    TeamMapper() {

    }

    @Override
    public TeamEntity transform(TeamDTO from) {
        return new TeamEntity(
                from.name,
                from.code,
                from.shortName,
                from.squadMarketValue,
                from.crestUrl
        );
    }
}
