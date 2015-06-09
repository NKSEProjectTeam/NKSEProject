package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Extrabooks;

public interface IExtrabooksBiz {

	public abstract boolean add(final Extrabooks extrabooks);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int ebid);
    public abstract Extrabooks findById(final int ebid);
    public abstract boolean modify(final Extrabooks extrabooks);
}
