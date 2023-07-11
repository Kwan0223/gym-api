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
    private String history;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    private TrainerEntity trainer;

}
