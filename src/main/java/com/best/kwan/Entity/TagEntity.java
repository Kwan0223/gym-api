package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tag")
@Entity
public class TagEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(length = 255)
    private String content;


    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;





}
