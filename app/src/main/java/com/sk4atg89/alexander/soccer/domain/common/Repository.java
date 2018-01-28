package com.sk4atg89.alexander.soccer.domain.common;

import io.reactivex.Single;

public interface Repository<R> {
    Single<R> get(int id);
}
