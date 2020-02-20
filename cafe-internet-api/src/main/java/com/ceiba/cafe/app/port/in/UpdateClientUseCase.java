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
public class UpdateClientUseCase {

	private final ClientPort port;

	public Boolean update(ClientCommand command) {
		try {
			port.update(Client.withId(command.getClientId(), command.getName(), command.getIdentification()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
