package com.sk4atg89.alexander.soccer.presentation.team.players;


import android.os.Bundle;

import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;

import java.util.ArrayList;
import java.util.Collection;

class PlayersViewModel {

    private PlayersContract.EventListener mEvent;
    private PlayersContract.View mView;
    private ArrayList<PlayerEntity> mItems = new ArrayList<>();

    PlayersViewModel(PlayersContract.EventListener event, PlayersContract.View view) {
        this.mEvent = event;
        this.mView = view;
    }

    void onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mEvent.getPlayers();
            return;
        }
        Bundle bundle = savedInstanceState.getBundle(PlayersViewModel.class.getCanonicalName());
        if (bundle == null) {
            mEvent.getPlayers();
            return;
        }
        setItems(bundle.getParcelableArrayList("1"));
    }

    void onSaveInstanceState(Bundle outState) {
        if (outState == null) return;
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("1", mItems);

        outState.putParcelable(PlayersViewModel.class.getCanonicalName(), bundle);
    }

    void setItems(Collection<PlayerEntity> items) {
        mItems.clear();
        this.mItems.addAll(items);
        mView.showPlayers(mItems);
    }
}
