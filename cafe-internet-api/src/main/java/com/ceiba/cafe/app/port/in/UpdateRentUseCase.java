package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceiba.cafe.app.command.RentCommand;
import com.ceiba.cafe.app.port.out.RentPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Rent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class UpdateRentUseCase {

	private final RentPort port;
	private static final Logger LOG = LoggerFactory.getLogger(UpdateRentUseCase.class);

	public Boolean update(RentCommand command) {
		try {
			port.update(Rent.withId(command.getRentId(), command.getClientId(), command.getComputerId(),
					command.getStart(), command.getEnd()));
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	}

}
