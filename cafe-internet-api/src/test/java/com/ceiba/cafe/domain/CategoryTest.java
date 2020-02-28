package com.ceiba.cafe.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class CategoryTest {

	@Test
	void newDomainCategory() {
		Category category = new CategoryBuilder()
				.withCategoryId(1L)
				.withType("jose")
				.withAmount(2000L)
				.withTime(60L)
				.build();

		assertThat(category).hasNoNullFieldsOrProperties();
	}

	public static class CategoryBuilder {

		private Long categoryId;
		private String type;
		private Long amount;
		private Long time;

		public CategoryBuilder withCategoryId(Long categoryId) {
			this.categoryId = categoryId;
			return this;
		}

		public CategoryBuilder withType(String type) {
			this.type = type;
			return this;
		}

		public CategoryBuilder withAmount(Long amount) {
			this.amount = amount;
			return this;
		}

		public CategoryBuilder withTime(Long time) {
			this.time = time;
			return this;
		}

		public Category build() {
			return Category.withId(this.categoryId, this.type, this.amount, this.time);
		}

	}
}
