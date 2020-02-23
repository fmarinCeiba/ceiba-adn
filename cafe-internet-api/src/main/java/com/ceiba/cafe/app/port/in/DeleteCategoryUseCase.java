package com.ceiba.cafe.app.port.in;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ceiba.cafe.app.port.out.CategoryPort;
import com.ceiba.cafe.common.UseCase;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
@Transactional
public class DeleteCategoryUseCase {

	private final CategoryPort port;
	private static final Logger LOG = LoggerFactory.getLogger(DeleteCategoryUseCase.class);

	public Boolean delete(Long categoryId) {
		try {
			port.delete(categoryId);
			return true;
		} catch (Exception e) {
			LOG.error(e.getLocalizedMessage(), e);
			return false;
		}
	}

}
