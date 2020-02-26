package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.command.ComputerCommand;
import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Computer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateComputerUseCase {

	private final ComputerPort port;

	public Long create(ComputerCommand command) {
		return port.newComputer(Computer.withoutId(command.getName(), command.getStatusId(), command.getCategoryId(),
				command.getIp(), command.getMac(), command.getLocation()));
	}

}
