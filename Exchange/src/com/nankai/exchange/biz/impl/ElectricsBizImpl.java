package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IElectricsBiz;
import com.nankai.exchange.dao.IElectricsDao;

import com.nankai.exchange.dao.impl.ElectricsDaoImpl;

import com.nankai.exchange.po.Electrics;

public class ElectricsBizImpl implements IElectricsBiz {

	private IElectricsDao electricsDao;

	public ElectricsBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.electricsDao=new ElectricsDaoImpl();
}

	@Override
	public boolean add(Electrics electrics) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.electricsDao.selectAll();
	}

	@Override
	public boolean deleteById(int eleid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Electrics findById(int eleid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(Electrics electrics) {
		// TODO Auto-generated method stub
		return false;
	}

}
