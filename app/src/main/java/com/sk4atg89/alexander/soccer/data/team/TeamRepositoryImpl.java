package com.sk4atg89.alexander.soccer.data.team;

import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;
import com.sk4atg89.alexander.soccer.domain.team.TeamRepository;

import javax.inject.Inject;

import io.reactivex.Single;

public class TeamRepositoryImpl implements TeamRepository {

    private TeamRemote mTeamRemote;

    @Inject
    public TeamRepositoryImpl(TeamRemote teamRemote) {
        mTeamRemote = teamRemote;
    }

    @Override
    public Single<TeamEntity> get(int id) {
        return mTeamRemote.getTeam(id);
    }
}
