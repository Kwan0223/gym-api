package com.best.kwan.Entity;

import com.best.kwan.vo.TrainerVO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Trainer")
@Entity
public class TrainerEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;

    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String pwd;

    @Column(length = 255)
    private String gender;




    public TrainerEntity(TrainerVO trainerVO){

        this.name = trainerVO.getName();
        this.email =trainerVO.getEmail();
        this.pwd = trainerVO.getPwd();
        this.gender = trainerVO.getGender();
        this.createAt = trainerVO.getCreateAt();
        this.updateAt = trainerVO.getUpdateAt();

    }
}
