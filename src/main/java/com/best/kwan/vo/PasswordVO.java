package com.best.kwan.vo;

import com.best.kwan.validation.Password;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVO {

    private String email;

    @Password
    private String newPwd;


}
