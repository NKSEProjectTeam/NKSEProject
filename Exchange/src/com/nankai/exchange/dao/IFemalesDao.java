package com.nankai.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Females;
/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IFemalesDao {
	public abstract int insert(final Females females);
	public abstract  List<Females> selectAll();
	public abstract int deleteById(final int femaleid);
    public abstract Females selectById(final int femaleid);
    public abstract int update(final Females females);
    public abstract  List<Females> selectByName(final String femaletype);

}
