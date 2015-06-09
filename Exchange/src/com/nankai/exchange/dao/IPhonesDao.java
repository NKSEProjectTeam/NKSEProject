package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Phones;

/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IPhonesDao{
	public abstract int insert(final Phones phones);
	public abstract  List<Phones> selectAll();
	public abstract int deleteById(final int phoneid);
    public abstract Phones selectById(final int phoneid);
    public abstract int update(final Phones phones);
    public abstract  List<Phones> selectByName(final String phonemodel);

}
