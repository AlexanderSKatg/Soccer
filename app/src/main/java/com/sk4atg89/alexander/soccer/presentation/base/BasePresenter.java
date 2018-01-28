package com.sk4atg89.alexander.soccer.presentation.base;

public interface BasePresenter<V extends BaseView> {

    void attachView(V view);

    void detachView();

}
