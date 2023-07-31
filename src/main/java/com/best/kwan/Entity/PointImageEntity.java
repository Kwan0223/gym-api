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
    private Long PointImageId;

    @Column(columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "point_id")
    private PointEntity point;

    public PointImageEntity(PointImageVO pointImageVO){
        this.PointImageId = pointImageVO.getPointImageId();
        this.path = pointImageVO.getPath();
    }

}
