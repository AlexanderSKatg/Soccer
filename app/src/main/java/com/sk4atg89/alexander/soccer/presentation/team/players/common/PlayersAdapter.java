package com.sk4atg89.alexander.soccer.presentation.team.players.common;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersHolder> {

    private List<PlayerEntity> mItems;

    public PlayersAdapter() {
    }

    @Override
    public PlayersHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PlayersHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false));
    }

    @Override
    public void onBindViewHolder(PlayersHolder holder, int position) {
        holder.setup(mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setItems(List<PlayerEntity> items) {
        mItems = items;
        notifyDataSetChanged();
    }

}
