package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ISpprosBiz;
import com.nankai.exchange.dao.ISpprosDao;

import com.nankai.exchange.dao.impl.SpprosDaoImpl;

import com.nankai.exchange.po.Sppros;

public class SpprosBizImpl implements ISpprosBiz {

	private ISpprosDao spprosDao;

	public SpprosBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.spprosDao=new SpprosDaoImpl();
	}

	@Override
	public boolean add(Sppros sppros) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.spprosDao.selectAll();
	}

	@Override
	public boolean deleteById(int spid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Sppros findById(int spid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean modify(Sppros sppros) {
		// TODO Auto-generated method stub
		return false;
	}

}
