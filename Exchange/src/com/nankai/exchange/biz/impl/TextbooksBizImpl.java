package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ITextbooksBiz;
import com.nankai.exchange.dao.ITextbooksDao;
import com.nankai.exchange.dao.impl.TextbooksDaoImpl;
import com.nankai.exchange.po.Textbooks;

public class TextbooksBizImpl implements ITextbooksBiz {
  private ITextbooksDao textbooksDao;
  
	public TextbooksBizImpl() {
	super();
	// TODO Auto-generated constructor stub
	this.textbooksDao=new TextbooksDaoImpl();
}

	@Override
	public boolean add(Textbooks textbooks) {
		// TODO Auto-generated method stub
		return this.textbooksDao.insert(textbooks)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		//System.out.println(this.textbooksDao.selectAll());
		return this.textbooksDao.selectAll();
	}

	@Override
	public boolean deleteById(int tbid) {
		// TODO Auto-generated method stub
		return this.textbooksDao.deleteById(tbid)>0?true:false;
	}

	@Override
	public Textbooks findById(int tbid) {
		// TODO Auto-generated method stub
		return this.textbooksDao.selectById(tbid);
	}

	@Override
	public boolean modify(Textbooks textbooks) {
		// TODO Auto-generated method stub
		return this.textbooksDao.update(textbooks)>0?true:false;
	}

}
