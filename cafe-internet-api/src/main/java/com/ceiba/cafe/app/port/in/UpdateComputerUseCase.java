package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceiba.cafe.app.command.ComputerCommand;
import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Computer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class UpdateComputerUseCase {

	private final ComputerPort port;
	private static final Logger LOG = LoggerFactory.getLogger(UpdateComputerUseCase.class);

	public Boolean update(ComputerCommand command) {
		try {
			port.update(Computer.withId(command.getComputerId(), command.getName(), command.getStatusId(), command.getCategoryId(),
					command.getIp(), command.getMac(), command.getLocation()));
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	}

}
