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
public class UpdateCategoryUseCase {

	private final CategoryPort port;

	public Boolean update(CategoryCommand command) {
		try {
			port.update(Category.withId(command.getCategoryId(), command.getType(), command.getAmount(),
					command.getTime()));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
