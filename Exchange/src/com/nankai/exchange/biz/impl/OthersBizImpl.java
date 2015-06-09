package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IOthersBiz;
import com.nankai.exchange.dao.IOthersDao;
import com.nankai.exchange.dao.impl.OthersDaoImpl;
import com.nankai.exchange.po.Others;

public class OthersBizImpl implements IOthersBiz {
private IOthersDao othersDao;

	public OthersBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.othersDao=new OthersDaoImpl();
}

	@Override
	public boolean add(Others others) {
		// TODO Auto-generated method stub
		return this.othersDao.insert(others)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.othersDao.selectAll();
	}

	@Override
	public boolean deleteById(int otherid) {
		// TODO Auto-generated method stub
		return this.othersDao.deleteById(otherid)>0?true:false;
	}

	@Override
	public Others findById(int otherid) {
		// TODO Auto-generated method stub
		return this.othersDao.selectById(otherid);
	}

	@Override
	public boolean modify(Others others) {
		// TODO Auto-generated method stub
		return this.othersDao.update(others)>0?true:false;
	}

}
