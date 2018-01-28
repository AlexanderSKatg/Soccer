package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.HomeAwayDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.HomeAwayEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;

import javax.inject.Inject;

public class HomeAwayMapper implements Transformer<HomeAwayDTO, HomeAwayEntity> {

    @Inject
    HomeAwayMapper() {
    }

    @Override
    public HomeAwayEntity transform(HomeAwayDTO from) {
        return new HomeAwayEntity(
                from.goals,
                from.goalsAgainst,
                from.wins,
                from.draws,
                from.losses
        );
    }
}
