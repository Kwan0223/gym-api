package com.best.kwan.vo;

import com.best.kwan.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private String name;

    private String pwd;

    private String number;

    private String email;

    private String address;

    public UserVO(User user){
        this.name = user.getName();
        this.pwd =  user.getPwd();
        this.number = user.getNumber();
        this.email = user.getEmail();
        this.address = user.getAddress();
    }
}
