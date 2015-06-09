package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.biz.IFindMsgBiz;
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
import com.nankai.exchange.po.Msg;
import com.nankai.exchange.po.Others;
import com.nankai.exchange.po.Pc;
import com.nankai.exchange.po.Phones;
import com.nankai.exchange.po.Sppros;
import com.nankai.exchange.po.Sptasts;
import com.nankai.exchange.po.Spteqpts;
import com.nankai.exchange.po.Textbooks;
import com.nankai.exchange.po.Virtuals;

public class FindMsgBizImpl implements IFindMsgBiz {

	@Override
	public List<Msg> findAllMsgs(String resource) {
		// TODO Auto-generated method stub
		
		List<Msg> lst = new ArrayList<Msg>();
		
		String[] goods = resource.split("<//>");
		for(int cnt = 0; cnt < goods.length; cnt++) {
			
			String[] item = goods[cnt].split("<&>");
			int id = Integer.parseInt(item[1]);
			Msg msg = new Msg();
			msg.setType(item[0]);
			msg.setId(id);
			boolean flag = false;
			switch (item[0]) {
			case "textbooks":
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				Textbooks textbooks =  textbooksDao.selectById(id);
				if(textbooks.getTbstate() == 0) {
					msg.setName(textbooks.getTbname());
					msg.setPosttime(textbooks.getPosttime());
					flag = true;
				}
				break;
			case "extrabooks":
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				Extrabooks extrabooks =  extrabooksDao.selectById(id);
				if(extrabooks.getEbstate() == 0 ) {
					msg.setName(extrabooks.getEbname());
					msg.setPosttime(extrabooks.getPosttime());
					flag = true;
				}
				break;
			case "audios":
				IAudiosDao audiosDao = new AudiosDaoImpl();
				Audios audios =  audiosDao.selectById(id);
				if(audios.getAudiostate() == 0) {
					msg.setName(audios.getAudioname());
					msg.setPosttime(audios.getPosttime());
					flag = true;
				}
				break;
			case "bags":
				IBagsDao bagsDao = new BagsDaoImpl();
				Bags bags = bagsDao.selectById(id);
				if(bags.getBagstate() == 0) {
					msg.setName(bags.getBagbrand() + bags.getBagtype());
					msg.setPosttime(bags.getPosttime());
					flag = true;
				}
				break;
			case "cosmetics":
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				Cosmetics cosmetics = cosmeticsDao.selectById(id);
				if(cosmetics.getCosstate() == 0) {
					msg.setName(cosmetics.getCosname());
					msg.setPosttime(cosmetics.getPosttime());
					flag = true;
				}
				
				break;
			case "dailypros":
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				Dailypros dailypros = dailyprosDao.selectById(id);
				if(dailypros.getDpstate() == 0) {
					msg.setName(dailypros.getDpname());
					msg.setPosttime(dailypros.getPosttime());
					flag = true;
				}
				break;
			case "decorations":
				IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				Decorations decorations = decorationsDao.selectById(id);
				if(decorations.getDecstate() == 0) {
					msg.setName(decorations.getDecname());
					msg.setPosttime(decorations.getPosttime());
					flag = true;
				}
				break;
			case "digits":
				IDigitsDao digitsDao = new DigitsDaoImpl();
				Digits digits = digitsDao.selectById(id);
				if(digits.getDigitstate() == 0) {
					msg.setName(digits.getDigitbrand());
					msg.setPosttime(digits.getPosttime());
					flag = true;
				}
				break;
			case "electrics":
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				Electrics electrics = electricsDao.selectById(id);
				if(electrics.getElestate() == 0) {
					msg.setName(electrics.getElename());
					msg.setPosttime(electrics.getPosttime());
					flag = true;
				}
				break;
			case "entertainments":
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				Entertainments entertainments = entertainmentsDao.selectById(id);
				if(entertainments.getEnterstate() == 0) {
					msg.setName(entertainments.getEntername());
					msg.setPosttime(entertainments.getPosttime());
					flag = true;
				}
				break;
			case "females":
				IFemalesDao femalesDao = new FemalesDaoImpl();
				Females females = femalesDao.selectById(id);
				if(females.getFemalestate() == 0) {
					msg.setName(females.getFemaletype());
					msg.setPosttime(females.getPosttime());
					flag = true;
				}
				
				break;
			case "instruments":
				IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				Instruments instruments = instrumentsDao.selectById(id);
				if(instruments.getInstrumentstate() == 0) {
					msg.setName(instruments.getInstrumentname());
					msg.setPosttime(instruments.getPosttime());
					flag = true;
				}
				
				break;
			case "males":
				IMalesDao malesDao = new MalesDaoImpl();
				Males males = malesDao.selectById(id);
				if(males.getMalestate() == 0) {
					msg.setName(males.getMaletype());
					msg.setPosttime(males.getPosttime());
					flag = true;
				}
				
				break;
			case "others":
				IOthersDao othersDao = new OthersDaoImpl();
				Others others = othersDao.selectById(id);
				if(others.getOthersstate() == 0) {
					msg.setName(others.getOthersname());
					msg.setPosttime(others.getPosttime());
					flag = true;
				}
				
				break;
			case "pc":
				IPcDao pcDao = new PcDaoImpl();
				Pc pc = pcDao.selectById(id);
				if(pc.getPcstate() == 0) {
					msg.setName(pc.getPcmodel());
					msg.setPosttime(pc.getPosttime());
					flag = true;
				}
				
				break;
			case "phones":
				IPhonesDao phonesDao = new PhonesDaoImpl();
				Phones phones = phonesDao.selectById(id);
				if(phones.getPhonestate() == 0) {
					msg.setName(phones.getPhonebrand());
					msg.setPosttime(phones.getPosttime());
					flag = true;
				}
				
				break;
			case "sppros":
				ISpprosDao spprosDao = new SpprosDaoImpl();
				Sppros sppros = spprosDao.selectById(id);
				if(sppros.getSpstate() == 0) {
					msg.setName(sppros.getSpname());
					msg.setPosttime(sppros.getPosttime());
					flag = true;
				}
				
				break;
			case "sptasts":
				ISptastsDao sptastsDao = new SptastsDaoImpl();
				Sptasts sptasts = sptastsDao.selectById(id);
				if(sptasts.getSastate() == 0) {
					msg.setName(sptasts.getSaname());
					msg.setPosttime(sptasts.getPosttime());
					flag = true;
				}
				
				break;
			case "spteqpts":
				ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				Spteqpts spteqpts = spteqptsDao.selectById(id);
				if(spteqpts.getSestate() == 0) {
					msg.setName(spteqpts.getSename());
					msg.setPosttime(spteqpts.getPosttime());
					flag = true;
				}
				
				break;
			case "virtuals":
				IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				Virtuals virtuals = virtualsDao.selectById(id);
				if(virtuals.getVirtualstate() == 0) {
					msg.setName(virtuals.getVirtualname());
					msg.setPosttime(virtuals.getPosttime());
					flag = true;
				}
				
				break;
			}
			if(flag) {
				lst.add(msg);
			}
		}
		
		return lst;
	}

}
