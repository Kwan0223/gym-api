package com.best.kwan.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CompanyVO {

    private int  companyId;

    private String CompanyName;

    private String managerName;

    private String managerPhone;

    private LocalDateTime createAt;

    private LocalDateTime updateAt;

    private String companyAddress;

    private String conpanyUrl;

}
