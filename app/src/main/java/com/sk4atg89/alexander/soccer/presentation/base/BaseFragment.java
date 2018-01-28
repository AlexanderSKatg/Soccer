package com.sk4atg89.alexander.soccer.presentation.base;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.widget.Toast;

import com.sk4atg89.alexander.soccer.R;

import dagger.android.support.AndroidSupportInjection;

public abstract class BaseFragment extends Fragment implements BaseView {

    private AlertDialog mUploadingDialog;

    @Override
    public void onAttach(Context context) {
        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoadingProgress() {
        if (this.mUploadingDialog == null) {
            this.mUploadingDialog = new Builder(getContext()).setView(R.layout.view_loading_dialog).show();
            this.mUploadingDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            this.mUploadingDialog.setCancelable(false);
            return;
        }
        this.mUploadingDialog.show();
    }

    @Override
    public void hideLoadingProgress() {
        if (this.mUploadingDialog != null) {
            this.mUploadingDialog.dismiss();
        }
    }

}
