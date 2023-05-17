package com.best.kwan.Entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Gym")
@Entity
public class GymEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gymId;

    @Column(length = 255)
    private String gymName;
    @Column(length = 255)
    private String gymaddr;
    @Column(length = 255)
    private String gymNum;
    @Column(length = 255)
    private String openDt;
    @Column(length = 255)
    private String closeDt;
    @Column(length = 255)
    private String  productPrice;
    @Column(length = 255)
    private String introduction;
    @Column(length = 255)
    private String gymUrl;


    //만약 카카오맵이나 다른 api를 불러 gym 정보를 가져올경우 필요없음 테이블
    //만약 아니고 등록된 헬스장만 보게된다면  테이블 필요
    // 그리고 관계를 맞을 테이블 : 각 헬스장 트레이너 정보



}
