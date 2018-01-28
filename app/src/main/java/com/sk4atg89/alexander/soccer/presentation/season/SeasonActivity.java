package com.sk4atg89.alexander.soccer.presentation.season;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.presentation.base.BaseActivity;

import javax.inject.Inject;

public class SeasonActivity extends BaseActivity {

    @Inject
    SeasonRouter mRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        mRouter.seasonFragment();

    }


}
