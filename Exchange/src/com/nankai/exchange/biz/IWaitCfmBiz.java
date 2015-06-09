package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.WaitOrder;

public interface IWaitCfmBiz {

	public abstract List<WaitOrder> findWaitCfm(Users user);
}
