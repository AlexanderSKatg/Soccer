package com.sk4atg89.alexander.soccer.data.network.mapper;

import com.sk4atg89.alexander.soccer.data.network.dto.SoccerSeasonsDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;
import com.sk4atg89.alexander.soccer.utils.Transformers;

import java.util.List;

import javax.inject.Inject;

public class ListSoccerMapper implements Transformer<List<SoccerSeasonsDTO>, List<SeasonEntity>> {

    private SoccerMapper mSoccerMapper;

    @Inject
    ListSoccerMapper(SoccerMapper soccerMapper) {
        mSoccerMapper = soccerMapper;
    }

    @Override
    public List<SeasonEntity> transform(List<SoccerSeasonsDTO> from) {
        return Transformers.transform(from, mSoccerMapper);
    }
}
