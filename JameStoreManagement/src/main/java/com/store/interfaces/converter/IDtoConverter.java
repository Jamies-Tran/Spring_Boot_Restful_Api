package com.store.interfaces.converter;

public interface IDtoConverter<S, T> {
	public T Convert(S source);
}
