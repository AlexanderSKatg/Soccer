package com.sk4atg89.alexander.soccer.presentation.season.season;

import android.os.Bundle;

import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class SeasonUtils {

    private SeasonContract.EventListener mEvent;
    private SeasonContract.View mView;
    private ArrayList<SeasonEntity> mItems = new ArrayList<>();

    SeasonUtils(SeasonContract.EventListener event, SeasonContract.View view) {
        mEvent = event;
        mView = view;
    }

    void onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mEvent.getSeasons(false);
            return;
        }
        Bundle bundle = savedInstanceState.getBundle(SeasonUtils.class.getCanonicalName());
        if (bundle == null) {
            mEvent.getSeasons(false);
            return;
        }
        List<SeasonEntity> list = bundle.getParcelableArrayList("1");
        if (list == null || list.isEmpty()) {
            mEvent.getSeasons(false);
            return;
        }
        setItems(list);
        mView.refresh(false);
    }

    void onSaveInstanceState(Bundle outState) {
        if (outState == null) return;
        Bundle bundle = new Bundle();
        if (mItems != null && !mItems.isEmpty()) {
            bundle.putParcelableArrayList("1", mItems);
            outState.putParcelable(SeasonUtils.class.getCanonicalName(), bundle);
        }
    }

    void setItems(Collection<SeasonEntity> items) {
        mItems.clear();
        this.mItems.addAll(items);
        mView.showSeasons(mItems);
    }

}
