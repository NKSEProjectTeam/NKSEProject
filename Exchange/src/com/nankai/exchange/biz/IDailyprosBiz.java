package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Dailypros;

public interface IDailyprosBiz {
	public abstract boolean add(final Dailypros dailypro);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int dpid);
    public abstract Dailypros findById(final int dpid);
    public abstract boolean modify(final Dailypros dailypro);

}
