package com.sk4atg89.alexander.soccer.presentation.table.champion_league;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTableFragment;
import com.sk4atg89.alexander.soccer.presentation.table.champion_league.common.ChampionLeagueTableAdapter;

import javax.inject.Inject;

public class ChampionLeagueFragment extends BaseTableFragment implements ChampionLeagueContract.View {

    public static ChampionLeagueFragment newInstance(LeagueTableEntity entity) {
        ChampionLeagueFragment fragment = new ChampionLeagueFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BaseTableFragment.LEAGUE_ENTITY_ENTITY, entity);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    ChampionLeaguePresenter mPresenter;
    private GridLayoutManager mLayoutManager;

    @Override
    public void setItem(LeagueTableEntity entity) {
        super.setItem(entity);
        mBinding.rLeagueTable.setAdapter(new ChampionLeagueTableAdapter(entity.getStandings(), mPresenter));
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            mLayoutManager.setSpanCount(2);
        } else {
            mLayoutManager.setSpanCount(4);
        }
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        if (mLayoutManager == null) {
            mLayoutManager = new GridLayoutManager(getContext(), 2);
        }
        return mLayoutManager;
    }

    @Override
    protected void bindPresenter() {
        mPresenter.attachView(this);
    }

    @Override
    protected void unbindPresenter() {
        mPresenter.detachView();
    }
}
