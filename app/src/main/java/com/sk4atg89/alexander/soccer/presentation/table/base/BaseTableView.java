package com.sk4atg89.alexander.soccer.presentation.table.base;


import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

public interface BaseTableView extends BaseView {
    void setItem(LeagueTableEntity entity);
}
