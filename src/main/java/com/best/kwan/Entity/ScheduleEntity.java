package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "schedule")
@Entity
public class ScheduleEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;
    @Column(length = 255)
    private String startTime;
    @Column(length = 255)
    private String endTime;

    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;

    @OneToMany(mappedBy = "schedule", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationEntities;

}
