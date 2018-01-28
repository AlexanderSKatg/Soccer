package com.sk4atg89.alexander.soccer.presentation.team.players;

import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

import java.util.List;

public interface PlayersContract {

    interface View extends BaseView {
        void setPlayers(List<PlayerEntity> players);

        void showPlayers(List<PlayerEntity> players);
    }

    interface EventListener {
        void getPlayers();
    }

    interface EventDelegate {
    }


}
