package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IMalesBiz;
import com.nankai.exchange.dao.IMalesDao;
import com.nankai.exchange.dao.impl.MalesDaoImpl;
import com.nankai.exchange.po.Males;

public class MalesBizImpl implements IMalesBiz {
	
	private IMalesDao malesDao;
	

	public MalesBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.malesDao=new MalesDaoImpl();
	}

	@Override
	public boolean add(Males males) {
		// TODO Auto-generated method stub
		return this.malesDao.insert(males)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.malesDao.selectAll();
	}

	@Override
	public boolean deleteById(int maleid) {
		// TODO Auto-generated method stub
		return this.malesDao.deleteById(maleid)>0?true:false;
	}

	@Override
	public Males findById(int maleid) {
		// TODO Auto-generated method stub
		return this.malesDao.selectById(maleid);
	}

	@Override
	public boolean modify(Males males) {
		// TODO Auto-generated method stub
		return this.malesDao.update(males)>0?true:false;
	}

}
