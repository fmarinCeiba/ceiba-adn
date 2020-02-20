package com.ceiba.cafe.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.cafe.adapter.persistence.entity.CategoryJpaEntity;
import com.ceiba.cafe.domain.Category;

@Component
public class CategoryMapper {

	public Category mapToDomainEntity(CategoryJpaEntity category) {
		return Category.withId(
				category.getId()
				, category.getType()
				, category.getAmount()
				, category.getTime()
			);
	}

	public CategoryJpaEntity mapToJpaEntity(Category category) {
		return new CategoryJpaEntity(
				category.getId() == null ? null : category.getId()
				, category.getType()
				, category.getAmount()
				, category.getTime()
			);
	}
}
