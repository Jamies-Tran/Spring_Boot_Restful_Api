package com.store.interfaces.converter;

public interface IDaoConverter<S, T> {
	public T Convert(S source);
}
