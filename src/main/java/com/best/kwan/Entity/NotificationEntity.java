package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notification")
@Entity
public class NotificationEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeId;

    @Column(length = 255)
    private String content;

    @Column
    private Boolean checkYn;

    @ManyToOne
    @JoinColumn(name = "trainerId")
    private TrainerEntity trainer;

    @ManyToOne
    @JoinColumn(name = "userId")
    private UserEntity user;




}
