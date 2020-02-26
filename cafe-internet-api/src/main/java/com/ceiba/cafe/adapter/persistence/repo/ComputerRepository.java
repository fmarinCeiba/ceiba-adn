package com.ceiba.cafe.adapter.persistence.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.cafe.adapter.persistence.entity.ComputerJpaEntity;

public interface ComputerRepository extends JpaRepository<ComputerJpaEntity, Long> {

	List<ComputerJpaEntity> findByIdStatus(Long statusId);
}
