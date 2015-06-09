package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IExtrabooksBiz;
import com.nankai.exchange.dao.IExtrabooksDao;
import com.nankai.exchange.po.Extrabooks;
import com.nankai.exchange.dao.impl.ExtralbooksDaoImpl;
public class ExtrabooksBizImpl implements IExtrabooksBiz {
	
	 private IExtrabooksDao extrabooksDao;
	 
	 public ExtrabooksBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.extrabooksDao=new ExtralbooksDaoImpl();
	}

	@Override
	public boolean add(Extrabooks extrabooks) {
		// TODO Auto-generated method stub
		return this.extrabooksDao.insert(extrabooks)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.extrabooksDao.selectAll();
	}

	@Override
	public boolean deleteById(int ebid) {
		// TODO Auto-generated method stub
		return this.extrabooksDao.deleteById(ebid)>0?true:false;
	}

	@Override
	public Extrabooks findById(int ebid) {
		// TODO Auto-generated method stub
		return this.extrabooksDao.selectById(ebid);
	}

	@Override
	public boolean modify(Extrabooks extrabooks) {
		// TODO Auto-generated method stub
		return this.extrabooksDao.update(extrabooks)>0?true:false;
	}

}
