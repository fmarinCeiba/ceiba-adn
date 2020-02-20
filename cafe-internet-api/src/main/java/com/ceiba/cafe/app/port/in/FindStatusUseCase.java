package com.ceiba.cafe.app.port.in;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.StatusPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Status;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindStatusUseCase {

	private final StatusPort port;

	public List<Status> find(Long statusId) {
		List<Status> resp = new ArrayList<>();
		if (statusId == null) {
			resp = port.getList();
		} else {
			resp.add(port.getById(statusId));
		}
		return resp;
	}

}
