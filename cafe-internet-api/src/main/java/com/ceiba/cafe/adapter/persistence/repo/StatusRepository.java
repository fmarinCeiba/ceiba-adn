package com.ceiba.cafe.adapter.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.cafe.adapter.persistence.entity.StatusJpaEntity;

public interface StatusRepository extends JpaRepository<StatusJpaEntity, Long> {
}
