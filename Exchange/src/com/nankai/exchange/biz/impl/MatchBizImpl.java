package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.biz.IMatchBiz;
import com.nankai.exchange.dao.IAudiosDao;
import com.nankai.exchange.dao.IBagsDao;
import com.nankai.exchange.dao.ICosmeticsDao;
import com.nankai.exchange.dao.IDailyprosDao;
import com.nankai.exchange.dao.IDecorationsDao;
import com.nankai.exchange.dao.IDigitsDao;
import com.nankai.exchange.dao.IElectricsDao;
import com.nankai.exchange.dao.IEntertainmentsDao;
import com.nankai.exchange.dao.IExtrabooksDao;
import com.nankai.exchange.dao.IFemalesDao;
import com.nankai.exchange.dao.IInstrumentsDao;
import com.nankai.exchange.dao.IMalesDao;
import com.nankai.exchange.dao.IOthersDao;
import com.nankai.exchange.dao.IPcDao;
import com.nankai.exchange.dao.IPhonesDao;
import com.nankai.exchange.dao.ISpprosDao;
import com.nankai.exchange.dao.ISptastsDao;
import com.nankai.exchange.dao.ISpteqptsDao;
import com.nankai.exchange.dao.ITextbooksDao;
import com.nankai.exchange.dao.IVirtualsDao;
import com.nankai.exchange.dao.impl.AudiosDaoImpl;
import com.nankai.exchange.dao.impl.BagsDaoImpl;
import com.nankai.exchange.dao.impl.CosmeticsDaoImpl;
import com.nankai.exchange.dao.impl.DailyprosDaoImpl;
import com.nankai.exchange.dao.impl.DecorationsDaoImpl;
import com.nankai.exchange.dao.impl.DigitsDaoImpl;
import com.nankai.exchange.dao.impl.ElectricsDaoImpl;
import com.nankai.exchange.dao.impl.EntertainmentsDaoImpl;
import com.nankai.exchange.dao.impl.ExtralbooksDaoImpl;
import com.nankai.exchange.dao.impl.FemalesDaoImpl;
import com.nankai.exchange.dao.impl.InstrumentsDaoImpl;
import com.nankai.exchange.dao.impl.MalesDaoImpl;
import com.nankai.exchange.dao.impl.OthersDaoImpl;
import com.nankai.exchange.dao.impl.PcDaoImpl;
import com.nankai.exchange.dao.impl.PhonesDaoImpl;
import com.nankai.exchange.dao.impl.SpprosDaoImpl;
import com.nankai.exchange.dao.impl.SptastsDaoImpl;
import com.nankai.exchange.dao.impl.SpteqptsDaoImpl;
import com.nankai.exchange.dao.impl.TextbooksDaoImpl;
import com.nankai.exchange.dao.impl.VirtualsDaoImpl;

public class MatchBizImpl implements IMatchBiz {

	@Override
	public List<List<?>> findMatch(String sexc, String iexcthing) {
		// TODO Auto-generated method stub
		
		List<List<?>> lstItems = new ArrayList<List<?>>();
		
		switch(sexc) {
		case "books":
			// 图书：教科书、课外书、音像
			
			ITextbooksDao textbooksDao = new TextbooksDaoImpl();
			IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
			IAudiosDao audiosDao = new AudiosDaoImpl();
			
			lstItems.add(textbooksDao.selectByName(iexcthing));
			lstItems.add(extrabooksDao.selectByName(iexcthing));
			lstItems.add(audiosDao.selectByName(iexcthing));
			
			break;
		case "eles":
			// 电子：电脑、手机、数码
			
			IPcDao pcDao = new PcDaoImpl();
			IPhonesDao phonesDao = new PhonesDaoImpl();
			IDigitsDao digitsDao = new DigitsDaoImpl();
			
			lstItems.add(pcDao.selectByName(iexcthing));
			lstItems.add(phonesDao.selectByName(iexcthing));
			lstItems.add(digitsDao.selectByName(iexcthing));
			
			break;
		case "spts":
			// 体育：体育辅助、体育用品
			
			ISptastsDao sptastsDao = new SptastsDaoImpl();
			ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
			
			lstItems.add(sptastsDao.selectByName(iexcthing));
			lstItems.add(spteqptsDao.selectByName(iexcthing));
			
			break;
		case "lifes":
			// 生活：日常、电器、娱乐、化妆品、特产
			
			IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
			IElectricsDao electricsDao = new ElectricsDaoImpl();
			IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
			ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
			ISpprosDao spprosDao = new SpprosDaoImpl();
			
			lstItems.add(dailyprosDao.selectByName(iexcthing));
			lstItems.add(electricsDao.selectByName(iexcthing));
			lstItems.add(entertainmentsDao.selectByName(iexcthing));
			lstItems.add(cosmeticsDao.selectByName(iexcthing));
			lstItems.add(spprosDao.selectByName(iexcthing));
			
			break;
		case "clothes":
			// 服装
			IFemalesDao femalesDao = new FemalesDaoImpl();
			IMalesDao malesDao = new MalesDaoImpl();
			
			lstItems.add(femalesDao.selectByName(iexcthing));
			lstItems.add(malesDao.selectByName(iexcthing));
			
			break;
		case "decs":
			// 饰品
			IDecorationsDao decorationsDao = new DecorationsDaoImpl();
			
			lstItems.add(decorationsDao.selectByName(iexcthing));
			
			break;
		case "bags":
			// 箱包
			
			IBagsDao bagsDao = new BagsDaoImpl();
			
			lstItems.add(bagsDao.selectByName(iexcthing));
			
			break;
		case "ins":
			// 乐器
			
			IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
			
			lstItems.add(instrumentsDao.selectByName(iexcthing));
			
			break;
		case "vis":
			// 虚拟
			
			IVirtualsDao virtualsDao = new VirtualsDaoImpl();
			
			lstItems.add(virtualsDao.selectByName(iexcthing));
			
			break;
		case "others":
			// 其他
			
			IOthersDao othersDao = new OthersDaoImpl();
			lstItems.add(othersDao.selectByName(iexcthing));
			
			break;
		}
		return lstItems;
	}

}
