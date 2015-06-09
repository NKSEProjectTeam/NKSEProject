package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Males;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IMalesDao{
	public abstract int insert(final Males males);
	public abstract  List<Males> selectAll();
	public abstract int deleteById(final int maleid);
    public abstract Males selectById(final int maleid);
    public abstract int update(final Males males);
    public abstract  List<Males> selectByName(final String maletype);

}
