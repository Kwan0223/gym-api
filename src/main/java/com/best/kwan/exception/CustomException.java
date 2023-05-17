package com.best.kwan.exception;

import com.best.kwan.eums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@AllArgsConstructor
@Getter
public class CustomException extends RuntimeException{

    String msg;

    HttpStatus httpStatus;


    public CustomException(ErrorCode errorCode){
        super();
        this.httpStatus = errorCode.getHttpStatus();
        this.msg = errorCode.getMsg();
    }



}