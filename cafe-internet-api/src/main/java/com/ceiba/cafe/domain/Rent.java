package com.ceiba.cafe.domain;

import java.time.LocalDateTime;

public class Rent {

	private Long id;

	private Long clientId;

	private Long computerId;

	private Boolean active;

	private LocalDateTime start;

	private LocalDateTime end;

	public Rent(Long rentId, Long clientId, Long computerId, Boolean active, LocalDateTime start, LocalDateTime end) {
		this.id = rentId;
		this.clientId = clientId;
		this.computerId = computerId;
		this.active = active;
		this.start = start;
		this.end = end;
	}

	public Long getId() {
		return id;
	}

	public Long getClientId() {
		return clientId;
	}

	public Long getComputerId() {
		return computerId;
	}

	public Boolean getActive() {
		return active;
	}

	public LocalDateTime getStart() {
		return start;
	}

	public LocalDateTime getEnd() {
		return end;
	}

	public static Rent withId(Long rentId, Long clientId, Long computerId, Boolean active, LocalDateTime start, LocalDateTime end) {
		return new Rent(rentId, clientId, computerId, active, start, end);
	}

	public static Rent withoutId(Long clientId, Long computerId, Boolean active, LocalDateTime start, LocalDateTime end) {
		return new Rent(null, clientId, computerId, active, start, end);
	}

}
