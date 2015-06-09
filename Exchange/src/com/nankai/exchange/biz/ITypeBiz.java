package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Type;


public interface ITypeBiz {
	public abstract boolean add(final Type type);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int typeid);
	public abstract Type findById(final int typeid);
	public abstract boolean modify(final Type type);
}
