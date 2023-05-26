package com.best.kwan.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVO {

    private String email;

    private String oldPwd;

    private String newPwd;


}
