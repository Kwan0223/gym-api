package com.best.kwan.Repository;

import com.best.kwan.Entity.PointEntity;
import com.best.kwan.Entity.TrainerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainerRepository extends JpaRepository<TrainerEntity, Long> {



}
