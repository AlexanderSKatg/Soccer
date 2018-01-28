package com.sk4atg89.alexander.soccer.presentation.table.table;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTableFragment;
import com.sk4atg89.alexander.soccer.presentation.table.table.common.LeagueTableAdapter;

import javax.inject.Inject;

public class LeagueTableFragment extends BaseTableFragment implements LeagueTableContract.View {

    public static LeagueTableFragment newInstance(LeagueTableEntity entity) {
        LeagueTableFragment fragment = new LeagueTableFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(BaseTableFragment.LEAGUE_ENTITY_ENTITY, entity);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    LeagueTablePresenter mPresenter;

    @Override
    public void setItem(LeagueTableEntity entity) {
        super.setItem(entity);
        mBinding.rLeagueTable.setAdapter(new LeagueTableAdapter(entity.getStanding(), mPresenter));
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getContext());
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
