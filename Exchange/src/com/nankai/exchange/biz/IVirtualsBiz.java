package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Virtuals;

public interface IVirtualsBiz {
		public abstract boolean add(final Virtuals virtuals);
		public abstract List<?>findAll();
		public abstract boolean deleteById(final int virtualid);
		public abstract Virtuals findById(final int virtualid);
		public abstract boolean modify(final Virtuals virtuals);
}
