package com.ceiba.cafe.app.command;

import java.time.LocalDateTime;

import javax.validation.constraints.NotNull;

import com.ceiba.cafe.common.SelfValidating;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RentCommand extends SelfValidating<RentCommand> {

	@NotNull(message = "rentId must not be null")
	private Long rentId;

	@NotNull(message = "clientId must not be null")
	private Long clientId;

	@NotNull(message = "computerId must not be null")
	private Long computerId;

	@NotNull(message = "active must not be null")
	private Boolean active;

	@NotNull(message = "start must not be null")
	private LocalDateTime start;

	@NotNull(message = "end must not be null")
	private LocalDateTime end;

	public RentCommand(Long rentId, Long clientId, Long computerId, Boolean active, LocalDateTime start, LocalDateTime end) {
		this.rentId = rentId;
		this.clientId = clientId;
		this.computerId = computerId;
		this.active = active;
		this.start = start;
		this.end = end;
		this.validateSelf();
	}
}
