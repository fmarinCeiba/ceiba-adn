package com.ceiba.cafe.domain;

public class Client {

	private final Long id;

	private final String name;

	private final String identification;

	public Client(Long clientId, String name, String identification) {
		this.id = clientId;
		this.name = name;
		this.identification = identification;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getIdentification() {
		return identification;
	}

	public static Client withId(Long clientId, String name, String identification) {
		return new Client(clientId, name, identification);
	}

	public static Client withoutId(String name, String identification) {
		return new Client(null, name, identification);
	}

}
