package com.store.service;

import java.util.List;

public interface IBaseService<T> {
	
	public T FindById(long Id);
	
	public T Insert(T input);
	
	public String Delete(long Id);
	
	public List<T> FindAll();
	
}
