package com.ceiba.cafe.app.port.in;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.ClientPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Client;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@UseCase
@Transactional
public class FindClientUseCase {

	private final ClientPort port;

	public List<Client> find(Long clientId) {
		List<Client> resp = new ArrayList<>();
		if (clientId == null) {
			resp = port.getList();
		} else {
			resp.add(port.getById(clientId));
		}
		return resp;
	}

}
