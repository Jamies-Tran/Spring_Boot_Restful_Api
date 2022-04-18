package com.store.dto.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.CartDAO;
import com.store.dto.CartDTO;
import com.store.interfaces.converter.IDtoConverter;

@Service
@Qualifier("cart")
public class CartDtoConverter implements IDtoConverter<CartDAO, CartDTO>{

	@Override
	public CartDTO Convert(CartDAO source) {
		CartDTO result = new CartDTO();
		result.setId(source.getId());
		result.setAccountId(source.getAccount().getId());
		return result;
	}

}
