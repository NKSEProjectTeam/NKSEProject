package com.nankai.exchange.biz.impl;

import com.nankai.exchange.biz.IConfirmBiz;
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
import com.nankai.exchange.dao.ITradeDao;
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
import com.nankai.exchange.dao.impl.TradeDaoImpl;
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
import com.nankai.exchange.po.Trade;
import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.Virtuals;
import com.nankai.exchange.po.WaitOrder;

public class ConfirmBizImpl implements IConfirmBiz {

	@Override
	public boolean confirm(WaitOrder order, Users user, String flag) {
		// TODO Auto-generated method stub
		
		int state = 0;
		
		int type1 = order.getTypeid1();
		int type2 = order.getTypeid2();
		int type1id = order.getId1();
		int type2id = order.getId2();
		
		if(flag.equals("agree")) {
			state = 4;
		} else {
			state = 0;
		}
		
			
		switch (type2) {
		case 19:
			// textbooks
			ITextbooksDao textbooksDao = new TextbooksDaoImpl();
			Textbooks textbooks =  textbooksDao.selectById(type2id);
			textbooks.setTbstate(state);
			textbooksDao.update(textbooks);
			break;
		case 9:
			// extrabooks
			IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
			Extrabooks extrabooks =  extrabooksDao.selectById(type2id);
			
			extrabooks.setEbstate(state);
			extrabooksDao.update(extrabooks);
			break;
		case 1:
			// audios
			IAudiosDao audiosDao = new AudiosDaoImpl();
			Audios audios =  audiosDao.selectById(type2id);
			
			audios.setAudiostate(state);
			audiosDao.update(audios);
			break;
		case 2:
			// bags
			IBagsDao bagsDao = new BagsDaoImpl();
			Bags bags = bagsDao.selectById(type2id);
			
			bags.setBagstate(state);
			bagsDao.update(bags);
			break;
			//return bagsDao.selectById(typeid2);
		case 3:
			// cosmetics
			ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
			Cosmetics cosmetics = cosmeticsDao.selectById(type2id);
			
			cosmetics.setCosstate(state);
			cosmeticsDao.update(cosmetics);
			break;
			//return cosmeticsDao.selectById(typeid2);
		case 4:
			// dailypros
			IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
			Dailypros dailypros = dailyprosDao.selectById(type2id);
			
			dailypros.setDpstate(state);
			dailyprosDao.update(dailypros);
			break;
			//return dailyprosDao.selectById(typeid2);
		case 5:
			// decorations
			IDecorationsDao decorationsDao = new DecorationsDaoImpl();
			Decorations decorations = decorationsDao.selectById(type2id);
			
			decorations.setDecstate(state);
			decorationsDao.update(decorations);
			break;
			//return decorationsDao.selectById(typeid2);
		case 6:
			// digits
			IDigitsDao digitsDao = new DigitsDaoImpl();
			Digits digits = digitsDao.selectById(type2id);
			
			digits.setDigitstate(state);
			digitsDao.update(digits);
			break;
			//return digitsDao.selectById(typeid2);
		case 7:
			// electrics
			IElectricsDao electricsDao = new ElectricsDaoImpl();
			Electrics electrics = electricsDao.selectById(type2id);
			
			electrics.setElestate(state);
			electricsDao.update(electrics);
			break;
			//return electricsDao.selectById(typeid2);
		case 8:
			// entertainments
			IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
			Entertainments entertainments = entertainmentsDao.selectById(type2id);
			
			entertainments.setEnterstate(state);
			entertainmentsDao.update(entertainments);
			break;
			//return entertainmentsDao.selectById(typeid2);
		case 10:
			// females
			IFemalesDao femalesDao = new FemalesDaoImpl();
			Females females = femalesDao.selectById(type2id);
			
			females.setFemalestate(state);
			femalesDao.update(females);
			break;
			//return femalesDao.selectById(typeid2);
		case 11:
			// instruments
			IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
			Instruments instruments = instrumentsDao.selectById(type2id);
			
			instruments.setInstrumentstate(state);
			instrumentsDao.update(instruments);
			break;
			//return instrumentsDao.selectById(typeid2);
		case 12:
			// males
			IMalesDao malesDao = new MalesDaoImpl();
			Males males = malesDao.selectById(type2id);
			
			males.setMalestate(state);
			malesDao.update(males);
			break;
			//return malesDao.selectById(typeid2);
		case 13:
			// others
			IOthersDao othersDao = new OthersDaoImpl();
			Others others = othersDao.selectById(type2id);
			
			others.setOthersstate(state);
			othersDao.update(others);
			break;
			//return othersDao.selectById(typeid2);
		case 14:
			// pc
			IPcDao pcDao = new PcDaoImpl();
			Pc pc = pcDao.selectById(type2id);
			
			pc.setPcstate(state);
			pcDao.update(pc);
			break;
			//return pcDao.selectById(typeid2);
		case 15:
			// phones
			IPhonesDao phonesDao = new PhonesDaoImpl();
			Phones phones = phonesDao.selectById(type2id);
			
			phones.setPhonestate(state);
			phonesDao.update(phones);
			break;
			//return phonesDao.selectById(typeid2);
		case 16:
			// sppros
			ISpprosDao spprosDao = new SpprosDaoImpl();
			Sppros sppros = spprosDao.selectById(type2id);
			
			sppros.setSpstate(state);
			spprosDao.update(sppros);
			break;
			//return spprosDao.selectById(typeid2);
		case 17:
			// sptasts
			ISptastsDao sptastsDao = new SptastsDaoImpl();
			Sptasts sptasts = sptastsDao.selectById(type2id);
			
			sptasts.setSastate(state);
			sptastsDao.update(sptasts);
			break;
			//return sptastsDao.selectById(typeid2);
		case 18:
			// spteqpts
			ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
			Spteqpts spteqpts = spteqptsDao.selectById(type2id);
			
			spteqpts.setSestate(state);
			spteqptsDao.update(spteqpts);
			break;
			//return spteqptsDao.selectById(typeid2);
		case 20:
			// virtuals
			IVirtualsDao virtualsDao = new VirtualsDaoImpl();
			Virtuals virtuals = virtualsDao.selectById(type2id);
			
			virtuals.setVirtualstate(state);
			virtualsDao.update(virtuals);
			break;
			//return virtualsDao.selectById(typeid2);
		}
		
		if(state == 4) {
			switch (type1) {
			case 19:
				// textbooks
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				Textbooks textbooks =  textbooksDao.selectById(type1id);
				textbooks.setTbstate(state);
				textbooksDao.update(textbooks);
				break;
			case 9:
				// extrabooks
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				Extrabooks extrabooks =  extrabooksDao.selectById(type1id);
				
				extrabooks.setEbstate(state);
				extrabooksDao.update(extrabooks);
				break;
			case 1:
				// audios
				IAudiosDao audiosDao = new AudiosDaoImpl();
				Audios audios =  audiosDao.selectById(type1id);
				
				audios.setAudiostate(state);
				audiosDao.update(audios);
				break;
			case 2:
				// bags
				IBagsDao bagsDao = new BagsDaoImpl();
				Bags bags = bagsDao.selectById(type1id);
				
				bags.setBagstate(state);
				bagsDao.update(bags);
				break;
				//return bagsDao.selectById(typeid2);
			case 3:
				// cosmetics
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				Cosmetics cosmetics = cosmeticsDao.selectById(type1id);
				
				cosmetics.setCosstate(state);
				cosmeticsDao.update(cosmetics);
				break;
				//return cosmeticsDao.selectById(typeid2);
			case 4:
				// dailypros
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				Dailypros dailypros = dailyprosDao.selectById(type1id);
				
				dailypros.setDpstate(state);
				dailyprosDao.update(dailypros);
				break;
				//return dailyprosDao.selectById(typeid2);
			case 5:
				// decorations
				IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				Decorations decorations = decorationsDao.selectById(type1id);
				
				decorations.setDecstate(state);
				decorationsDao.update(decorations);
				break;
				//return decorationsDao.selectById(typeid2);
			case 6:
				// digits
				IDigitsDao digitsDao = new DigitsDaoImpl();
				Digits digits = digitsDao.selectById(type1id);
				
				digits.setDigitstate(state);
				digitsDao.update(digits);
				break;
				//return digitsDao.selectById(typeid2);
			case 7:
				// electrics
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				Electrics electrics = electricsDao.selectById(type1id);
				
				electrics.setElestate(state);
				electricsDao.update(electrics);
				break;
				//return electricsDao.selectById(typeid2);
			case 8:
				// entertainments
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				Entertainments entertainments = entertainmentsDao.selectById(type1id);
				
				entertainments.setEnterstate(state);
				entertainmentsDao.update(entertainments);
				break;
				//return entertainmentsDao.selectById(typeid2);
			case 10:
				// females
				IFemalesDao femalesDao = new FemalesDaoImpl();
				Females females = femalesDao.selectById(type1id);
				
				females.setFemalestate(state);
				femalesDao.update(females);
				break;
				//return femalesDao.selectById(typeid2);
			case 11:
				// instruments
				IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				Instruments instruments = instrumentsDao.selectById(type1id);
				
				instruments.setInstrumentstate(state);
				instrumentsDao.update(instruments);
				break;
				//return instrumentsDao.selectById(typeid2);
			case 12:
				// males
				IMalesDao malesDao = new MalesDaoImpl();
				Males males = malesDao.selectById(type1id);
				
				males.setMalestate(state);
				malesDao.update(males);
				break;
				//return malesDao.selectById(typeid2);
			case 13:
				// others
				IOthersDao othersDao = new OthersDaoImpl();
				Others others = othersDao.selectById(type1id);
				
				others.setOthersstate(state);
				othersDao.update(others);
				break;
				//return othersDao.selectById(typeid2);
			case 14:
				// pc
				IPcDao pcDao = new PcDaoImpl();
				Pc pc = pcDao.selectById(type1id);
				
				pc.setPcstate(state);
				pcDao.update(pc);
				break;
				//return pcDao.selectById(typeid2);
			case 15:
				// phones
				IPhonesDao phonesDao = new PhonesDaoImpl();
				Phones phones = phonesDao.selectById(type1id);
				
				phones.setPhonestate(state);
				phonesDao.update(phones);
				break;
				//return phonesDao.selectById(typeid2);
			case 16:
				// sppros
				ISpprosDao spprosDao = new SpprosDaoImpl();
				Sppros sppros = spprosDao.selectById(type1id);
				
				sppros.setSpstate(state);
				spprosDao.update(sppros);
				break;
				//return spprosDao.selectById(typeid2);
			case 17:
				// sptasts
				ISptastsDao sptastsDao = new SptastsDaoImpl();
				Sptasts sptasts = sptastsDao.selectById(type1id);
				
				sptasts.setSastate(state);
				sptastsDao.update(sptasts);
				break;
				//return sptastsDao.selectById(typeid2);
			case 18:
				// spteqpts
				ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				Spteqpts spteqpts = spteqptsDao.selectById(type1id);
				
				spteqpts.setSestate(state);
				spteqptsDao.update(spteqpts);
				break;
				//return spteqptsDao.selectById(typeid2);
			case 20:
				// virtuals
				IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				Virtuals virtuals = virtualsDao.selectById(type1id);
				
				virtuals.setVirtualstate(state);
				virtualsDao.update(virtuals);
				break;
				//return virtualsDao.selectById(typeid2);
			}
			
			ITradeDao tradeDao = new TradeDaoImpl();
			
			Trade trade1 = new Trade();
			trade1.setType1id1(type1);
			trade1.setType1id2(type1id);
			trade1.setType2id1(type2);
			trade1.setType2id2(type2id);
			trade1.setUserid1(user.getUserid());
			trade1.setUserid2(order.getUserid());
			trade1.setTraresource(order.getResource1());
			
			tradeDao.insert(trade1);
			
			Trade trade2 = new Trade();
			trade2.setType1id1(type2);
			trade2.setType1id2(type2id);
			trade2.setType2id1(type1);
			trade2.setType2id2(type1id);
			trade2.setUserid1(order.getUserid());
			trade2.setUserid2(user.getUserid());
			trade2.setTraresource(order.getResource2());
			
			tradeDao.insert(trade2);
		}
		
		String mark = user.getMark();
		String[] arr = mark.split("<//>");
		String str = type1 + "<&>" + type1id + "<&>" + type2 + "<&>" + type2id + "<&>";
		
		mark = "";
		int i = 0;
		for(int cnt = 0; cnt < arr.length; cnt++) {
			if(arr[cnt].contains(str)) {
				i = cnt;
			}
		}
		
		for(int cnt = 0; cnt < arr.length; cnt++) {
			if(cnt != i) {
				mark = mark + arr[cnt] + "<//>";
				System.out.println("mark:>" + mark);
			}
		}
		
		user.setMark(mark);
		
		IUsersDao usersDao = new UsersDaoImpl();
		usersDao.update(user);
		return true;
	}

}
