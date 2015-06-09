package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IPhonesBiz;
import com.nankai.exchange.dao.IPhonesDao;
import com.nankai.exchange.dao.impl.PhonesDaoImpl;
import com.nankai.exchange.po.Phones;

public class PhonesBizImpl implements IPhonesBiz {
private IPhonesDao phonesDao;

	public PhonesBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.phonesDao=new PhonesDaoImpl();
}

	@Override
	public boolean add(Phones phones) {
		// TODO Auto-generated method stub
		return this.phonesDao.insert(phones)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.phonesDao.selectAll();
	}

	@Override
	public boolean deleteById(int phoneid) {
		// TODO Auto-generated method stub
		return this.phonesDao.deleteById(phoneid)>0?true:false;
	}

	@Override
	public Phones findById(int phoneid) {
		// TODO Auto-generated method stub
		return this.phonesDao.selectById(phoneid);
	}

	@Override
	public boolean modify(Phones phones) {
		// TODO Auto-generated method stub
		return this.phonesDao.update(phones)>0?true:false;
	}

}
