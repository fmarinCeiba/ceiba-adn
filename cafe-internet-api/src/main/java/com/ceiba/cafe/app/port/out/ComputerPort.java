package com.ceiba.cafe.app.port.out;

import java.util.List;

import com.ceiba.cafe.domain.Computer;

public interface ComputerPort {

	Long newComputer(Computer computer);

	Computer getById(Long computerId);

	List<Computer> getList();

	void update(Computer computer);

	void delete(Long computerId);
}
