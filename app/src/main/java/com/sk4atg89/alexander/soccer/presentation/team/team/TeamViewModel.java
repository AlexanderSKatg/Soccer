package com.sk4atg89.alexander.soccer.presentation.team.team;

import android.os.Bundle;

import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;

import io.reactivex.functions.Action;

public class TeamViewModel {

    private String imageUrl;
    private String titleName;
    private TeamContract.EventListener mEvent;
    private TeamContract.View mView;
    private Action openDetails;

    public TeamViewModel(TeamContract.EventListener event, TeamContract.View view) {
        mEvent = event;
        mView = view;
        openDetails = () -> mEvent.openPlayers();
    }

    void onViewStateRestored(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            mEvent.getTeam();
            return;
        }
        Bundle bundle = savedInstanceState.getBundle(TeamViewModel.class.getCanonicalName());
        if (bundle == null) {
            mEvent.getTeam();
            return;
        }

        imageUrl = bundle.getString("1");
        titleName = bundle.getString("2");
        showTeam();
    }

    void onSaveInstanceState(Bundle outState) {
        if (outState == null) return;
        Bundle bundle = new Bundle();
        bundle.putString("1", imageUrl);
        bundle.putString("2", titleName);

        outState.putParcelable(TeamViewModel.class.getCanonicalName(), bundle);
    }

    void setTeam(TeamEntity entity) {
        imageUrl = entity.getCrestUrl();
        titleName = entity.getName();
        showTeam();
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitleName() {
        return titleName;
    }

    public Action getOpenDetails() {
        return openDetails;
    }

    private void showTeam() {
        mView.showTeam(this);
    }

}
