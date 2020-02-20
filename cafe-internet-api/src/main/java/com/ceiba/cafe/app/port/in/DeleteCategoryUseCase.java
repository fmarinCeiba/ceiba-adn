package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.common.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteCategoryUseCase {

	private final CategoryPort port;

	public Boolean delete(Long categoryId) {
		try {
			port.delete(categoryId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
