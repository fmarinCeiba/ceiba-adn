package com.ceiba.cafe.app.command;

import javax.validation.constraints.NotNull;

import com.ceiba.cafe.common.SelfValidating;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CategoryCommand extends SelfValidating<CategoryCommand> {

	@NotNull(message = "categoryId must not be null")
	private Long categoryId;

	@NotNull(message = "type must not be null")
	private String type;

	@NotNull(message = "amount must not be null")
	private Long amount;

	@NotNull(message = "time must not be null")
	private Long time;

	public CategoryCommand(Long categoryId, String type, Long amount, Long time) {
		this.categoryId = categoryId;
		this.type = type;
		this.amount = amount;
		this.time = time;
		this.validateSelf();
	}
}
