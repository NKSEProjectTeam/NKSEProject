package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Cosmetics;

public interface ICosmeticsBiz {
	public abstract boolean add(final Cosmetics cosmetics);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int cosid);
    public abstract Cosmetics findById(final int cosid);
    public abstract boolean modify(final Cosmetics cosmetics);

}
