package com.store.service;

import java.util.List;

import com.store.dao.ComputerDAO;

public interface ICartService {
	public void addToCart(long cartId, long compId);
	
	public void removeFromCart(long cartId, long compId);
	
	public List<ComputerDAO> getAllCartComputer(long cartId);
}
