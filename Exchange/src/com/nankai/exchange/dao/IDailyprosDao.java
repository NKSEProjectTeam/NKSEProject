package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Dailypros;

public interface IDailyprosDao {

	public abstract int insert(final Dailypros dailypro);
	public abstract List<Dailypros> selectAll();
	public abstract int deleteById(final int dpid);
	public abstract Dailypros selectById(final int dpid);
	public abstract int update(final Dailypros dailypro);
	public abstract List<Dailypros> selectByName(final String dpname);
}
