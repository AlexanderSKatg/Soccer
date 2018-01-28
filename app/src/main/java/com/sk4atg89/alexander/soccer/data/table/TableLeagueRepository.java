package com.sk4atg89.alexander.soccer.data.table;


import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.domain.table.TableRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class TableLeagueRepository implements TableRepository {

    private TableLeagueRemote mTableLeagueRemote;

    @Inject
    public TableLeagueRepository(TableLeagueRemote tableLeagueRemote) {
        mTableLeagueRemote = tableLeagueRemote;
    }

    @Override
    public Single<LeagueTableEntity> get(int id) {
        return mTableLeagueRemote.getTable(id);
    }
}
