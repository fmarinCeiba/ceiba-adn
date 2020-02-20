package com.ceiba.cafe.adapter.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.cafe.adapter.persistence.entity.ClientJpaEntity;

public interface ClientRepository extends JpaRepository<ClientJpaEntity, Long> {
}
