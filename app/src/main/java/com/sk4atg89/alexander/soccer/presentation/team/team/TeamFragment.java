package com.sk4atg89.alexander.soccer.presentation.team.team;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.databinding.FragmentTeamBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.TeamEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseFragment;

import javax.inject.Inject;

public class TeamFragment extends BaseFragment implements TeamContract.View {

    public static TeamFragment newInstance() {
        return new TeamFragment();
    }

    @Inject
    TeamPresenter mPresenter;
    private FragmentTeamBinding mBinding;
    private TeamViewModel mTeamViewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_team, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mTeamViewModel = new TeamViewModel(mPresenter, this);
        mTeamViewModel.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mTeamViewModel.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void setTeam(TeamEntity entity) {
        mTeamViewModel.setTeam(entity);
    }

    @Override
    public void showTeam(TeamViewModel viewModel) {
        mBinding.setVm(viewModel);
    }

}
