package com.sk4atg89.alexander.soccer.presentation.table.champion_league.common;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.domain.common.model.ChampionLeagueStandingEntity;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.ChampionLeagueContract;

import java.util.List;

public class ChampionLeagueTableAdapter extends RecyclerView.Adapter<ChampionLeagueTableHolder> {

    private List<ChampionLeagueStandingEntity> mItems;
    private ChampionLeagueContract.EventListener mEventListener;

    public ChampionLeagueTableAdapter(List<ChampionLeagueStandingEntity> mItems, ChampionLeagueContract.EventListener mEventListener) {
        this.mItems = mItems;
        this.mEventListener = mEventListener;
    }

    @Override
    public ChampionLeagueTableHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ChampionLeagueTableHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_champion_league, parent, false));
    }

    @Override
    public void onBindViewHolder(ChampionLeagueTableHolder holder, int position) {
        holder.setup(mEventListener, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }
}
