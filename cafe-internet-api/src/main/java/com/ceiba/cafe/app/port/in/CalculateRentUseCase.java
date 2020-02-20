package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.app.port.out.ComputerPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Category;
import com.ceiba.cafe.domain.Computer;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CalculateRentUseCase {

	private final ComputerPort computerPort;
	private final CategoryPort categoryPort;

	public Long time(Long computerId, Long amount) {
		Computer computer = computerPort.getById(computerId);
		Category category = categoryPort.getById(computer.getCategoryId());
		return ((category.getTime() * amount) / category.getAmount());
	}

	public Long amount(Long computerId, Long time) {
		Computer computer = computerPort.getById(computerId);
		Category category = categoryPort.getById(computer.getCategoryId());
		return ((category.getAmount() * time) / category.getTime());
	}

}
