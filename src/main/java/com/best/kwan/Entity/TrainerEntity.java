package com.best.kwan.Entity;

import com.best.kwan.vo.TrainerVO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainer")
@Entity
public class TrainerEntity extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String pwd;

    @Column(length = 255)
    private String gender;


    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;

    @ManyToOne
    @JoinColumn(name = "reservationId")
    private ReservationEntity reservation;

    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<TrainerImageEntity> trainerImageEntities;
//
    @OneToMany(mappedBy = "trainer", cascade = CascadeType.ALL)
    private List<TrainerHistoryEntity> trainerHistoryEntities;

    public TrainerEntity(TrainerVO trainerVO) {
        this.name = trainerVO.getName();
        this.email = trainerVO.getEmail();
        this.pwd = trainerVO.getPwd();
        this.gender = trainerVO.getGender();
        this.createAt = trainerVO.getCreateAt();
        this.updateAt = trainerVO.getUpdateAt();
    }

}
