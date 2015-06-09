package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Males;

public interface IMalesBiz {
	
	public abstract boolean add(final Males males);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int maleid);
    public abstract Males findById(final int maleid);
    public abstract boolean modify(final Males males);

}
