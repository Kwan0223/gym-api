package com.best.kwan.vo;

import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    private String pointAddress;

    private String pointUrl;

    private List<String> pointImagePath;


  public PointVO(PointEntity pointEntity){
      this.pointId = pointEntity.getPointId();
      this.pointName = pointEntity.getPointName();
      this.managerName = pointEntity.getManagerName();
      this.managerPhone = pointEntity.getManagerPhone();
      this.email = pointEntity.getEmail();
      this.pwd = pointEntity.getPwd();
      this.createAt = pointEntity.getCreateAt();
      this.updateAt = pointEntity.getUpdateAt();
      this.pointAddress = pointEntity.getPointAddress();
      this.pointUrl  = pointEntity.getPointUrl();
      this.pointImagePath = pointEntity.getPointImageEntities().stream().map((pointImageEntity) ->
      {
        return pointImageEntity.getPath();
      }).collect(Collectors.toList());


  }
}
