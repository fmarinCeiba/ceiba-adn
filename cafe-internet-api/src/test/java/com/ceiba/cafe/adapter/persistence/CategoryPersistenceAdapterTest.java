package com.ceiba.cafe.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.ceiba.cafe.adapter.persistence.mapper.CategoryMapper;
import com.ceiba.cafe.domain.Category;

@DataJpaTest
@Import({ CategoryPersistenceAdapter.class, CategoryMapper.class })
public class CategoryPersistenceAdapterTest {
	@Autowired
	private CategoryPersistenceAdapter adapterUnderTest;

	@Test
	void getCategory() {
		Category category = adapterUnderTest.getById(1L);

		assertThat(category.getType()).isEqualTo("normal");
	}
	
	@Test
	void getCategories() {
		List<Category> categories = adapterUnderTest.getList();

		assertThat(categories).hasSize(8);
		assertThat(categories.get(0).getType()).isEqualTo("normal");
	}

	@Test
	void newCategory() {
		Category jose = Category.withoutId("normal", 2000L, 60L);

		Long idNormal = adapterUnderTest.newCategory(jose);

		Category c = adapterUnderTest.getById(idNormal);

		assertThat(c.getType()).isEqualTo("normal");
	}

	@Test
	void updateCategory() {
		Category category = adapterUnderTest.getById(1L);

		category = Category.withId(category.getId(), "normal", 2000L, 60L);

		adapterUnderTest.update(category);

		Category c = adapterUnderTest.getById(category.getId());

		assertThat(c.getType()).isEqualTo("normal");
	}
}
