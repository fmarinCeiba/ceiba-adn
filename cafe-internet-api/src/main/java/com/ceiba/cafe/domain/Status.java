package com.ceiba.cafe.domain;

public class Status {

	private Long id;

	private String description;

	public Status(Long statusId, String description) {
		this.id = statusId;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public static Status withId(Long statusId, String description) {
		return new Status(statusId, description);
	}

	public static Status withoutId(String description) {
		return new Status(null, description);
	}

}
