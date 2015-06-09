package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Spteqpts;


public interface ISpteqptsBiz {
	public abstract boolean add(final Spteqpts spteqpts);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int seid);
	public abstract Spteqpts findById(final int seid);
	public abstract boolean modify(final Spteqpts spteqpts);
}
