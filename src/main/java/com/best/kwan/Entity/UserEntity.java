package com.best.kwan.Entity;

import com.best.kwan.vo.UserVO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "User")
@Entity
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 200)
    private String name;

    @Column(length = 255)
    private String pwd;

    @Column
    private String number;

    @Column
    private String email;

    @Column
    private String address;

    @Column
    private String imagePath;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReservationEntity> reservationEntities;



    public UserEntity(UserVO uservo) {

        this.name = uservo.getName();
        this.pwd = uservo.getPwd();
        this.number = uservo.getNumber();
        this.email = uservo.getEmail();
        this.address = uservo.getAddress();
        this.imagePath = uservo.getImage();
    }
}
