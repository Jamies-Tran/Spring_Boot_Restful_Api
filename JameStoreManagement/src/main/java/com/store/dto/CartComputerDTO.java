package com.store.dto;

public class CartComputerDTO {
	private Long cartId;
	private Long computerId;

	public CartComputerDTO() {
		super();
	}

	public CartComputerDTO(Long cartId, Long computerId) {
		super();
		this.cartId = cartId;
		this.computerId = computerId;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Long getComputerId() {
		return computerId;
	}

	public void setComputerId(Long computerId) {
		this.computerId = computerId;
	}

}
