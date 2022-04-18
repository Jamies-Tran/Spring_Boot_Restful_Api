package com.store.service;

import com.store.dao.AccountDAO;
import com.store.dao.RoleDAO;

public interface IAccountService extends IBaseService<AccountDAO>{
	public void Update(long Id ,String username, String password, String birthday, long role);
}
