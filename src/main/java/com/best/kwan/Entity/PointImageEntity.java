package com.best.kwan.Entity;


import com.best.kwan.vo.PointImageVO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PointImage")
@Entity
public class PointImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long PointImageId;
    @Column(length = 20000)
    private String path;

    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;


    public PointImageEntity(PointImageVO pointImageVO){
        this.PointImageId = pointImageVO.getPointImageId();
        this.path = pointImageVO.getPath();
    }

}
