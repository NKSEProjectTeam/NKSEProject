package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Electrics;

public interface IElectricsDao {

	public abstract int insert(final Electrics electric);
	public abstract List<Electrics> selectAll();
	public abstract int deleteById(final int eleid);
	public abstract Electrics selectById(final int eleid);
	public abstract int update(final Electrics electric);
	public abstract List<Electrics> selectByName(final String elename);
}
