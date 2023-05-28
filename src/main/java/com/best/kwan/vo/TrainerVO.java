package com.best.kwan.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerVO {

    private int trainerId;

    private int pointId;

    private String email;

    private String pwd;

    private String name;

    private String gender;

    private Date createAt;

    private Date updateAt;
}
