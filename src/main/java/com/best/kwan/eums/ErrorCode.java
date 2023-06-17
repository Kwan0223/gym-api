package com.best.kwan.eums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    
    SUCCESS(HttpStatus.OK, "성공"),
    INVALID_AUTH_TOKEN(HttpStatus.UNAUTHORIZED, "권한 정보가 없는 토큰입니다."),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당하는 정보의 사용자를 찾을 수 없습니다."),

    DUPLICATE_RESOURCE(HttpStatus.CONFLICT, "데이터가 이미 존재합니다."),

    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예기치 못한 에러가 발생하였습니다."),
    PASSWORD_MISMATCH(HttpStatus.BAD_REQUEST ,"비밀번호가 맞지 않습니다." ),
    PASSWORD_SAME(HttpStatus.BAD_REQUEST ,"이전 비밀번호와 동일합니다." );

    private final HttpStatus httpStatus;
    private final String msg;
}
