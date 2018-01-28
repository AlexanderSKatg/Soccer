package com.sk4atg89.alexander.soccer.presentation.season.season;


import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

import java.util.List;

public interface SeasonContract {

    interface View extends BaseView {
        void showSeasons(List<SeasonEntity> seasons);

        void setSeasons(List<SeasonEntity> seasons);

        void refresh(boolean refresh);
    }

    interface EventListener {
        void getSeasons(boolean isRefresh);

        void openSeasonDetails(SeasonEntity entity);
    }

    interface EventDelegate {
        void openSeasonDetails(SeasonEntity entity);
    }

}
