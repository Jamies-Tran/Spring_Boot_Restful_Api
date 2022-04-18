package com.store.service;

import com.store.dao.ComputerDAO;

public interface IComputerService extends IBaseService<ComputerDAO> {
	public void Update(long Id, String chip, String vga, String hardDisk, String ram);
}
