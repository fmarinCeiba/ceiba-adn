package com.ceiba.cafe.adapter.persistence;

import java.util.ArrayList;
import java.util.List;

import com.ceiba.cafe.adapter.persistence.entity.ClientJpaEntity;
import com.ceiba.cafe.adapter.persistence.exception.NotFoundClientException;
import com.ceiba.cafe.adapter.persistence.mapper.ClientMapper;
import com.ceiba.cafe.adapter.persistence.repo.ClientRepository;
import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.common.PersistenceAdapter;
import com.ceiba.cafe.domain.Client;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@PersistenceAdapter
public class ClientPersistenceAdapter implements ClientPort {
	private static final String NOT_FOUND_CLIENT = "Cliente no encontrado";
	private final ClientRepository repository;
	private final ClientMapper mapper;

	@Override
	public Long newClient(Client client) {
		ClientJpaEntity clientJpa = mapper.mapToJpaEntity(client);
		clientJpa = repository.save(clientJpa);
		return clientJpa.getId();
	}

	@Override
	public Client getById(Long clientId) {
		ClientJpaEntity client = repository.findById(clientId)
				.orElseThrow(() -> new NotFoundClientException(ClientPersistenceAdapter.NOT_FOUND_CLIENT));
		return mapper.mapToDomainEntity(client);
	}

	@Override
	public List<Client> getList() {
		List<ClientJpaEntity> clients = repository.findAll();
		List<Client> resp = new ArrayList<>();
		clients.forEach(c -> resp.add(mapper.mapToDomainEntity(c)));
		return resp;
	}

	@Override
	public void update(Client client) {
		ClientJpaEntity clientJpa = mapper.mapToJpaEntity(client);
		repository.save(clientJpa);
	}

	@Override
	public void delete(Long clientId) {
		ClientJpaEntity client = repository.findById(clientId)
				.orElseThrow(() -> new NotFoundClientException(ClientPersistenceAdapter.NOT_FOUND_CLIENT));
		repository.delete(client);
	}

}
