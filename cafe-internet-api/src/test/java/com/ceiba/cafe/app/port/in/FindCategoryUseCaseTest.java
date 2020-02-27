package com.ceiba.cafe.app.port.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.domain.Category;

public class FindCategoryUseCaseTest {
	private final CategoryPort categoryPort = Mockito.mock(CategoryPort.class);

	private final FindCategoryUseCase findCategory = new FindCategoryUseCase(categoryPort);

	@Test
	void findACategory() {
		Long idCategory = 1L;

		Category category = Category.withId(idCategory, "normal", 2000L, 60L);
		when(categoryPort.getById(idCategory)).thenReturn(category);

		Category categoryBD = findCategory.find(category.getId()).get(0);

		assertThat(categoryBD).isEqualTo(category);
	}

	@Test
	void findAllCategories() {
		List<Category> categories = new ArrayList<>();
		categories.add(Category.withoutId("normal", 2000L, 60L));
		categories.add(Category.withoutId("gamer", 4000L, 60L));
		when(categoryPort.getList()).thenReturn(categories);

		List<Category> categoriesBD = findCategory.find(null);

		assertThat(categories.size()).isEqualTo(categoriesBD.size());
		assertThat(categoriesBD.get(0).getType()).isEqualTo("normal");
		assertThat(categoriesBD.get(1).getType()).isEqualTo("gamer");
	}
}
