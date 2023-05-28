package com.best.kwan.Entity;

import com.best.kwan.vo.TrainerVO;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Trainer")
@Entity
public class TrainerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerId;
    private Long pointId;

    @Column(length = 255)
    private String name;

    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String pwd;

    @Column(length = 255)
    private String gender;
    @Column
    private Date createAt;
    @Column(length = 255)
    private Date updateAt;


    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;



    public TrainerEntity(TrainerVO trainerVO){

        this.name = trainerVO.getName();
        this.email =trainerVO.getEmail();
        this.pwd = trainerVO.getPwd();
        this.gender = trainerVO.getGender();
        this.createAt = trainerVO.getCreateAt();
        this.updateAt = trainerVO.getUpdateAt();

    }
}
