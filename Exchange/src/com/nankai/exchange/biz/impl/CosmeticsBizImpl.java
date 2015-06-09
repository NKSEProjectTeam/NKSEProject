package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ICosmeticsBiz;
import com.nankai.exchange.dao.ICosmeticsDao;
import com.nankai.exchange.dao.impl.CosmeticsDaoImpl;
import com.nankai.exchange.po.Cosmetics;

public class CosmeticsBizImpl implements ICosmeticsBiz {

	private ICosmeticsDao cosmeticsDao;

	public CosmeticsBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.cosmeticsDao=new CosmeticsDaoImpl();
}

	@Override
	public boolean add(Cosmetics cosmetics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.cosmeticsDao.selectAll();
	}

	@Override
	public boolean deleteById(int cosid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Cosmetics findById(int cosid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(Cosmetics cosmetics) {
		// TODO Auto-generated method stub
		return false;
	}

}
