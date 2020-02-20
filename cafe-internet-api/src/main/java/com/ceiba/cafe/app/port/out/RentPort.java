package com.ceiba.cafe.app.port.out;

import java.util.List;

import com.ceiba.cafe.domain.Rent;

public interface RentPort {

	Long newRent(Rent rent);

	List<Rent> getList();

	Rent getById(Long rentId);

	void update(Rent rent);

}
