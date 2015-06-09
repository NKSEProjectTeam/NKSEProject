package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Type;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface ITypeDao{
	public abstract int insert(final Type type);
	public abstract  List<Type> selectAll();
	public abstract int deleteById(final int typeid);
    public abstract Type selectById(final int typeid);
    public abstract int update(final Type type);

}
