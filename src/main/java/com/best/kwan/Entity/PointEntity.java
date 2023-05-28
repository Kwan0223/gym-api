package com.best.kwan.Entity;

import com.best.kwan.vo.PointVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "point")
@Entity
public class PointEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;
    private Long companyId;

    @Column(length = 255)
    private String pointName;
    @Column(length = 255)
    private String managerName;
    @Column(length = 255)
    private String managerPhone;

    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String pwd;
    @Column
    private Date createAt;
    @Column(length = 255)
    private Date updateAt;


    @ManyToOne
    @JoinColumn(name = "companyId")
    private CompanyEntity company;

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
    private List<TrainerEntity> trainerEntities;


    public PointEntity(PointVO pointVO){

        this.pointName = pointVO.getPointName();
        this.managerName =pointVO.getManagerName();
        this.managerPhone = pointVO.getManagerPhone();
        this.email = pointVO.getEmail();
        this.pwd = pointVO.getPwd();
        this.createAt = pointVO.getCreateAt();
        this.updateAt = pointVO.getUpdateAt();

    }
}
