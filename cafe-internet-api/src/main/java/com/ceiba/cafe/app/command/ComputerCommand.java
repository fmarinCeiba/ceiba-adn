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

	@NotNull(message = "computerId must not be null")
	private Long computerId;

	@NotNull(message = "name must not be null")
	private String name;

	@NotNull(message = "statusId must not be null")
	private Long statusId;

	@NotNull(message = "categoryId must not be null")
	private Long categoryId;

	@NotNull(message = "ip must not be null")
	private String ip;

	@NotNull(message = "mac must not be null")
	private String mac;

	@NotNull(message = "location must not be null")
	private String location;

	public ComputerCommand(Long computerId, String name, Long statusId, Long categoryId, String ip, String mac, String location) {
		this.computerId = computerId;
		this.name = name;
		this.statusId = statusId;
		this.categoryId = categoryId;
		this.ip = ip;
		this.mac = mac;
		this.location = location;
		this.validateSelf();
	}
}