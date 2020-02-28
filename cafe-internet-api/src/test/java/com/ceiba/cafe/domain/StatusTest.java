package com.ceiba.cafe.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class StatusTest {

	@Test
	void newDomainStatus() {
		Status status = new StatusBuilder()
				.withStatusId(1L)
				.withDescription("libre")
				.build();
		
		assertThat(status).hasNoNullFieldsOrProperties();
	}

	public static class StatusBuilder {

		private Long statusId;
		private String description;

		public StatusBuilder withStatusId(Long statusId) {
			this.statusId = statusId;
			return this;
		}

		public StatusBuilder withDescription(String description) {
			this.description = description;
			return this;
		}

		public Status build() {
			return Status.withId(this.statusId, this.description);
		}

	}
}
