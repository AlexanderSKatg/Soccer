package com.sk4atg89.alexander.soccer.presentation.season.season.common;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.season.season.SeasonContract;

import java.util.List;

public class SeasonAdapter extends RecyclerView.Adapter<SeasonHolder> {
    private SeasonContract.EventListener mEventListener;
    private List<SeasonEntity> mItems;

    public SeasonAdapter(SeasonContract.EventListener eventListener) {
        mEventListener = eventListener;
    }

    @Override
    public SeasonHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SeasonHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_season, parent, false));
    }

    @Override
    public void onBindViewHolder(SeasonHolder holder, int position) {
        holder.setup(mEventListener, mItems.get(position));
    }

    @Override
    public int getItemCount() {
        return mItems == null ? 0 : mItems.size();
    }

    public void setItems(List<SeasonEntity> items) {
        mItems = items;
        notifyDataSetChanged();
    }

}
