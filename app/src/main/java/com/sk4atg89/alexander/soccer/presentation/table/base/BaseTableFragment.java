package com.sk4atg89.alexander.soccer.presentation.table.base;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.databinding.FragmentLeagueTableBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.LeagueTableEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseFragment;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

public abstract class BaseTableFragment extends BaseFragment implements BaseView {

    public final static String LEAGUE_ENTITY_ENTITY = "LEAGUE_ENTITY_ENTITY";

    protected FragmentLeagueTableBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_league_table, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindPresenter();
        setItem(getArguments().getParcelable(LEAGUE_ENTITY_ENTITY));
    }

    @Override
    public void onDestroy() {
        unbindPresenter();
        super.onDestroy();
    }

    protected void setItem(LeagueTableEntity entity) {
        mBinding.setItem(entity);
        mBinding.rLeagueTable.setHasFixedSize(true);
        mBinding.rLeagueTable.setLayoutManager(getLayoutManager());
    }

    protected abstract RecyclerView.LayoutManager getLayoutManager();

    protected abstract void bindPresenter();

    protected abstract void unbindPresenter();

}
