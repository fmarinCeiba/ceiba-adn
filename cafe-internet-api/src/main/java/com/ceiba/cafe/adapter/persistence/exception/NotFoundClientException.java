package com.ceiba.cafe.adapter.persistence.exception;

public class NotFoundClientException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NotFoundClientException(String message) {
		super(message);
	}
}
