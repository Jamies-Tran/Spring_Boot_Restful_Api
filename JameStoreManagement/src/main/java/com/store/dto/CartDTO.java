package com.store.dto;

public class CartDTO {
	private long Id;
	private long accountId;

	public CartDTO() {
		super();
	}

	public CartDTO(long id, long accountId) {
		super();
		Id = id;
		this.accountId = accountId;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

}
