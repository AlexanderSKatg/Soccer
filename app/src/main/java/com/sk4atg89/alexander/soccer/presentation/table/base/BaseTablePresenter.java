package com.sk4atg89.alexander.soccer.presentation.table.base;

import android.support.annotation.CallSuper;

import com.sk4atg89.alexander.soccer.presentation.base.BasePresenter;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

public abstract class BaseTablePresenter<T extends BaseView>
        implements BasePresenter<T>, BaseTableEventListener {

    protected T mView;
    private BaseTableEventDelegate eventDelegate;

    protected BaseTablePresenter(BaseTableEventDelegate baseTableEventDelegate) {
        eventDelegate = baseTableEventDelegate;
    }

    @CallSuper
    @Override
    public void attachView(T view) {
        mView = view;
    }

    @CallSuper
    @Override
    public void detachView() {
        mView = null;
    }

    @Override
    public void openClub(int id) {
        eventDelegate.openClub(id);
    }
}
