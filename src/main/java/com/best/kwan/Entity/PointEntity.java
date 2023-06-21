package com.best.kwan.Entity;

import com.best.kwan.vo.PointVO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "point")
@Entity
public class PointEntity extends BaseEntity{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointId;
//    private Long companyId;

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

    @Column(length = 255)
    private String pointAddress;

    @Column(length = 255)
    private String pointUrl;




    @ManyToOne
    @JoinColumn(name = "companyId")
    private CompanyEntity company;


    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
    private List<PointImageEntity> pointImageEntities;

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
    private List<TrainerEntity> trainerEntities;

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
    private List<ProductEntity> productEntities;

    @OneToMany(mappedBy = "point", cascade = CascadeType.ALL)
    private List<ScheduleEntity> scheduleEntities;


    public PointEntity(PointVO pointVO){

        this.pointName = pointVO.getPointName();
        this.managerName =pointVO.getManagerName();
        this.managerPhone = pointVO.getManagerPhone();
        this.email = pointVO.getEmail();
        this.pwd = pointVO.getPwd();
        this.createAt = pointVO.getCreateAt();
        this.updateAt = pointVO.getUpdateAt();
        this.pointAddress = pointVO.getPointAddress();
        this.pointUrl = pointVO.getPointUrl();

    }
}
