package com.sk4atg89.alexander.soccer.presentation.base;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;

public class BaseRouter {

    private FragmentManager mFragmentManager;

    public BaseRouter(FragmentManager fragmentManager) {
        mFragmentManager = fragmentManager;
    }

    protected void addFragment(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .add(viewGroupId, fragment, tag)
                .commitAllowingStateLoss();
    }

    protected void addFragmentWithBackStack(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .addToBackStack(tag)
                .add(viewGroupId, fragment, tag)
                .commitAllowingStateLoss();
    }

    protected void replaceFragmentWithBackStack(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .replace(viewGroupId, fragment, tag)
                .addToBackStack(tag)
                .commit();
    }

    protected void replaceFragment(int viewGroupId, @NonNull BaseFragment fragment, String tag) {
        mFragmentManager
                .beginTransaction()
                .replace(viewGroupId, fragment, tag)
                .commit();
    }

    protected boolean isFragmentExist(String tag) {
        BaseFragment baseFragment = (BaseFragment) mFragmentManager.findFragmentByTag(tag);
        return baseFragment != null;
    }

}
