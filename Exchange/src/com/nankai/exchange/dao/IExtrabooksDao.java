package com.nankai.exchange.dao;


import java.util.List;


import com.nankai.exchange.po.Extrabooks;
/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IExtrabooksDao{
	public abstract int insert(final Extrabooks extrabooks);
	public abstract  List<Extrabooks> selectAll();
	public abstract int deleteById(final int ebid);
    public abstract Extrabooks selectById(final int ebid);
    public abstract int update(final Extrabooks extrabooks);
    public abstract  List<Extrabooks> selectByName(final String ebname);

}
