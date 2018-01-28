package com.sk4atg89.alexander.soccer.presentation.common;


public interface ErrorHandler {

    void handleError(Throwable throwable, ErrorToView view);
}
