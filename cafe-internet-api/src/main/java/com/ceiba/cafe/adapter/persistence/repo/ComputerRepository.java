package com.ceiba.cafe.adapter.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.cafe.adapter.persistence.entity.ComputerJpaEntity;

public interface ComputerRepository extends JpaRepository<ComputerJpaEntity, Long> {
}
