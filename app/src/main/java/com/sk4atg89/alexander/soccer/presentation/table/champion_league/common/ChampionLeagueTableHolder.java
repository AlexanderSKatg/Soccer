package com.sk4atg89.alexander.soccer.presentation.table.champion_league.common;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sk4atg89.alexander.soccer.databinding.ItemChampionLeagueBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.ChampionLeagueStandingEntity;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueContract;

class ChampionLeagueTableHolder extends RecyclerView.ViewHolder {

    private ItemChampionLeagueBinding mBinding;

    ChampionLeagueTableHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    void setup(ChampionLeagueContract.EventListener event, ChampionLeagueStandingEntity item) {
        mBinding.setEvent(event);
        mBinding.setItem(item);
    }

}
