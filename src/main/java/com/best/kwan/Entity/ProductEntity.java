package com.best.kwan.Entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Product")
@Entity
public class ProductEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column(length = 255)
    private String productNm;

    @Column(length = 255)
    private String productExplan;

    @Column(length = 255)
    private Long  productPrice;

    @Column(length = 255)
    private int  productCnt;

    @ManyToOne
    @JoinColumn(name = "pointId")
    private PointEntity point;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<PaymentEntity> paymentEntities;


}
