package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ISpteqptsBiz;
import com.nankai.exchange.dao.ISpteqptsDao;

import com.nankai.exchange.dao.impl.SpteqptsDaoImpl;
import com.nankai.exchange.po.Spteqpts;

public class SpteqptsBizImpl implements ISpteqptsBiz {
private ISpteqptsDao spteqptsDao;

	public SpteqptsBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.spteqptsDao=new SpteqptsDaoImpl();
}

	@Override
	public boolean add(Spteqpts spteqpts) {
		// TODO Auto-generated method stub
		return this.spteqptsDao.insert(spteqpts)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.spteqptsDao.selectAll();
	}

	@Override
	public boolean deleteById(int seid) {
		// TODO Auto-generated method stub
		return this.spteqptsDao.deleteById(seid)>0?true:false;
	}

	@Override
	public Spteqpts findById(int seid) {
		// TODO Auto-generated method stub
		return this.spteqptsDao.selectById(seid);
	}

	@Override
	public boolean modify(Spteqpts spteqpts) {
		// TODO Auto-generated method stub
		return this.spteqptsDao.update(spteqpts)>0?true:false;
	}

}
