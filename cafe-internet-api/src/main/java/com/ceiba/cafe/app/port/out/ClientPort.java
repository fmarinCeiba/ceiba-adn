package com.ceiba.cafe.app.port.out;

import java.util.List;

import com.ceiba.cafe.domain.Client;

public interface ClientPort {

	Long newClient(Client client);

	List<Client> getList();

	Client getById(Long clientId);

	void update(Client client);

	void delete(Long clientId);

}
