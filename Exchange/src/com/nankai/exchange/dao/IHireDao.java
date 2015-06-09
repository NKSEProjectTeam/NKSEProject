package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Hire;

// 租赁dao层

public interface IHireDao {

	public abstract int insert(final Hire hire);
	public abstract int deleteById(final int hireid);
	public abstract int update(final Hire hire);
	public abstract List<Hire> selectAll();
	public abstract Hire selectById(final int hireid);
	public abstract List<Hire> selectUserId(final int userid);
	
}
