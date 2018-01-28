package com.sk4atg89.alexander.soccer.domain.table;

import com.sk4atg89.alexander.soccer.domain.common.TableComparator;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.Single;

public class TableInteractor {

    private TableRepository mRepository;

    @Inject
    public TableInteractor(TableRepository mRepository) {
        this.mRepository = mRepository;
    }

    public Single<LeagueTableEntity> getTable(int id) {
        return mRepository.get(id)
                .map(entity -> {
                    if (entity.getStanding() != null) {
                        Collections.sort(entity.getStanding(), new TableComparator());
                    }
                    return entity;
                });
    }
}
