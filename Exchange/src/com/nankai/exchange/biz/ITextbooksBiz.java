package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Textbooks;


public interface ITextbooksBiz {
	public abstract boolean add(final Textbooks textbooks);
	public abstract List<?>findAll();
	public abstract boolean deleteById(final int tbid);
	public abstract Textbooks findById(final int tbid);
	public abstract boolean modify(final Textbooks textbooks);
}
