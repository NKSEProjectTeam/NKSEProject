package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Pc;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IPcDao{
	public abstract int insert(final Pc pc);
	public abstract  List<Pc> selectAll();
	public abstract int deleteById(final int pcid);
    public abstract Pc selectById(final int pcid);
    public abstract int update(final Pc pc);
    public abstract  List<Pc> selectByName(final String pcmodel);

}
