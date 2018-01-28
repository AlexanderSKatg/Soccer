package com.sk4atg89.alexander.soccer.data.network.mapper;


import com.sk4atg89.alexander.soccer.data.network.dto.PlayerDTO;
import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;
import com.sk4atg89.alexander.soccer.utils.Transformer;
import com.sk4atg89.alexander.soccer.utils.Transformers;

import java.util.List;

import javax.inject.Inject;

public class ListPlayerMapper implements Transformer<List<PlayerDTO>, List<PlayerEntity>> {

    private PlayerMapper mPlayerMapper;

    @Inject
    ListPlayerMapper(PlayerMapper playerMapper) {
        this.mPlayerMapper = playerMapper;
    }

    @Override
    public List<PlayerEntity> transform(List<PlayerDTO> from) {
        return Transformers.transform(from, mPlayerMapper);
    }
}
