package com.sk4atg89.alexander.soccer.presentation.table.table.common;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sk4atg89.alexander.soccer.databinding.ItemTableBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.StandingEntity;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableContract;

class LeagueTableHolder extends RecyclerView.ViewHolder {

    private ItemTableBinding mBinding;

    LeagueTableHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    void setup(LeagueTableContract.EventListener event, StandingEntity item, int position) {
        mBinding.setEvent(event);
        mBinding.setItem(item);
        mBinding.setPosition(position);
    }

}
