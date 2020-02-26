package com.ceiba.cafe.domain;

public class Computer {
	private final Long id;

	private final String name;

	private final Long statusId;

	private final Long categoryId;

	private final String ip;

	private final String mac;

	private final String location;

	public Computer(Long computerId, String name, Long statusId, Long categoryId, String ip, String mac,
			String location) {
		this.id = computerId;
		this.name = name;
		this.statusId = statusId;
		this.categoryId = categoryId;
		this.ip = ip;
		this.mac = mac;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getStatusId() {
		return statusId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public String getIp() {
		return ip;
	}

	public String getMac() {
		return mac;
	}

	public String getLocation() {
		return location;
	}

	public static Computer withId(Long computerId, String name, Long statusId, Long categoryId, String ip, String mac,
			String location) {
		return new Computer(computerId, name, statusId, categoryId, ip, mac, location);
	}

	public static Computer withoutId(String name, Long statusId, Long categoryId, String ip, String mac,
			String location) {
		return new Computer(null, name, statusId, categoryId, ip, mac, location);
	}
}
