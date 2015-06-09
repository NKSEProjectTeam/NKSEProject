package com.nankai.exchange.biz;

public interface ITradingBiz {

	public abstract boolean trading(final String type1, final int type1id, final String type2, final int type2id, int userid, int userid2);
}
