package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Sppros;

public interface ISpprosBiz {
	public abstract boolean add(final Sppros sppros);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int spid);
    public abstract Sppros findById(final int spid);
    public abstract boolean modify(final Sppros sppros);

}
