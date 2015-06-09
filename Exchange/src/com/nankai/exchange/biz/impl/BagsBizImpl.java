package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IBagsBiz;
import com.nankai.exchange.dao.IBagsDao;
import com.nankai.exchange.dao.impl.BagsDaoImpl;
import com.nankai.exchange.po.Bags;

public class BagsBizImpl implements IBagsBiz {
	private IBagsDao bagsDao;
	
	public BagsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.bagsDao=new BagsDaoImpl();
	}

	@Override
	public boolean add(Bags bags) {
		// TODO Auto-generated method stub
		return this.bagsDao.insert(bags)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.bagsDao.selectAll();
	}

	@Override
	public boolean deleteById(int bagid) {
		// TODO Auto-generated method stub
		return this.bagsDao.deleteById(bagid)>0?true:false;
	}

	@Override
	public Bags findById(int bagid) {
		// TODO Auto-generated method stub
		return this.bagsDao.selectById(bagid);
	}

	@Override
	public boolean modify(Bags bags) {
		// TODO Auto-generated method stub
		return this.bagsDao.update(bags)>0?true:false;
	}

}
