package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.common.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteClientUseCase {

	private final ClientPort port;
	private static final Logger LOG = LoggerFactory.getLogger(DeleteClientUseCase.class);

	public Boolean delete(Long clientId) {
		try {
			port.delete(clientId);
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	}

}
