package com.sk4atg89.alexander.soccer.presentation.common;

import android.util.Log;

import com.sk4atg89.alexander.soccer.data.network.errors.BaseAppException;
import com.sk4atg89.alexander.soccer.domain.players.NoPlayersException;

import javax.inject.Inject;

public class SoccerErrorHandler implements ErrorHandler {

    @Inject
    SoccerErrorHandler() {
    }

    @Override
    public void handleError(Throwable throwable, ErrorToView view) {
        Log.d("SeasonRepositoryImpl","handleError");

        if (view != null) {
            String message = "Something went wrong";

            if (throwable instanceof BaseAppException) {
                message = throwable.getMessage();
            } else if (throwable instanceof NoPlayersException) {
                message = throwable.getMessage();
            }
            view.showMessage(message);
        }

    }
}
