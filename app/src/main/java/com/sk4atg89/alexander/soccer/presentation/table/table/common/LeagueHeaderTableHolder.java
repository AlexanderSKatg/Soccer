package com.sk4atg89.alexander.soccer.presentation.table.table.common;


import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.sk4atg89.alexander.soccer.databinding.ItemTableFieldNameBinding;

class LeagueHeaderTableHolder extends RecyclerView.ViewHolder {

    private ItemTableFieldNameBinding mBinding;

    LeagueHeaderTableHolder(View itemView) {
        super(itemView);
        mBinding = DataBindingUtil.bind(itemView);
    }

}
