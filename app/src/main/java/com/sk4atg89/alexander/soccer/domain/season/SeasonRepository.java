package com.sk4atg89.alexander.soccer.domain.season;

import com.sk4atg89.alexander.soccer.domain.common.Repository;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;

import java.util.List;

import io.reactivex.Observable;

public interface SeasonRepository extends Repository<SeasonEntity> {

    Observable<List<SeasonEntity>> subscribeToSeasons();

    void updateSeasons(boolean isRefresh);
}
