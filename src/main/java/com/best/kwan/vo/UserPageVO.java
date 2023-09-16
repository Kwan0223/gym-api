package com.best.kwan.vo;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPageVO {


    private int totalSize;
    List<UserVO> userList;
}
