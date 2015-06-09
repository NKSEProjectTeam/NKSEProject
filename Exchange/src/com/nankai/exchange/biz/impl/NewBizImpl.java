package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.biz.INewBiz;
import com.nankai.exchange.dao.IBagsDao;
import com.nankai.exchange.dao.ICosmeticsDao;
import com.nankai.exchange.dao.IDailyprosDao;
import com.nankai.exchange.dao.IDigitsDao;
import com.nankai.exchange.dao.IElectricsDao;
import com.nankai.exchange.dao.IEntertainmentsDao;
import com.nankai.exchange.dao.IExtrabooksDao;
import com.nankai.exchange.dao.IFemalesDao;
import com.nankai.exchange.dao.IMalesDao;
import com.nankai.exchange.dao.IPcDao;
import com.nankai.exchange.dao.IPhonesDao;
import com.nankai.exchange.dao.ISpprosDao;
import com.nankai.exchange.dao.ITextbooksDao;
import com.nankai.exchange.dao.impl.BagsDaoImpl;
import com.nankai.exchange.dao.impl.CosmeticsDaoImpl;
import com.nankai.exchange.dao.impl.DailyprosDaoImpl;
import com.nankai.exchange.dao.impl.DigitsDaoImpl;
import com.nankai.exchange.dao.impl.ElectricsDaoImpl;
import com.nankai.exchange.dao.impl.EntertainmentsDaoImpl;
import com.nankai.exchange.dao.impl.ExtralbooksDaoImpl;
import com.nankai.exchange.dao.impl.FemalesDaoImpl;
import com.nankai.exchange.dao.impl.MalesDaoImpl;
import com.nankai.exchange.dao.impl.PcDaoImpl;
import com.nankai.exchange.dao.impl.PhonesDaoImpl;
import com.nankai.exchange.dao.impl.SpprosDaoImpl;
import com.nankai.exchange.dao.impl.TextbooksDaoImpl;

public class NewBizImpl implements INewBiz {

	@Override
	public List<List<?>> findNew(String msg, int cnt) {
		// TODO Auto-generated method stub
		List<List<?>> lstGoods = new ArrayList<List<?>>();
		List<?> lst;
		// msg的格式为：类别名1//类别名2//……
		String[] types = msg.split("//");
		for(int i = 0; i < types.length; i++) {
			System.out.println(types[i]);
			switch(types[i]) {
			case "textbooks":
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				lst = textbooksDao.selectAll();
				
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "extrabooks":
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				lst = extrabooksDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "pc":
				IPcDao pcDao = new PcDaoImpl();
				lst = pcDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "phones":
				IPhonesDao phonesDao = new PhonesDaoImpl();
				lst = phonesDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "digits":
				IDigitsDao digitsDao = new DigitsDaoImpl();
				lst = digitsDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "dailypros":
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				lst = dailyprosDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "entertainmaent":
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				lst = entertainmentsDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "electrics":
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				lst = electricsDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "cosmetics":
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				lst = cosmeticsDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "sppros":
				ISpprosDao spprosDao = new SpprosDaoImpl();
				lst = spprosDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "females":
				IFemalesDao femalesDao = new FemalesDaoImpl();
				lst = femalesDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "males":
				IMalesDao malesDao = new MalesDaoImpl();
				lst = malesDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			case "bags":
				IBagsDao bagsDao = new BagsDaoImpl();
				lst = bagsDao.selectAll();
				if(lst.size() < cnt) {
					lstGoods.add(lst);
				} else {
					lst = lst.subList(lst.size() - cnt, lst.size());
					lstGoods.add(lst);
				}
				break;
			}
		}
		
//		IAudiosDao audiosDao = new AudiosDaoImpl();
//		lst = audiosDao.selectAll();
//		lstGoods.add(lst.get(lst.size() - 1));
		
		return lstGoods;
	}

}
