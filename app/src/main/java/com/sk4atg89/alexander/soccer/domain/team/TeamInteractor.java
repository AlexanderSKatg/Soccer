package com.sk4atg89.alexander.soccer.domain.team;


import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;

import javax.inject.Inject;

import io.reactivex.Single;

public class TeamInteractor {

    private TeamRepository mTeamRepository;

    @Inject
    TeamInteractor(TeamRepository teamRepository) {
        this.mTeamRepository = teamRepository;
    }

    public Single<TeamEntity> getTeam(int id) {
        return mTeamRepository.get(id);
    }

}
