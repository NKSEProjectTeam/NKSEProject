package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IDecorationsBiz;
import com.nankai.exchange.dao.IDecorationsDao;
import com.nankai.exchange.dao.impl.DecorationsDaoImpl;
import com.nankai.exchange.po.Decorations;

public class DecorationsBizImpl implements IDecorationsBiz {
     
	private IDecorationsDao decorationsDao;
     
     
	public DecorationsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.decorationsDao=new DecorationsDaoImpl();
	}

	@Override
	public boolean add(Decorations decorations) {
		// TODO Auto-generated method stub
		return this.decorationsDao.insert(decorations)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.decorationsDao.selectAll();
	}

	@Override
	public boolean deleteById(int decid) {
		// TODO Auto-generated method stub
		return this.decorationsDao.deleteById(decid)>0?true:false;
	}

	@Override
	public Decorations findById(int decid) {
		// TODO Auto-generated method stub
		return this.decorationsDao.selectById(decid);
	}

	@Override
	public boolean modify(Decorations decorations) {
		// TODO Auto-generated method stub
		return this.decorationsDao.update(decorations)>0?true:false;
	}

}
