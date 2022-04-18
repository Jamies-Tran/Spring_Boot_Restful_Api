package com.store.dao;

import javax.persistence.*;

@Entity(name = "Account")
public class AccountDAO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;

	@Column(length = 20, nullable = false)
	private String username;

	@Column(length = 10, nullable = false)
	private String password;

	@Column
	private String birthday;

	@ManyToOne(fetch = FetchType.EAGER)
	private RoleDAO role;
	
	@OneToOne(mappedBy = "account",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private CartDAO cart;

	public AccountDAO() {
		super();
	}

	public AccountDAO(Long Id, String username, String password, String birthday, RoleDAO role, CartDAO cart) {
		super();
		this.Id = Id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.role = role;
		this.cart = cart;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public RoleDAO getRole() {
		return role;
	}

	public void setRole(RoleDAO role) {
		this.role = role;
	}

	public CartDAO getCart() {
		return cart;
	}

	public void setCart(CartDAO cart) {
		this.cart = cart;
	}

	public long getId() {
		return Id;
	}
}
