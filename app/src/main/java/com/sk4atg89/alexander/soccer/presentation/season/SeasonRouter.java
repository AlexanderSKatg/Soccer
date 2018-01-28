package com.sk4atg89.alexander.soccer.presentation.season;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.di.activity.ActivityScope;
import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseRouter;
import com.sk4atg89.alexander.soccer.presentation.season.detail.SeasonDetailContract;
import com.sk4atg89.alexander.soccer.presentation.season.detail.SeasonDetailFragment;
import com.sk4atg89.alexander.soccer.presentation.season.season.SeasonContract;
import com.sk4atg89.alexander.soccer.presentation.season.season.SeasonFragment;
import com.sk4atg89.alexander.soccer.presentation.table.LeagueTableActivity;

import javax.inject.Inject;

@ActivityScope
public class SeasonRouter extends BaseRouter
        implements SeasonContract.EventDelegate
        , SeasonDetailContract.EventDelegate {

    private SeasonActivity mActivity;

    @Inject
    SeasonRouter(SeasonActivity activity) {
        super(activity.getSupportFragmentManager());
        mActivity = activity;
    }

    @Override
    public void openSeasonDetails(SeasonEntity entity) {
        if (!isFragmentExist("SeasonDetailFragment")) {
            addFragmentWithBackStack(R.id.container, SeasonDetailFragment.newInstance(entity), "SeasonDetailFragment");
        }
//        mActivity.startActivity(LeagueTableActivity.getIntent(mActivity, entity.getId()));
    }

    @Override
    public void openDetails(int id) {
        mActivity.startActivity(LeagueTableActivity.getIntent(mActivity, id));
    }

    void seasonFragment() {
        if (!isFragmentExist("SeasonFragment")) {
            replaceFragment(R.id.container, SeasonFragment.newInstance(), "SeasonFragment");
        }
    }

}
