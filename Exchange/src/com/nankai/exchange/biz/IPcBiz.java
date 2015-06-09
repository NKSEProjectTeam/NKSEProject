package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Pc;


public interface IPcBiz {
	public abstract boolean add(final Pc pc);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int pcid);
	public abstract Pc findById(final int pcid);
	public abstract boolean modify(final Pc pc);
}
