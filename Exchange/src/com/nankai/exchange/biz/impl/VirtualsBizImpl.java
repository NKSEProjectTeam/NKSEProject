package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IVirtualsBiz;
import com.nankai.exchange.dao.IVirtualsDao;
import com.nankai.exchange.dao.impl.VirtualsDaoImpl;
import com.nankai.exchange.po.Virtuals;

public class VirtualsBizImpl implements IVirtualsBiz {
private IVirtualsDao virtualsDao;

	public VirtualsBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.virtualsDao=new VirtualsDaoImpl();
	
}

	@Override
	public boolean add(Virtuals virtuals) {
		// TODO Auto-generated method stub
		
		return this.virtualsDao.insert(virtuals)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.virtualsDao.selectAll();
	}

	@Override
	public Virtuals findById(int virtualid) {
		// TODO Auto-generated method stub
		return this.virtualsDao.selectById(virtualid);
	}

	@Override
	public boolean modify(Virtuals virtuals) {
		// TODO Auto-generated method stub
		return this.virtualsDao.update(virtuals)>0?true:false;
	}

	@Override
	public boolean deleteById(int virtualid) {
		// TODO Auto-generated method stub
		return this.virtualsDao.deleteById(virtualid)>0?true:false;
	}

}
