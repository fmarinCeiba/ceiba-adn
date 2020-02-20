package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.common.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteClientUseCase {

	private final ClientPort port;

	public Boolean delete(Long clientId) {
		try {
			port.delete(clientId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
