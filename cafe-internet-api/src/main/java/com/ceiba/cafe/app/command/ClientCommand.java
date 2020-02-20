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

	@NotNull
	private Long clientId;

	@NotNull
	private String name;

	@NotNull
	private String identification;

	public ClientCommand(Long clientId, String name, String identification) {
		this.clientId = clientId;
		this.name = name;
		this.identification = identification;
		this.validateSelf();
	}
}
