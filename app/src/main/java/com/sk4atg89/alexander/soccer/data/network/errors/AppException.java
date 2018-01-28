package com.sk4atg89.alexander.soccer.data.network.errors;

import com.sk4atg89.alexander.soccer.data.network.dto.ErrorDto;

public class AppException extends BaseAppException {

    private ErrorDto mErrorDto;

    public AppException(ErrorDto errorDto) {
        super(errorDto != null ? errorDto.error : "");
        mErrorDto = errorDto;
    }

    public AppException(ErrorDto errorDto, Throwable cause, String code) {
        super(errorDto != null ? errorDto.error + " " + code : " " + code, cause);
        mErrorDto = errorDto;
    }

    public ErrorDto getErrorDto() {
        return mErrorDto;
    }

    public void setErrorDto(ErrorDto errorDto) {
        mErrorDto = errorDto;
    }
}