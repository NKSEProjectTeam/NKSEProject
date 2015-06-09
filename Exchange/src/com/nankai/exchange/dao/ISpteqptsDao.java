package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Spteqpts;

/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface ISpteqptsDao {
	public abstract int insert(final Spteqpts spteqpts);
	public abstract  List<Spteqpts> selectAll();
	public abstract int deleteById(final int seid);
    public abstract Spteqpts selectById(final int seid);
    public abstract int update(final Spteqpts spteqpts);
    public abstract  List<Spteqpts> selectByName(final String sename);

}
