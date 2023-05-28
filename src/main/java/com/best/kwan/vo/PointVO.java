package com.best.kwan.vo;

import com.best.kwan.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PointVO {

    private Long pointId;

    private Long companyId;

    private String pointName;

    private String managerName;

    private String managerPhone;

    private String email;

    private String pwd;

    private Date createAt;
    private Date updateAt;



}
