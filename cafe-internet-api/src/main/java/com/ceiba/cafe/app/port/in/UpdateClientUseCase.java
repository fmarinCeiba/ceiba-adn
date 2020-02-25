package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import org.hibernate.HibernateError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	private static final Logger LOG = LoggerFactory.getLogger(UpdateClientUseCase.class);

	public Boolean update(ClientCommand command) {
		try {
			port.update(Client.withId(command.getClientId(), command.getName(), command.getIdentification()));
			return true;
		} catch (HibernateError e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	}

}
