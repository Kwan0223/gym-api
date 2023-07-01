package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trainerHistory")
@Entity
public class TrainerHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long historyId;

    @Column(length = 255)
    private String history1;

    @Column(length = 255)
    private String history2;

    @Column(length = 255)
    private String history3;

    @Column(length = 255)
    private String history4;

    @Column(length = 255)
    private String history5;

    @Column(length = 255)
    private String history6;

    @Column(length = 255)
    private String history7;

    @Column(length = 255)
    private String history8;

    @Column(length = 255)
    private String history9;

    @Column(length = 255)
    private String history10;



    @ManyToOne
    @JoinColumn(name = "trainerId")
    private TrainerEntity trainer;

}
