package com.nankai.exchange.biz;

import java.util.List;

public interface ISearchProductsBiz {

	public abstract List<?> searchProductsByName(final String name, final int id);
}
