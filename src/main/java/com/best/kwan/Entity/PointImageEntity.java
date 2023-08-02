package com.best.kwan.Entity;


import com.best.kwan.vo.PointImageVO;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "point_image")
@Entity
public class PointImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointImageId;

    @Column(columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private PointEntity point;

    public PointImageEntity(PointImageVO pointImageVO){
        this.pointImageId = pointImageVO.getPointImageId();
        this.path = pointImageVO.getPath();
    }

}
