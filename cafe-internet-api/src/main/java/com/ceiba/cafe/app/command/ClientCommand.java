package com.ceiba.cafe.app.command;

import javax.validation.constraints.NotNull;

import com.ceiba.cafe.common.SelfValidating;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ClientCommand extends SelfValidating<ClientCommand> {

	@NotNull(message = "clientId must not be null")
	private Long clientId;

	@NotNull(message = "name must not be null")
	private String name;

	@NotNull(message = "identification must not be null")
	private String identification;

	public ClientCommand(Long clientId, String name, String identification) {
		this.clientId = clientId;
		this.name = name;
		this.identification = identification;
		this.validateSelf();
	}
}
