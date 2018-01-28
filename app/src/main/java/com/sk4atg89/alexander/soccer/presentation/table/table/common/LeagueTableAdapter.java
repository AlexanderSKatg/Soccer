package com.sk4atg89.alexander.soccer.presentation.table.table.common;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.domain.common.model.StandingEntity;
import com.sk4atg89.alexander.soccer.presentation.table.table.LeagueTableContract;

import java.util.List;

public class LeagueTableAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<StandingEntity> mItems;
    private LeagueTableContract.EventListener mEventListener;

    public LeagueTableAdapter(List<StandingEntity> mItems, LeagueTableContract.EventListener mEventListener) {
        this.mItems = mItems;
        this.mEventListener = mEventListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 0) {
            return new LeagueHeaderTableHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_table_field_name, parent, false));
        }
        return new LeagueTableHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (position > 0) {
            ((LeagueTableHolder) holder).setup(mEventListener, mItems.get(position - 1), position);
        }
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        }
        return 1;
    }
}
