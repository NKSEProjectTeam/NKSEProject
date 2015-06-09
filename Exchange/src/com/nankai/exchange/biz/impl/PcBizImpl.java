package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IPcBiz;
import com.nankai.exchange.dao.IPcDao;
import com.nankai.exchange.dao.impl.PcDaoImpl;
import com.nankai.exchange.po.Pc;

public class PcBizImpl implements IPcBiz {
private IPcDao pcDao;

	public PcBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.pcDao=new PcDaoImpl();
}

	@Override
	public boolean add(Pc pc) {
		// TODO Auto-generated method stub
		return this.pcDao.insert(pc)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.pcDao.selectAll();
	}

	@Override
	public boolean deleteById(int pcid) {
		// TODO Auto-generated method stub
		return this.pcDao.deleteById(pcid)>0?true:false;
	}

	@Override
	public Pc findById(int pcid) {
		// TODO Auto-generated method stub
		return this.pcDao.selectById(pcid);
	}

	@Override
	public boolean modify(Pc pc) {
		// TODO Auto-generated method stub
		return this.pcDao.update(pc)>0?true:false;
	}

}
