package com.ceiba.cafe.adapter.web.exception;

import java.util.Date;

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = (Date) timestamp.clone();
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return (Date) timestamp.clone();
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}
}