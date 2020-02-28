package com.ceiba.cafe.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDateTime;

public class RentTest {

	@Test
	void newDomainRent() {
		Rent rent = new RentBuilder()
				.withRentId(1L)
				.withClientId(1L)
				.withComputerId(1L)
				.withActive(true)
				.withStart(LocalDateTime.now())
				.withEnd(LocalDateTime.now())
				.build();

		assertThat(rent).hasNoNullFieldsOrProperties();
	}

	public static class RentBuilder {

		private Long rentId;
		private Long clientId;
		private Long computerId;
		private Boolean active;
		private LocalDateTime start;
		private LocalDateTime end;

		public RentBuilder withRentId(Long rentId) {
			this.rentId = rentId;
			return this;
		}

		public RentBuilder withClientId(Long clientId) {
			this.clientId = clientId;
			return this;
		}

		public RentBuilder withComputerId(Long computerId) {
			this.computerId = computerId;
			return this;
		}

		public RentBuilder withActive(Boolean active) {
			this.active = active;
			return this;
		}

		public RentBuilder withStart(LocalDateTime start) {
			this.start = start;
			return this;
		}

		public RentBuilder withEnd(LocalDateTime end) {
			this.end = end;
			return this;
		}

		public Rent build() {
			return Rent.withId(this.rentId, this.clientId, this.computerId, this.active, this.start, this.end);
		}

	}
}
