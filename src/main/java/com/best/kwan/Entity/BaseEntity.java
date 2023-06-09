package com.best.kwan.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
public class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createAt;
    @UpdateTimestamp
    protected LocalDateTime updateAt;
}
