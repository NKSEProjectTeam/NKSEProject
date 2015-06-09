package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Sppros;

public interface ISpprosDao {

	public abstract int insert(final Sppros sppro);
	public abstract List<Sppros> selectAll();
	public abstract int deleteById(final int spid);
	public abstract Sppros selectById(final int spid);
	public abstract int update(final Sppros sppro);
	public abstract List<Sppros> selectByName(final String spname);
}
