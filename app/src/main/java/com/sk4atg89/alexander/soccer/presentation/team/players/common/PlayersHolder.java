package com.sk4atg89.alexander.soccer.presentation.team.players.common;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sk4atg89.alexander.soccer.databinding.ItemPlayerBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;

class PlayersHolder extends RecyclerView.ViewHolder {

    private ItemPlayerBinding mBinding;

    public PlayersHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

    void setup(PlayerEntity entity) {
        mBinding.setItem(entity);
    }

}
