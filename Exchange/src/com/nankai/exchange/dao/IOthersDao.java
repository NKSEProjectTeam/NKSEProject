package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Others;


/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IOthersDao{
	public abstract int insert(final Others others);
	public abstract  List<Others> selectAll();
	public abstract int deleteById(final int otherid);
    public abstract Others selectById(final int otherid);
    public abstract int update(final Others others);
    public abstract  List<Others> selectByName(final String othersname);

}
