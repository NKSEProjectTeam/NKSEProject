package com.nankai.exchange.biz.impl;

import com.nankai.exchange.biz.IUsersBiz;
import com.nankai.exchange.dao.IUsersDao;
import com.nankai.exchange.dao.impl.UsersDaoImpl;
import com.nankai.exchange.po.Users;

public class UsersBizImpl implements IUsersBiz {

	private IUsersDao usersDao;
	
	public UsersBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		usersDao = new UsersDaoImpl();
	}

	@Override
	public Users findByName(String username) {
		// TODO Auto-generated method stub
		return this.usersDao.selectByName(username);
	}

	@Override
	public boolean addUser(Users user) {
		// TODO Auto-generated method stub
		return usersDao.insert(user) > 0 ? true : false;
	}

}
