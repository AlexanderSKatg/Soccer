package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.LeagueTableDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;
import com.sk4atg89.alexander.soccer.utils.Transformers;

import javax.inject.Inject;

public class LeagueTableMapper implements Transformer<LeagueTableDTO, LeagueTableEntity> {

    private StandingMapper standingMapper;
    private GroupStandingsMapper groupMapper;

    @Inject
    LeagueTableMapper(StandingMapper standingMapper, GroupStandingsMapper groupMapper) {
        this.standingMapper = standingMapper;
        this.groupMapper = groupMapper;
    }

    @Override
    public LeagueTableEntity transform(LeagueTableDTO from) {
        return new LeagueTableEntity(
                from.leagueCaption,
                from.matchday,
                Transformers.transform(from.standing, standingMapper),
                groupMapper.transform(from.standings)
        );
    }
}
