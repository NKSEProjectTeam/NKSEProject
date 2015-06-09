package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Entertainments;


public interface IEntertainmentsDao {

	public abstract int insert(final Entertainments entertainment);
	public abstract List<Entertainments> selectAll();
	public abstract int deleteById(final int enterid);
	public abstract Entertainments selectById(final int enterid);
	public abstract int update(final Entertainments entertainment);
	public abstract List<Entertainments> selectByName(final String entername);
}
