package com.sk4atg89.alexander.soccer.presentation.table;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.sk4atg89.alexander.soccer.R;
import com.sk4atg89.alexander.soccer.presentation.base.BaseActivity;

import javax.inject.Inject;

public class LeagueTableActivity extends BaseActivity {

    public static final String LEAGUE_TABLE_KEY = "LEAGUE_TABLE_KEY";

    public static Intent getIntent(Context context, int id) {
        Intent intent = new Intent(context, LeagueTableActivity.class);
        intent.putExtra(LEAGUE_TABLE_KEY, id);
        return intent;
    }

    @Inject
    LeagueTableRouter mRouter;
    private AlertDialog mUploadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        mRouter.openTable(getIntent().getIntExtra(LEAGUE_TABLE_KEY, -1));
    }

    @Override
    protected void onDestroy() {
        mRouter.cleanRxManage();
        super.onDestroy();
    }

    public void showLoadingProgress() {
        if (this.mUploadingDialog == null) {
            this.mUploadingDialog = new AlertDialog.Builder(this).setView(R.layout.view_loading_dialog).show();
            this.mUploadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            this.mUploadingDialog.setCancelable(false);
            return;
        }
        this.mUploadingDialog.show();
    }

    public void hideLoadingProgress() {
        if (this.mUploadingDialog != null) {
            this.mUploadingDialog.dismiss();
        }
    }

    public void showMessage(String info) {
        Toast.makeText(this, info, Toast.LENGTH_LONG).show();
    }
}
