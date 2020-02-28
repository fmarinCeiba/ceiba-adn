package com.ceiba.cafe.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ComputerTest {

	@Test
	void newDomainComputer() {
		Computer computer = new ComputerBuilder()
				.withComputerId(1L)
				.withName("normal1")
				.withStatusId(1L)
				.withCategoryId(1L)
				.withIp("192.168.10.10")
				.withMac("fe80::e554:b521:ee60:e1c9%9")
				.withLocation("arriba")
				.build();

		assertThat(computer).hasNoNullFieldsOrProperties();
	}

	public static class ComputerBuilder {

		private Long computerId;
		private String name;
		private Long statusId;
		private Long categoryId;
		private String ip;
		private String mac;
		private String location;

		public ComputerBuilder withComputerId(Long computerId) {
			this.computerId = computerId;
			return this;
		}

		public ComputerBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public ComputerBuilder withStatusId(Long statusId) {
			this.statusId = statusId;
			return this;
		}

		public ComputerBuilder withCategoryId(Long categoryId) {
			this.categoryId = categoryId;
			return this;
		}

		public ComputerBuilder withIp(String ip) {
			this.ip = ip;
			return this;
		}

		public ComputerBuilder withMac(String mac) {
			this.mac = mac;
			return this;
		}

		public ComputerBuilder withLocation(String location) {
			this.location = location;
			return this;
		}

		public Computer build() {
			return Computer.withId(this.computerId, this.name, this.statusId, this.categoryId, this.ip, this.mac,
					this.location);
		}

	}
}
