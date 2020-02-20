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

	@NotNull
	private Long rentId;

	@NotNull
	private Long clientId;

	@NotNull
	private Long computerId;

	@NotNull
	private LocalDateTime start;

	@NotNull
	private LocalDateTime end;

	public RentCommand(Long rentId, Long clientId, Long computerId, LocalDateTime start, LocalDateTime end) {
		this.rentId = rentId;
		this.clientId = clientId;
		this.computerId = computerId;
		this.start = start;
		this.end = end;
		this.validateSelf();
	}
}
