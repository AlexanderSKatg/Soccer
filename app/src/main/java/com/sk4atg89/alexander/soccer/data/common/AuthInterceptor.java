package com.sk4atg89.alexander.soccer.data.common;

import android.support.annotation.NonNull;

import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Singleton
public class AuthInterceptor implements Interceptor {

    private static String token = "c1fced87b9624809b2b3b35ac9eed8d5";

    @Inject
    AuthInterceptor() {
    }

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        builder.addHeader("X-Auth-Token", token);
        return chain.proceed(builder.build());
    }
}
