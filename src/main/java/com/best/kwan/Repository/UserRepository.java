package com.best.kwan.Repository;

import com.best.kwan.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByName(String name);

    //이메일로 회원 정보 조회
    Optional<UserEntity> findByEmail(String email);

    Optional<UserEntity> findById(Long userId);



}
