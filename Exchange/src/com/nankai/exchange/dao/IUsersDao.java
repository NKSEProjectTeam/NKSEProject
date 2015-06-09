package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Users;

// 用户信息dao层

public interface IUsersDao {

	public abstract int insert(final Users user);
	public abstract int deleteById(final int userid);
	public abstract int update(final Users user);
	public abstract List<Users> selectAll();
	public abstract Users selectById(final int userid);
	public abstract Users selectByName(final String username);
	
}
