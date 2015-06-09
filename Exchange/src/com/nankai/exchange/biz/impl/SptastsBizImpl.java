package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ISptastsBiz;
import com.nankai.exchange.dao.ISptastsDao;
import com.nankai.exchange.dao.impl.SptastsDaoImpl;
import com.nankai.exchange.po.Sptasts;

public class SptastsBizImpl implements ISptastsBiz {
private ISptastsDao sptastsDao;

	public SptastsBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.sptastsDao=new SptastsDaoImpl();
}

	@Override
	public boolean add(Sptasts sptasts) {
		// TODO Auto-generated method stub
		return this.sptastsDao.insert(sptasts)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.sptastsDao.selectAll();
	}

	@Override
	public boolean deleteById(int said) {
		// TODO Auto-generated method stub
		return this.sptastsDao.deleteById(said)>0?true:false;
	}

	@Override
	public Sptasts findById(int said) {
		// TODO Auto-generated method stub
		return this.sptastsDao.selectById(said);
	}

	@Override
	public boolean modify(Sptasts sptasts) {
		// TODO Auto-generated method stub
		return this.sptastsDao.update(sptasts)>0?true:false;
	}

}
