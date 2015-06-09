package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Females;

public interface IFemalesBiz {
	
	public abstract boolean add(final Females females);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int femaleid);
    public abstract Females findById(final int femaleid);
    public abstract boolean modify(final Females females);

}
