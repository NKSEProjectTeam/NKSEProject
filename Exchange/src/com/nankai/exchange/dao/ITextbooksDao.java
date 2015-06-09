package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Textbooks;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface ITextbooksDao{
	public abstract int insert(final Textbooks textbooks);
	public abstract  List<Textbooks> selectAll();
	public abstract int deleteById(final int tbid);
    public abstract Textbooks selectById(final int tbid);
    public abstract int update(final Textbooks textbooks);
    public abstract  List<Textbooks> selectByName(final String tbname);

}
