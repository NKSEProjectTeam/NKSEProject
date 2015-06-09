package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Decorations;

public interface IDecorationsBiz {
	
	public abstract boolean add(final Decorations decorations);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int decid);
    public abstract Decorations findById(final int decid);
    public abstract boolean modify(final Decorations decorations);

}
