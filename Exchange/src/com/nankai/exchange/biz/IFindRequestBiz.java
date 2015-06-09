package com.nankai.exchange.biz;

import java.util.List;

public interface IFindRequestBiz {

	public abstract List<List<?>> findRequestState(String msg);
}
