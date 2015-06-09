package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IAudiosBiz;
import com.nankai.exchange.dao.IAudiosDao;
import com.nankai.exchange.dao.impl.AudiosDaoImpl;
import com.nankai.exchange.po.Audios;

public class AudiosBizImpl implements IAudiosBiz {
	
	private IAudiosDao audiosDao;
	
	public AudiosBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.audiosDao=new AudiosDaoImpl();
	}

	@Override
	public boolean add(Audios audios) {
		// TODO Auto-generated method stub
		return this.audiosDao.insert(audios)>0?true:false;
	}

	@Override
	public List<?> findAll() {
		// TODO Auto-generated method stub
		//System.out.println(this.audiosDao.selectAll());
		return this.audiosDao.selectAll();
	}

	@Override
	public boolean deleteById(int audioid) {
		// TODO Auto-generated method stub
		return this.audiosDao.deleteById(audioid)>0?true:false;
	}

	@Override
	public Audios findById(int audioid) {
		// TODO Auto-generated method stub
		return this.audiosDao.selectById(audioid);
	}

	@Override
	public boolean modify(Audios audios) {
		// TODO Auto-generated method stub
		return this.audiosDao.update(audios)>0?true:false;
	}

}
