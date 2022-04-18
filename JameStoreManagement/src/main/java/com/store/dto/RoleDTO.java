package com.store.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {
	private long Id;
	private String name;
	private List<AccountDTO> accounts = new ArrayList<>();

	public RoleDTO() {
		super();
	}

	public RoleDTO(long id, String name) {
		super();
		Id = id;
		this.name = name;
	}

	public RoleDTO(long id, String name, List<AccountDTO> accounts) {
		super();
		Id = id;
		this.name = name;
		this.accounts = accounts;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDTO> accounts) {
		this.accounts = accounts;
	}

}
