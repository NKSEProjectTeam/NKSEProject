package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IInstrumentsBiz;
import com.nankai.exchange.dao.IInstrumentsDao;
import com.nankai.exchange.dao.impl.InstrumentsDaoImpl;
import com.nankai.exchange.po.Instruments;

public class InstrumentsBizImpl implements IInstrumentsBiz {
	 private IInstrumentsDao instrumentsDao;
	 

	public InstrumentsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.instrumentsDao=new InstrumentsDaoImpl();
	}

	@Override
	public boolean add(Instruments instruments) {
		// TODO Auto-generated method stub
		return this.instrumentsDao.insert(instruments)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.instrumentsDao.selectAll();
	}

	@Override
	public boolean deleteById(int instrumentid) {
		// TODO Auto-generated method stub
		return this.instrumentsDao.deleteById(instrumentid)>0?true:false;
	}

	@Override
	public Instruments findById(int instrumentid) {
		// TODO Auto-generated method stub
		return this.instrumentsDao.selectById(instrumentid);
	}

	@Override
	public boolean modify(Instruments instruments) {
		// TODO Auto-generated method stub
		return this.instrumentsDao.update(instruments)>0?true:false;
	}

}
