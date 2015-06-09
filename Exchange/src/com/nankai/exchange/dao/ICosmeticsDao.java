package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Cosmetics;

public interface ICosmeticsDao {

	public abstract int insert(final Cosmetics cosmetic);
	public abstract List<Cosmetics> selectAll();
	public abstract int deleteById(final int cosid);
	public abstract Cosmetics selectById(final int cosid);
	public abstract int update(final Cosmetics cosmetic);
	public abstract List<Cosmetics> selectByName(final String cosname);
	
}
