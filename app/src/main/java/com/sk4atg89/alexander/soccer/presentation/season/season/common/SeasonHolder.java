package com.sk4atg89.alexander.soccer.presentation.season.season.common;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sk4atg89.alexander.soccer.databinding.ItemSeasonBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.season.season.SeasonContract;

class SeasonHolder extends RecyclerView.ViewHolder {

    private ItemSeasonBinding mBinding;

    SeasonHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    void setup(SeasonContract.EventListener event, SeasonEntity item) {
        mBinding.setEvent(event);
        mBinding.setItem(item);
    }
}
