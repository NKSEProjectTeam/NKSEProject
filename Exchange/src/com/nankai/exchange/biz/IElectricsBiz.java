package com.nankai.exchange.biz;

import java.util.List;


import com.nankai.exchange.po.Electrics;

public interface IElectricsBiz {
	public abstract boolean add(final Electrics electrics);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int eleid);
    public abstract Electrics findById(final int eleid);
    public abstract boolean modify(final Electrics electrics);

}
