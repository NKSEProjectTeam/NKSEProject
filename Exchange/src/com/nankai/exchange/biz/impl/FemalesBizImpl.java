package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IFemalesBiz;
import com.nankai.exchange.dao.IFemalesDao;
import com.nankai.exchange.dao.impl.FemalesDaoImpl;
import com.nankai.exchange.po.Females;

public class FemalesBizImpl implements IFemalesBiz {
	
	private IFemalesDao femalesDao;
	
	public FemalesBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.femalesDao=new FemalesDaoImpl();
	}

	@Override
	public boolean add(Females females) {
		// TODO Auto-generated method stub
		return this.femalesDao.insert(females)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.femalesDao.selectAll();
	}

	@Override
	public boolean deleteById(int femaleid) {
		// TODO Auto-generated method stub
		return this.femalesDao.deleteById(femaleid)>0?true:false;
	}

	@Override
	public Females findById(int femaleid) {
		// TODO Auto-generated method stub
		return this.femalesDao.selectById(femaleid);
	}

	@Override
	public boolean modify(Females females) {
		// TODO Auto-generated method stub
		return this.femalesDao.update(females)>0?true:false;
	}

}
