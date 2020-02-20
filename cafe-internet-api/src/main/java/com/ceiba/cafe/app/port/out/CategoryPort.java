package com.ceiba.cafe.app.port.out;

import java.util.List;

import com.ceiba.cafe.domain.Category;

public interface CategoryPort {

	Long newCategory(Category category);

	List<Category> getList();

	Category getById(Long categoryId);

	void update(Category category);

	void delete(Long categoryId);

}
