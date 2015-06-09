package com.nankai.exchange.biz;

import java.util.List;

import com.nankai.exchange.po.Msg;

public interface IFindMsgBiz {

	public abstract List<Msg> findAllMsgs(final String resource);
	
}
