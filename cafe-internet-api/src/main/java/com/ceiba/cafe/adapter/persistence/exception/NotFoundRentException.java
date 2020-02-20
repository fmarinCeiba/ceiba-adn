package com.ceiba.cafe.adapter.persistence.exception;

public class NotFoundRentException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundRentException(String message) {
		super(message);
	}
}
