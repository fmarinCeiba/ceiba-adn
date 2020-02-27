package com.ceiba.cafe.app.port.in;

import java.util.List;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Computer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindComputerUseCase {

	private final ComputerPort port;

	public List<Computer> find(Long statusId) {
		if (statusId == null) {
			return port.getList();
		} else {
			return port.getByStatusId(statusId);
		}
	}

}
