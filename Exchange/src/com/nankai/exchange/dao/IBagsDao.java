package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Bags;
/**
 * 
 * @author zy
 * date  2014-8-16 14:06
 */
public interface IBagsDao {
	public abstract int insert(final Bags bags);
	public abstract  List<Bags> selectAll();
	public abstract int deleteById(final int bagid);
    public abstract Bags selectById(final int bagid);
    public abstract int update(final Bags bags);
    public abstract  List<Bags> selectByName(final String bagbrand);

}
