package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.UseCase;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteComputerUseCase {

	private final ComputerPort port;

	public Boolean delete(Long computerId) {
		try {
			port.delete(computerId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
