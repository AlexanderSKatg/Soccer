package com.sk4atg89.alexander.soccer.di.app;

import com.sk4atg89.alexander.soccer.BuildConfig;
import com.sk4atg89.alexander.soccer.data.common.AuthInterceptor;
import com.sk4atg89.alexander.soccer.data.network.SoccerApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
final class NetworkModule {

    private final static long TIMEOUT = 15;

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient httpClient) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create());

        builder.client(httpClient);

        return builder.build();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(AuthInterceptor interceptor) {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        clientBuilder.connectTimeout(TIMEOUT, TimeUnit.SECONDS);
        clientBuilder.addInterceptor(interceptor);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            clientBuilder.addInterceptor(loggingInterceptor);
        }

        return clientBuilder.build();
    }

    @Provides
    @Singleton
    SoccerApi provideRestApi(Retrofit retrofit) {
        return retrofit.create(SoccerApi.class);
    }
}

