package com.ceiba.cafe.adapter.persistence.exception;

public class NotFoundCategoryException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundCategoryException(String message) {
		super(message);
	}
}
