package com.store.dto.converter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.AccountDAO;
import com.store.dto.AccountDTO;
import com.store.interfaces.converter.IDtoConverter;

@Service
@Qualifier("account")
public class AccountDtoConverter implements IDtoConverter<AccountDAO, AccountDTO> {

	@Override
	public AccountDTO Convert(AccountDAO source) {
		AccountDTO result = new AccountDTO();
		result.setId(source.getId());
		result.setUsername(source.getUsername());
		result.setPassword(source.getPassword());
		result.setBirthday(source.getBirthday());
		result.setRoleId(source.getRole().getId());
		return result;
	}

}
