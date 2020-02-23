package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteComputerUseCase {

	private final ComputerPort port;
	private static final Logger LOG = LoggerFactory.getLogger(DeleteComputerUseCase.class);

	public Boolean delete(Long computerId) {
		try {
			port.delete(computerId);
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	}

}
