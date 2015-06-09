package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Others;


public interface IOthersBiz {
	public abstract boolean add(final Others others);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int otherid);
	public abstract Others findById(final int otherid);
	public abstract boolean modify(final Others others);
}
