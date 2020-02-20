package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.command.CategoryCommand;
import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Category;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class CreateCategoryUseCase {

	private final CategoryPort port;

	public Long create(CategoryCommand command) {
		return port.newCategory(Category.withoutId(command.getType(), command.getAmount(), command.getTime()));
	}

}
