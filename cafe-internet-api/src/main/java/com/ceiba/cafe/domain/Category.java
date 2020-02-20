package com.ceiba.cafe.domain;

public class Category {

	private final Long id;

	private final String type;

	private final Long amount;

	private final Long time;

	public Category(Long categoryId, String type, Long amount, Long time) {
		this.id = categoryId;
		this.type = type;
		this.amount = amount;
		this.time = time;
	}

	public Long getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public Long getAmount() {
		return amount;
	}

	public Long getTime() {
		return time;
	}

	public static Category withId(Long categoryId, String type, Long amount, Long time) {
		return new Category(categoryId, type, amount, time);
	}

	public static Category withoutId(String type, Long amount, Long time) {
		return new Category(null, type, amount, time);
	}

}
