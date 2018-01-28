package com.sk4atg89.alexander.soccer.domain.common;

import com.sk4atg89.alexander.soccer.domain.common.model.StandingEntity;

import java.util.Comparator;

public class TableComparator implements Comparator<StandingEntity> {

    @Override
    public int compare(StandingEntity t1, StandingEntity t2) {
        if (t1.getPosition() > t2.getPosition()) return 1;
        if (t1.getPosition() < t2.getPosition()) return -1;
        return 0;
    }
}
