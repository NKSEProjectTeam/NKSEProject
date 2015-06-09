package com.nankai.exchange.biz;

import com.nankai.exchange.po.Users;

public interface IPostBiz {

	public abstract boolean addPost(String table, Object object, Users user);
	
}
