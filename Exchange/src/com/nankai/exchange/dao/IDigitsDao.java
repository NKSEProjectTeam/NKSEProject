package com.nankai.exchange.dao;

import java.util.List;


import com.nankai.exchange.po.Digits;
/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IDigitsDao{
	public abstract int insert(final Digits digits);
	public abstract  List<Digits> selectAll();
	public abstract int deleteById(final int digitid);
    public abstract Digits selectById(final int digitid);
    public abstract int update(final Digits digits);
    public abstract  List<Digits> selectByName(final String digitmodel);

}
