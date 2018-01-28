package com.sk4atg89.alexander.soccer.presentation.team;

import android.os.Bundle;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.presentation.base.BaseRouter;
import com.sk4atg89.alexander.soccer.presentation.team.players.PlayersContract;
import com.sk4atg89.alexander.soccer.presentation.team.players.PlayersFragment;
import com.sk4atg89.alexander.soccer.presentation.team.team.TeamContract;
import com.sk4atg89.alexander.soccer.presentation.team.team.TeamFragment;

import javax.inject.Inject;

public class TeamRouter extends BaseRouter implements
        TeamContract.EventDelegate
        , PlayersContract.EventDelegate {

    @Inject
    TeamRouter(TeamActivity activity) {
        super(activity.getSupportFragmentManager());
    }


    void openTeam(int id) {
        if (!isFragmentExist("TeamFragment")) {
            TeamFragment fragment = TeamFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putInt("TEAM_ID_KEY", id);
            fragment.setArguments(bundle);
            replaceFragment(R.id.container, fragment, "TeamFragment");
        }
    }

    @Override
    public void openPlayers(int id) {
        if (!isFragmentExist("PlayersFragment")) {
            PlayersFragment fragment = PlayersFragment.newInstance();
            Bundle bundle = new Bundle();
            bundle.putInt("PLAYERS_ID_KEY", id);
            fragment.setArguments(bundle);
            addFragmentWithBackStack(R.id.container, fragment, "PlayersFragment");
        }
    }
}
