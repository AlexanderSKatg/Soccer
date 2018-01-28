package com.sk4atg89.alexander.soccer.presentation.team;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.presentation.base.BaseActivity;

import javax.inject.Inject;

public class TeamActivity extends BaseActivity {

    private static final String TEAM_ID = "TEAM_ID";

    public static Intent getIntent(Context context, int id) {
        Intent intent = new Intent(context, TeamActivity.class);
        intent.putExtra(TEAM_ID, id);
        return intent;
    }

    @Inject
    TeamRouter mRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        mRouter.openTeam(getIntent().getIntExtra(TEAM_ID, -1));
    }

}
