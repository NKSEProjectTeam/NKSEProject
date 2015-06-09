package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IDailyprosBiz;
import com.nankai.exchange.dao.IDailyprosDao;
import com.nankai.exchange.dao.impl.DailyprosDaoImpl;
import com.nankai.exchange.po.Dailypros;

public class DailyprosBizImpl implements IDailyprosBiz {

	private IDailyprosDao dailyprosDao;

	public DailyprosBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.dailyprosDao=new DailyprosDaoImpl();
}

	@Override
	public boolean add(Dailypros dailypro) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.dailyprosDao.selectAll();
	}

	@Override
	public boolean deleteById(int dpid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Dailypros findById(int dpid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(Dailypros dailypro) {
		// TODO Auto-generated method stub
		return false;
	}

}
