package com.store.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity(name = "Cart")
public class CartDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
	@JoinColumn(name = "account_id", referencedColumnName = "Id")
	private AccountDAO account;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "cart_computer", 
				joinColumns = @JoinColumn(name = "cart_id"),
				inverseJoinColumns = @JoinColumn(name = "comp_id"))
	private List<ComputerDAO> computers = new ArrayList<>();
	
	public CartDAO() {
		super();
	}

	public CartDAO(long Id, AccountDAO account) {
		super();
		this.Id = Id;
		this.account = account;
	}

	public long getId() {
		return Id;
	}


	public AccountDAO getAccount() {
		return account;
	}

	public void setAccount(AccountDAO account) {
		this.account = account;
	}

	public List<ComputerDAO> getComputers() {
		return computers;
	}

	public void setComputers(List<ComputerDAO> computers) {
		this.computers = computers;
	}
	
	
}
