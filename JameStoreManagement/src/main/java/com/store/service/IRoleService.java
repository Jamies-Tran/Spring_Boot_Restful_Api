package com.store.service;

import com.store.dao.RoleDAO;

public interface IRoleService extends IBaseService<RoleDAO> {
	public void Update(long Id, String name);
}
