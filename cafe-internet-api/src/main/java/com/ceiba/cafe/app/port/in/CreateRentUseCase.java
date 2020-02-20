package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.command.RentCommand;
import com.ceiba.cafe.app.port.out.RentPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Rent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateRentUseCase {

	private final RentPort port;

	public Long create(RentCommand command) {
		return port.newRent(
				Rent.withoutId(command.getClientId(), command.getComputerId(), command.getStart(), command.getEnd()));
	}

}
