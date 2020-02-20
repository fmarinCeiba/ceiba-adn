package com.ceiba.cafe.adapter.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ceiba.cafe.adapter.persistence.entity.CategoryJpaEntity;

public interface CategoryRepository extends JpaRepository<CategoryJpaEntity, Long> {
}
