package com.sk4atg89.alexander.soccer.utils;

public interface Transformer<F, T> {
    T transform(F from);
}
