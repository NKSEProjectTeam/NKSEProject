package com.nankai.exchange.biz;

import com.nankai.exchange.po.Users;

public interface IUsersBiz {

	public abstract Users findByName(final String username);
	public abstract boolean addUser(final Users user);
	
}
