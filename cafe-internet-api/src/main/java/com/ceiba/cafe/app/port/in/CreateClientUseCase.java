package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.command.ClientCommand;
import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Client;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateClientUseCase {

	private final ClientPort port;

	public Long create(ClientCommand command) {
		return port.newClient(Client.withoutId(command.getName(), command.getIdentification()));
	}

}
