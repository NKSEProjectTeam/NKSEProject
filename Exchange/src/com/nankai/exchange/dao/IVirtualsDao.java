package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Virtuals;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IVirtualsDao {
	public abstract int insert(final Virtuals virtuals);
	public abstract  List<Virtuals> selectAll();
	public abstract int deleteById(final int virtualid);
    public abstract Virtuals selectById(final int virtualid);
    public abstract int update(final Virtuals virtuals);
    public abstract  List<Virtuals> selectByName(final String virtualname);

}
