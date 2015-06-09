package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Phones;


public interface IPhonesBiz {
	public abstract boolean add(final Phones phones);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int phoneid);
	public abstract Phones findById(final int phoneid);
	public abstract boolean modify(final Phones phones);
}
