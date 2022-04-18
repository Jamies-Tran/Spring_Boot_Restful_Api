package com.store.dao.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.store.dao.AccountDAO;
import com.store.dto.AccountDTO;
import com.store.interfaces.converter.IDaoConverter;
import com.store.service.IRoleService;

@Service
@Qualifier("account")
public class AccountDaoConverter implements IDaoConverter<AccountDTO, AccountDAO> {

	@Autowired
	private IRoleService _roleService;
	
	@Override
	public AccountDAO Convert(AccountDTO source) {
		AccountDAO result = new AccountDAO();
		result.setUsername(source.getUsername());
		result.setPassword(source.getPassword());
		result.setBirthday(source.getBirthday());
		result.setRole(_roleService.FindById(source.getRoleId()));
		return result;
	}

}
