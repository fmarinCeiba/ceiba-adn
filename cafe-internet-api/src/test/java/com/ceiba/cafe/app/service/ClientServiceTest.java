package com.ceiba.cafe.app.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.ceiba.cafe.app.port.in.FindClientUseCase;
import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.domain.Client;

public class ClientServiceTest {
	private final ClientPort clientPort = Mockito.mock(ClientPort.class);

	private final FindClientUseCase findClient = new FindClientUseCase(clientPort);

	@Test
	void findAnClient() {
		List<Client> clients = findClient.find(1L);

		assertThat(clients).hasSize(1);
	}
}
