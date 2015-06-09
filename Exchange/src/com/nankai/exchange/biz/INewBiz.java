package com.nankai.exchange.biz;

import java.util.List;

public interface INewBiz {

	public abstract List<List<?>> findNew(String msg, int cnt);
}
