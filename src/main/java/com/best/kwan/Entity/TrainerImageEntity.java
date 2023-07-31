package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainer_image")
@Entity
public class TrainerImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "trainer_image_id")
    private Long trainerImageId;

    @Column(columnDefinition = "TEXT")
    private String path;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private TrainerEntity trainer;


}
