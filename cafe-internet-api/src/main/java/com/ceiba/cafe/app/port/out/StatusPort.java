package com.ceiba.cafe.app.port.out;

import java.util.List;

import com.ceiba.cafe.domain.Status;

public interface StatusPort {
	Status getById(Long statusId);

	List<Status> getList();
}
