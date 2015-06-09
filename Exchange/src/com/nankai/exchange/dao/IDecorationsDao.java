package com.nankai.exchange.dao;


import java.util.List;
import com.nankai.exchange.po.Decorations;
/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IDecorationsDao{
	public abstract int insert(final Decorations decorations);
	public abstract  List<Decorations> selectAll();
	public abstract int deleteById(final int decid);
    public abstract Decorations selectById(final int decid);
    public abstract int update(final Decorations decorations);
    public abstract  List<Decorations> selectByName(final String decname);

}
