package com.sk4atg89.alexander.soccer.presentation.season.season;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.databinding.FragmentSeasonBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseFragment;
import com.sk4atg89.alexander.soccer.presentation.season.season.common.SeasonAdapter;

import java.util.List;

import javax.inject.Inject;

public class SeasonFragment extends BaseFragment implements SeasonContract.View {

    public static SeasonFragment newInstance() {
        return new SeasonFragment();
    }

    @Inject
    SeasonPresenter mPresenter;

    private FragmentSeasonBinding mBinding;
    private SeasonAdapter mAdapter;
    private SeasonUtils mSeasonUtils;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_season, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);
        mBinding.rSeason.setHasFixedSize(true);
        mBinding.rSeason.setLayoutManager(new LinearLayoutManager(getActivity()));
        mBinding.rSeason.setAdapter(mAdapter = new SeasonAdapter(mPresenter));
        refresh(true);
        mSeasonUtils = new SeasonUtils(mPresenter, this);
        mSeasonUtils.onViewStateRestored(savedInstanceState);
        mBinding.swipeRefreshLayout.setOnRefreshListener(() -> mPresenter.getSeasons(true));
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        mSeasonUtils.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void refresh(boolean refresh) {
        mBinding.swipeRefreshLayout.setRefreshing(refresh);
    }

    @Override
    public void showSeasons(List<SeasonEntity> seasons) {
        mAdapter.setItems(seasons);
    }

    @Override
    public void setSeasons(List<SeasonEntity> seasons) {
        mSeasonUtils.setItems(seasons);
    }

}
