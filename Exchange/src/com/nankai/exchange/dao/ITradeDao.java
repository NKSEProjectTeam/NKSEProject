package com.nankai.exchange.dao;

import java.util.List;

import com.nankai.exchange.po.Trade;

// 交易信息dao层

public interface ITradeDao {

	public abstract int insert(final Trade trade);
	public abstract int deleteById(final int traid);
	public abstract int update(final Trade trade);
	public abstract List<Trade> selectAll();
	public abstract Trade selectById(final int traid);
	public abstract List<Trade> selectUserId(final int userid1);
	
}
