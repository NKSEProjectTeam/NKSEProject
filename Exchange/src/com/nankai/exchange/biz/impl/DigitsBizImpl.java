package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IDigitsBiz;
import com.nankai.exchange.dao.IDigitsDao;
import com.nankai.exchange.dao.impl.DigitsDaoImpl;
import com.nankai.exchange.po.Digits;

public class DigitsBizImpl implements IDigitsBiz {
	
	private IDigitsDao digitsDao;
    
	public DigitsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.digitsDao=new DigitsDaoImpl();
	}

	@Override
	public boolean add(Digits digits) {
		// TODO Auto-generated method stub
		return this.digitsDao.insert(digits)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.digitsDao.selectAll();
	}

	@Override
	public boolean deleteById(int digitid) {
		// TODO Auto-generated method stub
		return this.digitsDao.deleteById(digitid)>0?true:false;
	}

	@Override
	public Digits findById(int digitid) {
		// TODO Auto-generated method stub
		return this.digitsDao.selectById(digitid);
	}

	@Override
	public boolean modify(Digits digits) {
		// TODO Auto-generated method stub
		return this.digitsDao.update(digits)>0?true:false;
	}

}
