package com.chinasofti.exchange.dao;


import java.util.List;

import com.nankai.exchange.po.Audios;
/**
 * 
 * @author zy
 * date  2014-8-16 13:16
 */
public interface IAudiosDao {
	public abstract int insert(final Audios audios);
	public abstract  List<Audios> selectAll();
	public abstract int deleteById(final int audioid);
    public abstract Audios selectById(final int audioid);
    public abstract int update(final Audios audios);
    public abstract  List<Audios> selectByName(final String audioname);

}
