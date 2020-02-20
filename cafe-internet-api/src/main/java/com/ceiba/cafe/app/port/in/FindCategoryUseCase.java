package com.ceiba.cafe.app.port.in;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.common.UseCase;
import com.ceiba.cafe.domain.Category;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class FindCategoryUseCase {

	private final CategoryPort port;

	public List<Category> find(Long categoryId) {
		List<Category> resp = new ArrayList<>();
		if (categoryId == null) {
			resp = port.getList();
		} else {
			resp.add(port.getById(categoryId));
		}
		return resp;
	}

}
