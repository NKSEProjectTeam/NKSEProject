package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.TradeOrder;

public interface IQueryOrderBiz {

	public abstract List<TradeOrder> queryOrder(final int userid1);
}
