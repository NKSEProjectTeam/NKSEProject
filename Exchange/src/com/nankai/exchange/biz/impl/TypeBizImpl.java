package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ITypeBiz;
import com.nankai.exchange.dao.ITypeDao;
import com.nankai.exchange.dao.impl.TypeDaoImpl;
import com.nankai.exchange.po.Type;

public class TypeBizImpl implements ITypeBiz {
    private ITypeDao typeDao;
    
	public TypeBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.typeDao=new TypeDaoImpl();
		
	}

	@Override
	public boolean add(Type type) {
		// TODO Auto-generated method stub
		return this.typeDao.insert(type)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		return this.typeDao.selectAll();
	}

	@Override
	public boolean deleteById(int typeid) {
		// TODO Auto-generated method stub
		return this.typeDao.deleteById(typeid)>0?true:false;
	}

	@Override
	public Type findById(int typeid) {
		// TODO Auto-generated method stub
		return this.typeDao.selectById(typeid);
	}

	@Override
	public boolean modify(Type type) {
		// TODO Auto-generated method stub
		return this.typeDao.update(type)>0?true:false;
	}

}
