package com.store.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Id;

@Entity(name = "Role")
public class RoleDAO {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long Id;
	
	@Column
	private String name;
	
	@OneToMany(mappedBy = "role" ,fetch = FetchType.EAGER)
	private List<AccountDAO> accounts = new ArrayList<>();

	public RoleDAO() {
		super();
	}

	public RoleDAO(long Id, String name) {
		super();
		this.Id = Id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AccountDAO> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<AccountDAO> accounts) {
		this.accounts = accounts;
	}

	public long getId() {
		return Id;
	}
}
