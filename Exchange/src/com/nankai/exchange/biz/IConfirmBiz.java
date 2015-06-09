package com.nankai.exchange.biz;

import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.WaitOrder;

public interface IConfirmBiz {

	public abstract boolean confirm(WaitOrder order, Users user, String flag);
	
}
