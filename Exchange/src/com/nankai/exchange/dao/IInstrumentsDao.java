package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Instruments;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IInstrumentsDao{
	public abstract int insert(final Instruments instruments);
	public abstract  List<Instruments> selectAll();
	public abstract int deleteById(final int instrumentid);
    public abstract Instruments selectById(final int instrumentid);
    public abstract int update(final Instruments instruments);
    public abstract  List<Instruments> selectByName(final String instrumentname);

}
