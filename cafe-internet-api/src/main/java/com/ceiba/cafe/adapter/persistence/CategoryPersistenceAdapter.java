package com.ceiba.cafe.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cafe.adapter.persistence.entity.CategoryJpaEntity;
import com.ceiba.cafe.adapter.persistence.exception.NotFoundCategoryException;
import com.ceiba.cafe.adapter.persistence.mapper.CategoryMapper;
import com.ceiba.cafe.adapter.persistence.repo.CategoryRepository;
import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.common.PersistenceAdapter;
import com.ceiba.cafe.domain.Category;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class CategoryPersistenceAdapter implements CategoryPort {
	private static final String NOT_FOUND_CATEGORY = "Categoria no encontrada";
	private final CategoryRepository repository;
	private final CategoryMapper mapper;

	@Override
	public Long newCategory(Category category) {
		CategoryJpaEntity categoryJpa = mapper.mapToJpaEntity(category);
		categoryJpa = repository.save(categoryJpa);
		return categoryJpa.getId();
	}

	@Override
	public Category getById(Long categoryId) {
		CategoryJpaEntity category = repository.findById(categoryId)
				.orElseThrow(() -> new NotFoundCategoryException(CategoryPersistenceAdapter.NOT_FOUND_CATEGORY));
		return mapper.mapToDomainEntity(category);
	}

	@Override
	public List<Category> getList() {
		List<CategoryJpaEntity> categorys = repository.findAll();
		List<Category> resp = new ArrayList<>();
		categorys.forEach(c -> resp.add(mapper.mapToDomainEntity(c)));
		return resp;
	}

	@Override
	public void update(Category category) {
		CategoryJpaEntity categoryJpa = mapper.mapToJpaEntity(category);
		repository.save(categoryJpa);
	}

	@Override
	public void delete(Long categoryId) {
		CategoryJpaEntity category = repository.findById(categoryId)
				.orElseThrow(() -> new NotFoundCategoryException(CategoryPersistenceAdapter.NOT_FOUND_CATEGORY));
		repository.delete(category);
	}

}
