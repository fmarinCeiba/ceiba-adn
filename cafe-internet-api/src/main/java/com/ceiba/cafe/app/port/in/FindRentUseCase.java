package com.ceiba.cafe.app.port.in;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.RentPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Rent;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindRentUseCase {

	private final RentPort port;

	public List<Rent> find(Long rentId) {
		List<Rent> resp = new ArrayList<>();
		if (rentId == null) {
			resp = port.getList();
		} else {
			resp.add(port.getById(rentId));
		}
		return resp;
	}

}
