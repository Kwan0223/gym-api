package com.best.kwan.Repository;

import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PointRepository extends JpaRepository<PointEntity, Long> {

    @Override
    @EntityGraph(attributePaths = {"pointImageEntities", "trainerEntities"})
    Page<PointEntity> findAll(Pageable pageable);

    Page<PointEntity> findAllByPointNameContaining(String pointName, Pageable pageable);


}
