package com.best.kwan.vo;

import com.best.kwan.Entity.UserEntity;
import com.best.kwan.validation.Password;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserVO {

    private Long userId;
    private String name;
    @Password
    private String pwd;
    private String number;
    private String email;
    private String address;
    private String image;

    public UserVO(UserEntity userEntity) {
        this.userId = getUserId();
        this.name = userEntity.getName();
        this.pwd = userEntity.getPwd();
        this.number = userEntity.getNumber();
        this.email = userEntity.getEmail();
        this.address = userEntity.getAddress();
    }

    public static UserVO toUserVO(UserEntity userEntity) {

        UserVO userVO = new UserVO();
        userVO.setUserId(userEntity.getId());
        userVO.setName(userEntity.getName());
        userVO.setPwd(userEntity.getPwd());
        userVO.setEmail(userEntity.getEmail());
        userVO.setNumber(userEntity.getNumber());
        userVO.setAddress(userEntity.getAddress());

        return userVO;
    }


}
