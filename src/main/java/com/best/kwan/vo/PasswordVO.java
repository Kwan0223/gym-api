package com.best.kwan.vo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVO {

    private String email;

    private String oldPwd;

    private String newPwd;


}
