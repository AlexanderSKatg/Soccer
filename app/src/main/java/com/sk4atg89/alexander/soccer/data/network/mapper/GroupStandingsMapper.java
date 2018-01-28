package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.GroupStandingsDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.ChampionLeagueStandingEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;
import com.sk4atg89.alexander.soccer.utils.Transformers;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class GroupStandingsMapper implements Transformer<GroupStandingsDTO, List<ChampionLeagueStandingEntity>> {

    private ChampionLeagueStandingMapper mMapper;

    @Inject
    GroupStandingsMapper(ChampionLeagueStandingMapper championLeagueStandingMapper) {
        mMapper = championLeagueStandingMapper;
    }

    @Override
    public List<ChampionLeagueStandingEntity> transform(GroupStandingsDTO from) {
        if (from == null) return null;
        List<ChampionLeagueStandingEntity> entitys = new ArrayList<>();
        entitys.addAll(Transformers.transform(from.a, mMapper));
        entitys.addAll(Transformers.transform(from.b, mMapper));
        entitys.addAll(Transformers.transform(from.c, mMapper));
        entitys.addAll(Transformers.transform(from.d, mMapper));
        entitys.addAll(Transformers.transform(from.f, mMapper));
        entitys.addAll(Transformers.transform(from.e, mMapper));
        entitys.addAll(Transformers.transform(from.g, mMapper));
        entitys.addAll(Transformers.transform(from.h, mMapper));
        return entitys;
    }
}
