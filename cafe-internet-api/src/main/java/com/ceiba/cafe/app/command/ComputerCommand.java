package com.ceiba.cafe.app.command;

import javax.validation.constraints.NotNull;

import com.ceiba.cafe.common.SelfValidating;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ComputerCommand extends SelfValidating<ComputerCommand> {

	@NotNull
	private Long computerId;

	@NotNull
	private Long statusId;

	@NotNull
	private Long categoryId;

	@NotNull
	private String ip;

	@NotNull
	private String mac;

	@NotNull
	private String location;

	public ComputerCommand(Long computerId, Long statusId, Long categoryId, String ip, String mac, String location) {
		this.computerId = computerId;
		this.statusId = statusId;
		this.categoryId = categoryId;
		this.ip = ip;
		this.mac = mac;
		this.location = location;
		this.validateSelf();
	}
}