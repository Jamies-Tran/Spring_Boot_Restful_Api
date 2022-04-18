package com.store.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.dao.CartDAO;
import com.store.dao.ComputerDAO;
import com.store.repository.ICartRepository;
import com.store.service.ICartService;

@Service
public class CartService implements ICartService{

	@Autowired
	private ICartRepository _repo;
	
	@Override
	public void addToCart(long cartId, long compId) {
		_repo.addToCart(cartId, compId);
		
	}

	@Override
	public void removeFromCart(long cartId, long compId) {
		_repo.removeFromCart(cartId, compId);
		
	}

	@Override
	public List<ComputerDAO> getAllCartComputer(long cartId) {
		Optional<CartDAO> cart = _repo.findById(cartId);
		if(cart.isPresent()) {
			return cart.get().getComputers();
		} else {
			return null;
		}
	}

}
