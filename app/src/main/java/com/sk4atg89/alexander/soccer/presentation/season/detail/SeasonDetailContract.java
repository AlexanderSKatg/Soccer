package com.sk4atg89.alexander.soccer.presentation.season.detail;

import com.sk4atg89.alexander.soccer.domain.common.model.SeasonEntity;
import com.sk4atg89.alexander.soccer.presentation.base.BaseView;

public interface SeasonDetailContract {

    interface View extends BaseView {
        void showSeasonDetail(SeasonDetailViewModel viewModel);
        void setSeasonDetail(SeasonEntity entity);
    }

    interface EventListener {
        void refresh(int id);
        void details(int id);
    }

    interface EventDelegate {
        void openDetails(int id);
    }

}
