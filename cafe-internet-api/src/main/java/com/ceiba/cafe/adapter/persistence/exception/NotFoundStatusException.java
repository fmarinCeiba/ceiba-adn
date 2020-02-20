package com.ceiba.cafe.adapter.persistence.exception;

public class NotFoundStatusException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundStatusException(String message) {
		super(message);
	}
}
