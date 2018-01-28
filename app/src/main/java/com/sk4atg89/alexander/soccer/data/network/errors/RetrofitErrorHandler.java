package com.sk4atg89.alexander.soccer.data.network.errors;

import com.sk4atg89.alexander.soccer.BuildConfig;
import com.sk4atg89.alexander.soccer.data.network.dto.ErrorDto;

import java.io.IOException;
import java.lang.annotation.Annotation;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.SingleTransformer;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.HttpException;
import retrofit2.Retrofit;

@Singleton
public final class RetrofitErrorHandler<T> implements
        SingleTransformer<T, T> {

    private final Converter<ResponseBody, ErrorDto> mConverter;

    @Inject
    public RetrofitErrorHandler(Retrofit retrofit) {
        mConverter = retrofit.responseBodyConverter(ErrorDto.class, new Annotation[0]);
    }

    @SuppressWarnings("unchecked")
    public <R> SingleTransformer<R, R> castSingle() {
        return (SingleTransformer<R, R>) this;
    }

    @Override
    public SingleSource<T> apply(Single<T> upstream) {
        return upstream
                .onErrorResumeNext(throwable -> {
                    if (throwable instanceof HttpException) {
                        HttpException error = (HttpException) throwable;
                        try {
                            ErrorDto dto = mConverter.convert(error.response().errorBody());

                            if (error.code() == 403) {
                                return Single.error(
                                        new AccessDeniedException(dto == null ? error.message() : dto.error));
                            }
                            if (error.code() == 404) {
                                return Single.error(
                                        new NotFoundException(dto == null ? error.message() : dto.error));
                            }

                            if (dto != null) {
                                return Single.error(new AppException(dto, error, String.valueOf(error.code())));
                            }

                        } catch (IOException e) {
                            if (BuildConfig.DEBUG) {
                                e.printStackTrace();
                            }
                        }
                    }
                    return Single.error(throwable);
                });
    }

}
