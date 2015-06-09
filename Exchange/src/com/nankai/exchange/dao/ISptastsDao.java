package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Sptasts;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface ISptastsDao{
	public abstract int insert(final Sptasts sptasts);
	public abstract  List<Sptasts> selectAll();
	public abstract int deleteById(final int said);
    public abstract Sptasts selectById(final int said);
    public abstract int update(final Sptasts sptasts);
    public abstract  List<Sptasts> selectByName(final String saname);

}
