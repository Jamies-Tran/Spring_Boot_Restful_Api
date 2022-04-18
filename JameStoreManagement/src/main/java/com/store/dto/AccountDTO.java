package com.store.dto;

public class AccountDTO {
	private long Id;
	private String username;
	private String password;
	private String birthday;
	private long roleId;
	private long cartId;

	public AccountDTO() {
		super();
	}

	public AccountDTO(long id, String username, String password, String birthday, long roleId, long cartId) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.birthday = birthday;
		this.roleId = roleId;
		this.cartId = cartId;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

}
