package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.biz.IQueryHireBiz;
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
import com.nankai.exchange.dao.IHireDao;
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
import com.nankai.exchange.dao.impl.HireDaoImpl;
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
import com.nankai.exchange.po.Bags;
import com.nankai.exchange.po.Cosmetics;
import com.nankai.exchange.po.Dailypros;
import com.nankai.exchange.po.Decorations;
import com.nankai.exchange.po.Digits;
import com.nankai.exchange.po.Electrics;
import com.nankai.exchange.po.Entertainments;
import com.nankai.exchange.po.Extrabooks;
import com.nankai.exchange.po.Females;
import com.nankai.exchange.po.Hire;
import com.nankai.exchange.po.HireOrder;
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

public class QueryHireBizImpl implements IQueryHireBiz {

	@Override
	public List<HireOrder> findHireOrder(int userid) {
		// TODO Auto-generated method stub
		
		// 准备返回列表
		List<HireOrder> lstHireOrder = new ArrayList<HireOrder>();
		
		
		// 获取租用订单
		IHireDao hireDao = new HireDaoImpl();
		List<Hire> lstHire = hireDao.selectUserId(userid);
		
		IUsersDao usersDao = new UsersDaoImpl();
		
		for(Hire hire : lstHire) {
			HireOrder hireOrder = new HireOrder();
			hireOrder.setHireresource(hire.getHireresource());
			hireOrder.setHiretime(hire.getHiretime());
			hireOrder.setTypeid1(hire.getTypeid1());
			hireOrder.setTypeid2(hire.getTypeid2());
			hireOrder.setUserid2(hire.getUserid2());
			Users user = usersDao.selectById(hire.getUserid2());
			hireOrder.setUsername2(user.getUsername());
			
			int typeid1 = hire.getTypeid1();
			int typeid2 = hire.getTypeid2();
			switch (typeid1) {
			case 1:
				// audio
				IAudiosDao audiosDao = new AudiosDaoImpl();
				hireOrder.setName(audiosDao.selectById(typeid2).getAudioname());
				break;
			case 2:
				// bag
				IBagsDao bagsDao = new BagsDaoImpl();
				Bags bags = bagsDao.selectById(typeid2);
				hireOrder.setName(bags.getBagbrand() + bags.getBagtype());
				break;
			case 3:
				// cosmetics
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				Cosmetics cosmetics = cosmeticsDao.selectById(typeid2);
				hireOrder.setName(cosmetics.getCosbrand() + cosmetics.getCosname());
			case 4:
				// dailypros
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				Dailypros dailypros = dailyprosDao.selectById(typeid2);
				hireOrder.setName(dailypros.getDpname());
				break;
			case 5:
				// decorations
				IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				Decorations decorations = decorationsDao.selectById(typeid2);
				hireOrder.setName(decorations.getDecname());
				break;
			case 6:
				IDigitsDao digitsDao = new DigitsDaoImpl();
				Digits digits = digitsDao.selectById(typeid2);
				hireOrder.setName(digits.getDigitbrand() + digits.getDigitmodel());
				break;
			case 7:
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				Electrics electrics = electricsDao.selectById(typeid2);
				hireOrder.setName(electrics.getElename());
				break;
			case 8:
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				Entertainments entertainments = entertainmentsDao.selectById(typeid2);
				hireOrder.setName(entertainments.getEntername());
				break;
			case 9:
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				Extrabooks extrabooks = extrabooksDao.selectById(typeid2);
				hireOrder.setName(extrabooks.getEbname());
				break;
			case 10:
				IFemalesDao femalesDao = new FemalesDaoImpl();
				Females females = femalesDao.selectById(typeid2);
				hireOrder.setName(females.getFemaletype());
				break;
			case 11:
				IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				Instruments instruments = instrumentsDao.selectById(typeid2);
				hireOrder.setName(instruments.getInstrumentname());
				break;
			case 12:
				IMalesDao malesDao = new MalesDaoImpl();
				Males males = malesDao.selectById(typeid2);
				hireOrder.setName(males.getMaletype());
				break;
			case 13:
				IOthersDao othersDao = new OthersDaoImpl();
				Others others = othersDao.selectById(typeid2);
				hireOrder.setName(others.getOthersname());
				break;
			case 14:
				IPcDao pcDao = new PcDaoImpl();
				Pc pc = pcDao.selectById(typeid2);
				hireOrder.setName(pc.getPcbrand() + pc.getPcmodel() + pc.getPctype());
				break;
			case 15:
				IPhonesDao phonesDao = new PhonesDaoImpl();
				Phones phones = phonesDao.selectById(typeid2);
				hireOrder.setName(phones.getPhonebrand() + phones.getPhonemodel() + phones.getPhonetype());
				break;
			case 16:
				ISpprosDao spprosDao = new SpprosDaoImpl();
				Sppros sppros = spprosDao.selectById(typeid2);
				hireOrder.setName(sppros.getSplocation() + sppros.getSpname());
				break;
			case 17:
				ISptastsDao sptastsDao = new SptastsDaoImpl();
				Sptasts sptasts = sptastsDao.selectById(typeid2);
				hireOrder.setName(sptasts.getSaname());
				break;
			case 18:
				ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				Spteqpts spteqpts = spteqptsDao.selectById(typeid2);
				hireOrder.setName(spteqpts.getSename());
				break;
			case 19:
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				Textbooks textbooks = textbooksDao.selectById(typeid2);
				hireOrder.setName(textbooks.getTbname());
				break;
			case 20:
				IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				Virtuals virtuals = virtualsDao.selectById(typeid2);
				hireOrder.setName(virtuals.getVirtualname());
				break;
			default:
				break;
			}
			lstHireOrder.add(hireOrder);
		}
		return lstHireOrder;
	}

}
