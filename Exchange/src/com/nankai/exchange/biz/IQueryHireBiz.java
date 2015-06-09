package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.HireOrder;

public interface IQueryHireBiz {

	public abstract List<HireOrder> findHireOrder(int userid);
}
