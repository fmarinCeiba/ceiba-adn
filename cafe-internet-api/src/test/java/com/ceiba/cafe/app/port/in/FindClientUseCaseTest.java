package com.ceiba.cafe.app.port.in;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.cafe.app.port.in.FindClientUseCase;
import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.domain.Client;

public class FindClientUseCaseTest {
	private final ClientPort clientPort = Mockito.mock(ClientPort.class);

	private final FindClientUseCase findClient = new FindClientUseCase(clientPort);

	@Test
	void findAClient() {
		Long idClient = 1L;

		Client client = Client.withId(idClient, "francisco", "703045");
		when(clientPort.getById(idClient)).thenReturn(client);

		Client clientBD = findClient.find(client.getId()).get(0);

		assertThat(clientBD).isEqualTo(client);
	}

	@Test
	void findAllClient() {
		List<Client> clients = new ArrayList<>();
		clients.add(Client.withoutId("francisco", "703045"));
		clients.add(Client.withoutId("jose", "703046"));
		when(clientPort.getList()).thenReturn(clients);

		List<Client> clientsBD = findClient.find(null);

		assertThat(clients.size()).isEqualTo(clientsBD.size());
		assertThat(clientsBD.get(0).getName()).isEqualTo("francisco");
		assertThat(clientsBD.get(1).getName()).isEqualTo("jose");
	}
}
