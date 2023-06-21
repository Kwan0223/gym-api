package com.best.kwan.exception;

import com.best.kwan.eums.ErrorCode;
import com.best.kwan.vo.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@ControllerAdvice
@Slf4j
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CustomException.class)
    public ResponseEntity<BaseResponse> handleCustomException(CustomException errorCode) {
        logger.error("Error Msg : " + errorCode.getMsg());
        return new ResponseEntity<>(new BaseResponse(errorCode.getMsg()), errorCode.getHttpStatus());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldError fieldError = Objects.requireNonNull(ex.getBindingResult().getFieldError());
        System.out.println("TEST fieldError : " + fieldError);
        if(fieldError.getField().contains("Pwd") || fieldError.getField().contains("Pwd")) {
            return new ResponseEntity<>(new BaseResponse(ErrorCode.PASSWORD_CHECK), ErrorCode.PASSWORD_CHECK.getHttpStatus());

        }
        return new ResponseEntity<>(new BaseResponse(ErrorCode.UNEXPECTED_ERROR),
                ErrorCode.UNEXPECTED_ERROR.getHttpStatus());
    }

    /**
     * 예기치 못한 에러 발생시 작동하는 Exception
     * 하단에 고정 : 코드 읽는 순서 !
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BaseResponse> handlerException(Exception e) {
        e.printStackTrace();
        return new ResponseEntity<>(new BaseResponse(ErrorCode.UNEXPECTED_ERROR),
                ErrorCode.UNEXPECTED_ERROR.getHttpStatus());
    }


}
