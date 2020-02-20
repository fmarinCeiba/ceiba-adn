package com.ceiba.cafe.adapter.persistence;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import com.ceiba.cafe.adapter.persistence.mapper.ClientMapper;
import com.ceiba.cafe.domain.Client;

@DataJpaTest
@Import({ ClientPersistenceAdapter.class, ClientMapper.class })
public class ClientPersistenceAdapterTest {
	@Autowired
	private ClientPersistenceAdapter adapterUnderTest;

	@Test
	void getClient() {
		Client client = adapterUnderTest.getById(1L);

		assertThat(client.getName()).isEqualTo("francisco");
	}

	@Test
	void newClient() {
		Client jose = Client.withoutId("jose", "703046");

		Long idJose = adapterUnderTest.newClient(jose);

		Client c = adapterUnderTest.getById(idJose);

		assertThat(c.getName()).isEqualTo("jose");
	}
}
