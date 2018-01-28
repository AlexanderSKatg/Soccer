package com.sk4atg89.alexander.soccer.presentation.team.players;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.databinding.FragmentPlayersBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.PlayerEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseFragment;
import com.sk4atg89.alexander.soccer.presentation.team.players.common.PlayersAdapter;

import java.util.List;

import javax.inject.Inject;

public class PlayersFragment extends BaseFragment implements PlayersContract.View {

    public static PlayersFragment newInstance() {
        return new PlayersFragment();
    }

    @Inject
    PlayersPresenter mPresenter;
    private FragmentPlayersBinding mBinding;
    private PlayersAdapter mAdapter;
    private PlayersViewModel mPlayersViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_players, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mBinding.rPlayers.setHasFixedSize(true);
        mBinding.rPlayers.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rPlayers.setAdapter(mAdapter = new PlayersAdapter());
        mPlayersViewModel = new PlayersViewModel(mPresenter, this);
        mPlayersViewModel.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mPlayersViewModel.onSaveInstanceState(outState);
    }

    @Override
    public void setPlayers(List<PlayerEntity> players) {
        mPlayersViewModel.setItems(players);
    }

    @Override
    public void showPlayers(List<PlayerEntity> players) {
        mAdapter.setItems(players);
    }
}
