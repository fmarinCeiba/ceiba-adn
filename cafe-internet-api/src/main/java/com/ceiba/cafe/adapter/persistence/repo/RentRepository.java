package com.ceiba.cafe.adapter.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.cafe.adapter.persistence.entity.RentJpaEntity;

public interface RentRepository extends JpaRepository<RentJpaEntity, Long> {
}
