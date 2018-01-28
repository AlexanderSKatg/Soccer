package com.sk4atg89.alexander.soccer.presentation.season.detail;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.databinding.FragmentSeasonDetailBinding;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseFragment;

import javax.inject.Inject;

public class SeasonDetailFragment extends BaseFragment implements SeasonDetailContract.View {

    public static final String SEASON_DETAIL_KEY = "SEASON_DETAIL_KEY";
    private SeasonEntity mEntity;

    public static SeasonDetailFragment newInstance(SeasonEntity seasonEntity) {
        SeasonDetailFragment fragment = new SeasonDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(SEASON_DETAIL_KEY, seasonEntity);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Inject
    SeasonDetailPresenter mPresenter;
    private FragmentSeasonDetailBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_season_detail, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mPresenter.attachView(this);

        setSeasonDetail(getArguments().getParcelable(SEASON_DETAIL_KEY));

    }

    @Override
    public void showSeasonDetail(SeasonDetailViewModel viewModel) {
        mBinding.setVm(viewModel);
        mBinding.executePendingBindings();
    }

    @Override
    public void setSeasonDetail(SeasonEntity entity) {
        SeasonDetailViewModel vm =
                new SeasonDetailViewModel(entity, mPresenter);
        showSeasonDetail(vm);
    }


}
