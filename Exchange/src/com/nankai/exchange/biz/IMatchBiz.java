package com.nankai.exchange.biz;

import java.util.List;

public interface IMatchBiz {

	public abstract List<List<?>> findMatch(final String sexc, final String iexcthing);
}
