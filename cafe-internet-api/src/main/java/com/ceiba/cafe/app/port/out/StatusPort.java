package com.ceiba.cafe.app.port.out;

import java.util.List;

import com.ceiba.cafe.domain.Status;

public interface StatusPort {
	Status getById(Long statusId);

	Status getByName(String name);

	List<Status> getList();
}
