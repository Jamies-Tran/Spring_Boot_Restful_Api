package com.store.dao.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.CartDAO;
import com.store.dto.CartDTO;
import com.store.interfaces.converter.IDaoConverter;
import com.store.service.IAccountService;
import com.store.service.ICartService;

@Service
@Qualifier("cart")
public class CartDaoConverter implements IDaoConverter<CartDTO, CartDAO>{

	@Autowired
	private IAccountService _accountService;
	
	@Autowired
	private ICartService _cartService;
	
	@Override
	public CartDAO Convert(CartDTO source) {
		CartDAO result = new CartDAO();
		result.setAccount(_accountService.FindById(source.getAccountId()));
		result.setComputers(_cartService.getAllCartComputer(source.getId()));
		return result;
	}
	
}
