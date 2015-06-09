package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Entertainments;

public interface IEntertainmentsBiz {
	public abstract boolean add(final Entertainments entertainments);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int enterid);
    public abstract Entertainments findById(final int enterid);
    public abstract boolean modify(final Entertainments entertainments);

}
