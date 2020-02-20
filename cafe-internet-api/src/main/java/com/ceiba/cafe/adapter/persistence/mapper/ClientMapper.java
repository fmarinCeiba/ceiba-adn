package com.ceiba.cafe.adapter.persistence.mapper;

import org.springframework.stereotype.Component;

import com.ceiba.cafe.adapter.persistence.entity.ClientJpaEntity;
import com.ceiba.cafe.domain.Client;

@Component
public class ClientMapper {

	public Client mapToDomainEntity(ClientJpaEntity client) {
		return Client.withId(
				client.getId()
				, client.getName()
				, client.getIdentification()
			);
	}

	public ClientJpaEntity mapToJpaEntity(Client client) {
		return new ClientJpaEntity(
				client.getId() == null ? null : client.getId()
				, client.getName()
				, client.getIdentification()
			);
	}
}
