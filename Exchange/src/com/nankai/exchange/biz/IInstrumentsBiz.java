package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Instruments;

public interface IInstrumentsBiz {
	
	public abstract boolean add(final Instruments instruments);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int instrumentid);
    public abstract Instruments findById(final int instrumentid);
    public abstract boolean modify(final Instruments instruments);

}
