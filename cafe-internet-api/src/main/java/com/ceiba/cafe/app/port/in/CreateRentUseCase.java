package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.command.RentCommand;
import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.app.port.out.RentPort;
import com.ceiba.cafe.app.port.out.StatusPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Computer;
import com.ceiba.cafe.domain.Rent;
import com.ceiba.cafe.domain.Status;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateRentUseCase {

	private final RentPort port;
	private final ComputerPort portComputer;
	private final StatusPort portEstatus;

	public Long create(RentCommand command) {
		Status s = portEstatus.getByName("ocupado");
		Computer c = portComputer.getById(command.getComputerId());
		portComputer.update(Computer.withId(c.getId(), c.getName(), s.getId(), c.getCategoryId(), c.getIp(), c.getMac(), c.getLocation()));
		return port.newRent(
				Rent.withoutId(command.getClientId(), command.getComputerId(), command.getActive(), command.getStart(), command.getEnd()));
	}

}
