package com.sk4atg89.alexander.soccer.presentation.table.table;

import com.sk4atg89.alexander.soccer.presentation.base.BaseView;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTableEventDelegate;
import com.sk4atg89.alexander.soccer.presentation.table.base.BaseTableEventListener;

public interface LeagueTableContract {

    interface View extends BaseView {
    }

    interface EventListener extends BaseTableEventListener {
    }

    interface EventDelegate extends BaseTableEventDelegate {
    }

}
