package com.ceiba.cafe.adapter.persistence.exception;

public class NotFoundComputerException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundComputerException(String message) {
		super(message);
	}
}
