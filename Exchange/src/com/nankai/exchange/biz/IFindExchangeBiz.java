package com.nankai.exchange.biz;

import java.util.List;

public interface IFindExchangeBiz {

	public abstract List<List<?>> findExchangeState(String msg);
}
