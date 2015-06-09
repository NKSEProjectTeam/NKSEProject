package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Audios;

public interface IAudiosBiz {
	public abstract boolean add(final Audios audios);
	public abstract  List<?> findAll();
	public abstract boolean deleteById(final int audioid);
    public abstract Audios findById(final int audioid);
    public abstract boolean modify(final Audios audios);

}
