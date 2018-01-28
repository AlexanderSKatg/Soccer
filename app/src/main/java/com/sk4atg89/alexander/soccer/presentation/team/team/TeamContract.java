package com.sk4atg89.alexander.soccer.presentation.team.team;

import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

public interface TeamContract {

    interface View extends BaseView {
        void setTeam(TeamEntity entity);

        void showTeam(TeamViewModel viewModel);
    }

    interface EventListener {
        void getTeam();

        void openPlayers();
    }

    interface EventDelegate {
        void openPlayers(int id);
    }


}
