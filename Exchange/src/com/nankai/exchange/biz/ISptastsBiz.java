package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Sptasts;


public interface ISptastsBiz {
	public abstract boolean add(final Sptasts sptasts);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int said);
	public abstract Sptasts findById(final int said);
	public abstract boolean modify(final Sptasts sptasts);
}
