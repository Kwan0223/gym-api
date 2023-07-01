package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainerImage")
@Entity
public class TrainerImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainerImageId;


    @Column(length = 20000)
    private String trainerPath;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    private TrainerEntity trainer;

}
