package com.ceiba.cafe.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ClientTest {

	@Test
	void newDomainClient() {
		Client client = new ClientBuilder()
				.withClientId(1L)
				.withName("jose")
				.withIdentification("703046")
				.build();
		
		assertThat(client).hasNoNullFieldsOrProperties();
	}

	public static class ClientBuilder {

		private Long clientId;
		private String name;
		private String identification;

		public ClientBuilder withClientId(Long clientId) {
			this.clientId = clientId;
			return this;
		}

		public ClientBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public ClientBuilder withIdentification(String identification) {
			this.identification = identification;
			return this;
		}

		public Client build() {
			return Client.withId(this.clientId, this.name, this.identification);
		}

	}
}
