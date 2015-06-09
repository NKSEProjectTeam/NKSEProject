package com.nankai.exchange.biz.impl;

import com.nankai.exchange.biz.ITradingBiz;
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
import com.nankai.exchange.dao.IUsersDao;
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
import com.nankai.exchange.dao.impl.UsersDaoImpl;
import com.nankai.exchange.dao.impl.VirtualsDaoImpl;
import com.nankai.exchange.po.Audios;
import com.nankai.exchange.po.Bags;
import com.nankai.exchange.po.Cosmetics;
import com.nankai.exchange.po.Dailypros;
import com.nankai.exchange.po.Decorations;
import com.nankai.exchange.po.Digits;
import com.nankai.exchange.po.Electrics;
import com.nankai.exchange.po.Entertainments;
import com.nankai.exchange.po.Extrabooks;
import com.nankai.exchange.po.Females;
import com.nankai.exchange.po.Instruments;
import com.nankai.exchange.po.Males;
import com.nankai.exchange.po.Others;
import com.nankai.exchange.po.Pc;
import com.nankai.exchange.po.Phones;
import com.nankai.exchange.po.Sppros;
import com.nankai.exchange.po.Sptasts;
import com.nankai.exchange.po.Spteqpts;
import com.nankai.exchange.po.Textbooks;
import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.Virtuals;

public class TradingBizImpl implements ITradingBiz {

	@Override
	public boolean trading(String type1, int type1id, String type2, int type2id, int userid, int userid2) {
		// TODO Auto-generated method stub
		
		int type1id1 = 0;
		
		switch (type1) {
		case "textbooks":
			ITextbooksDao textbooksDao = new TextbooksDaoImpl();
			Textbooks textbooks =  textbooksDao.selectById(type1id);
			textbooks.setTbstate(3);
			textbooksDao.update(textbooks);
			type1id1 = 19;
			break;
		case "extrabooks":
			IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
			Extrabooks extrabooks =  extrabooksDao.selectById(type1id);
			extrabooks.setEbstate(3);
			extrabooksDao.update(extrabooks);
			type1id1 = 9;
			break;
		case "audios":
			IAudiosDao audiosDao = new AudiosDaoImpl();
			Audios audios =  audiosDao.selectById(type1id);
			audios.setAudiostate(3);
			audiosDao.update(audios);
			type1id1 = 1;
			break;
		case "bags":
			IBagsDao bagsDao = new BagsDaoImpl();
			Bags bags = bagsDao.selectById(type1id);
			bags.setBagstate(3);
			bagsDao.update(bags);
			type1id1 = 2;
			break;
		case "cosmetics":
			ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
			Cosmetics cosmetics = cosmeticsDao.selectById(type1id);
			cosmetics.setCosstate(3);
			cosmeticsDao.update(cosmetics);
			type1id1 = 3;
			break;
		case "dailypros":
			IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
			Dailypros dailypros = dailyprosDao.selectById(type1id);
			dailypros.setDpstate(3);
			dailyprosDao.update(dailypros);
			type1id1 = 4;
			break;
		case "decorations":
			IDecorationsDao decorationsDao = new DecorationsDaoImpl();
			Decorations decorations = decorationsDao.selectById(type1id);
			decorations.setDecstate(3);
			decorationsDao.update(decorations);
			type1id1 = 5;
			break;
		case "digits":
			IDigitsDao digitsDao = new DigitsDaoImpl();
			Digits digits = digitsDao.selectById(type1id);
			digits.setDigitstate(3);
			digitsDao.update(digits);
			type1id1 = 6;
			break;
		case "electrics":
			IElectricsDao electricsDao = new ElectricsDaoImpl();
			Electrics electrics = electricsDao.selectById(type1id);
			electrics.setElestate(3);
			electricsDao.update(electrics);
			type1id1 = 7;
			break;
		case "entertainments":
			IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
			Entertainments entertainments = entertainmentsDao.selectById(type1id);
			entertainments.setEnterstate(3);
			entertainmentsDao.update(entertainments);
			type1id1 = 8;
			break;
		case "females":
			IFemalesDao femalesDao = new FemalesDaoImpl();
			Females females = femalesDao.selectById(type1id);
			females.setFemalestate(3);
			femalesDao.update(females);
			type1id1 = 10;
			break;
		case "instruments":
			IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
			Instruments instruments = instrumentsDao.selectById(type1id);
			instruments.setInstrumentstate(3);
			instrumentsDao.update(instruments);
			type1id1 = 11;
			break;
		case "males":
			IMalesDao malesDao = new MalesDaoImpl();
			Males males = malesDao.selectById(type1id);
			males.setMalestate(3);
			malesDao.update(males);
			type1id1 = 12;
			break;
		case "others":
			IOthersDao othersDao = new OthersDaoImpl();
			Others others = othersDao.selectById(type1id);
			others.setOthersstate(3);
			othersDao.update(others);
			type1id1 = 13;
			break;
		case "pc":
			IPcDao pcDao = new PcDaoImpl();
			Pc pc = pcDao.selectById(type1id);
			pc.setPcstate(3);
			pcDao.update(pc);
			type1id1 = 14;
			break;
			
		case "phones":
			IPhonesDao phonesDao = new PhonesDaoImpl();
			Phones phones = phonesDao.selectById(type1id);
			phones.setPhonestate(3);
			phonesDao.update(phones);
			type1id1 = 15;
			break;
		case "sppros":
			ISpprosDao spprosDao = new SpprosDaoImpl();
			Sppros sppros = spprosDao.selectById(type1id);
			sppros.setSpstate(3);
			spprosDao.update(sppros);
			type1id1 = 16;
			break;
		case "sptasts":
			ISptastsDao sptastsDao = new SptastsDaoImpl();
			Sptasts sptasts = sptastsDao.selectById(type1id);
			sptasts.setSastate(3);
			sptastsDao.update(sptasts);
			type1id1 = 17;
			break;
		case "spteqpts":
			ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
			Spteqpts spteqpts = spteqptsDao.selectById(type1id);
			spteqpts.setSestate(3);
			spteqptsDao.update(spteqpts);
			type1id1 = 18;
			break;
		case "virtuals":
			IVirtualsDao virtualsDao = new VirtualsDaoImpl();
			Virtuals virtuals = virtualsDao.selectById(type1id);
			virtuals.setVirtualstate(3);
			virtualsDao.update(virtuals);
			type1id1 = 20;
			break;
		}
		
		int type2id1 = 0;
		
		switch (type2) {
		case "textbooks":
			
			type2id1 = 19;
			break;
		case "extrabooks":
			
			type2id1 = 9;
			break;
		case "audios":
			
			type2id1 = 1;
			break;
		case "bags":
			
			type2id1 = 2;
			break;
		case "cosmetics":
			
			type2id1 = 3;
			break;
		case "dailypros":
			
			type2id1 = 4;
			break;
		case "decorations":
			
			type2id1 = 5;
			break;
		case "digits":
			
			type2id1 = 6;
			break;
		case "electrics":
			
			type2id1 = 7;
			break;
		case "entertainments":
			
			type2id1 = 8;
			break;
		case "females":
			
			type2id1 = 10;
			break;
		case "instruments":
			
			type2id1 = 11;
			break;
		case "males":
			
			type2id1 = 12;
			break;
		case "others":
			
			type2id1 = 13;
			break;
		case "pc":
			
			type2id1 = 14;
			break;
			
		case "phones":
			
			type2id1 = 15;
			break;
		case "sppros":
			
			type2id1 = 16;
			break;
		case "sptasts":
			
			type2id1 = 17;
			break;
		case "spteqpts":
			
			type2id1 = 18;
			break;
		case "virtuals":
			
			type2id1 = 20;
			break;
		}
		
		
		IUsersDao usersDao = new UsersDaoImpl();
		Users users = usersDao.selectById(userid);
		String mark = users.getMark();
		String msg = type2id1 + "<&>" + type2id + "<&>" + type1id1 + "<&>" + type1id + "<&>" + userid2 + "<//>";
		if(mark != null) {
			mark += msg;
		} else {
			mark = msg;
		}
		users.setMark(mark);
		
		return usersDao.update(users) > 0 ? true : false;
	}

}
