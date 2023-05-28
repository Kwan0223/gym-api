package com.best.kwan.Entity;

import com.best.kwan.vo.CompanyVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Company")
@Entity
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;

    @Column(length = 255)
    private String companyName;
    @Column(length = 255)
    private String managerName;
    @Column(length = 255)
    private String managerPhone;
    @Column
    private Date createAt;
    @Column(length = 255)
    private Date updateAt;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<PointEntity> points;




public  CompanyEntity (CompanyVO companyVO){
    this.companyName =companyVO.getCompanyName();
    this.managerName = companyVO.getManagerName();
    this.managerPhone = companyVO.getManagerPhone();
    this.createAt = companyVO.getCreateAt();
    this.updateAt = companyVO.getUpdateAt();
}

}
