package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Digits;

public interface IDigitsBiz {
	
	public abstract boolean add(final Digits digits);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int digitid);
    public abstract Digits findById(final int digitid);
    public abstract boolean modify(final Digits digits);

}
