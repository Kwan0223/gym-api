package com.best.kwan.vo;

import com.best.kwan.Entity.PaymentEntity;
import com.best.kwan.Entity.ReservationEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentVO {

    private Long paymentId;
    private int cnt;
    private Long amount;
    private LocalDateTime payDate;
    private Long productId;
    private Long userId;
    private List<String> reservationList;

    public PaymentVO(PaymentEntity paymentEntity) {
        this.paymentId = paymentEntity.getPaymentId();
        this.cnt = paymentEntity.getCnt();
        this.amount = paymentEntity.getAmount();
        this.payDate = paymentEntity.getPayDate();

        if (paymentEntity.getProduct() != null) {
            this.productId = paymentEntity.getProduct().getProductId();
        }

        if (paymentEntity.getUser() != null) {
            this.userId = paymentEntity.getUser().getId();
        }

        if (paymentEntity.getReservationEntities() != null) {
            this.reservationList = paymentEntity.getReservationEntities().stream()
                    .map(reservationEntity -> reservationEntity.toString())
                    .collect(Collectors.toList());
        }
    }
}
