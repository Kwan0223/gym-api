package com.best.kwan.vo;

import com.best.kwan.eums.ErrorCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponse {

    protected String msg;  //상속받은 애만 사용가능 protected


    public BaseResponse(ErrorCode errorCode){
        this.msg = errorCode.getMsg();
    }
}
