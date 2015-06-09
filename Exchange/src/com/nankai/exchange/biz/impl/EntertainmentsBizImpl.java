package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IEntertainmentsBiz;
import com.nankai.exchange.dao.IEntertainmentsDao;

import com.nankai.exchange.dao.impl.EntertainmentsDaoImpl;

import com.nankai.exchange.po.Entertainments;

public class EntertainmentsBizImpl implements IEntertainmentsBiz {

	private IEntertainmentsDao entertainmentsDao;

	public EntertainmentsBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.entertainmentsDao=new EntertainmentsDaoImpl();
}
	@Override
	public boolean add(Entertainments entertainments) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.entertainmentsDao.selectAll();
	}

	@Override
	public boolean deleteById(int enterid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Entertainments findById(int enterid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(Entertainments entertainments) {
		// TODO Auto-generated method stub
		return false;
	}

}
