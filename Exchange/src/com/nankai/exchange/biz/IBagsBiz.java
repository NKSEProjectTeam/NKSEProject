package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Bags;

public interface IBagsBiz {
	public abstract boolean add(final Bags bags);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int bagid);
    public abstract Bags findById(final int bagid);
    public abstract boolean modify(final Bags bags);

}
