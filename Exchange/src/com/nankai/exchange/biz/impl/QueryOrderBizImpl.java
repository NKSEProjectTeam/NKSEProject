package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.biz.IQueryOrderBiz;
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
import com.nankai.exchange.po.TradeOrder;
import com.nankai.exchange.po.Users;
import com.nankai.exchange.po.Virtuals;

public class QueryOrderBizImpl implements IQueryOrderBiz {

	private ITradeDao tradeDao;
	@SuppressWarnings("unused")
	private IUsersDao usersDao;
	
	@SuppressWarnings("unused")
	private IAudiosDao audiosDao;
	@SuppressWarnings("unused")
	private IBagsDao bagsDao;
	@SuppressWarnings("unused")
	private ICosmeticsDao cosmeticsDao;
	@SuppressWarnings("unused")
	private IDailyprosDao dailyprosDao;
	@SuppressWarnings("unused")
	private IDecorationsDao decorationsDao;
	@SuppressWarnings("unused")
	private IDigitsDao digitsDao;
	@SuppressWarnings("unused")
	private IElectricsDao electricsDao;
	@SuppressWarnings("unused")
	private IEntertainmentsDao entertainmentsDao;
	@SuppressWarnings("unused")
	private IExtrabooksDao extrabooksDao;
	@SuppressWarnings("unused")
	private IFemalesDao femalesDaoImpl;
	@SuppressWarnings("unused")
	private IInstrumentsDao instrumentsDao;
	@SuppressWarnings("unused")
	private IMalesDao malesDao;
	@SuppressWarnings("unused")
	private IOthersDao othersDao;
	@SuppressWarnings("unused")
	private IPcDao pcDao;
	@SuppressWarnings("unused")
	private IPhonesDao phonesDao;
	@SuppressWarnings("unused")
	private ISpprosDao spprosDao;
	@SuppressWarnings("unused")
	private ISptastsDao sptastsDao;
	@SuppressWarnings("unused")
	private ISpteqptsDao spteqptsDao;
	@SuppressWarnings("unused")
	private ITextbooksDao textbooksDao;
	@SuppressWarnings("unused")
	private IVirtualsDao virtualsDao;
	
	

	public QueryOrderBizImpl() {
		super();
		// TODO Auto-generated constructor stub
		this.tradeDao = new TradeDaoImpl();
		this.usersDao = new UsersDaoImpl();
		this.audiosDao = new AudiosDaoImpl();
		this.bagsDao = new BagsDaoImpl();
		this.cosmeticsDao = new CosmeticsDaoImpl();
		this.dailyprosDao = new DailyprosDaoImpl();
		this.decorationsDao = new DecorationsDaoImpl();
		this.digitsDao = new DigitsDaoImpl();
		this.electricsDao = new ElectricsDaoImpl();
		this.entertainmentsDao = new EntertainmentsDaoImpl();
		this.extrabooksDao = new ExtralbooksDaoImpl();
		this.femalesDaoImpl = new FemalesDaoImpl();
		this.instrumentsDao = new InstrumentsDaoImpl();
		this.malesDao = new MalesDaoImpl();
		this.othersDao = new OthersDaoImpl();
		this.pcDao = new PcDaoImpl();
		this.phonesDao = new PhonesDaoImpl();
		this.spprosDao = new SpprosDaoImpl();
		this.sptastsDao = new SptastsDaoImpl();
		this.spteqptsDao = new SpteqptsDaoImpl();
		this.textbooksDao = new TextbooksDaoImpl();
		this.virtualsDao = new VirtualsDaoImpl();
	}



	@Override
	public List<TradeOrder> queryOrder(int userid1) {
		// TODO Auto-generated method stub
		List<TradeOrder> lstTradeOrder = new ArrayList<TradeOrder>();
		//获取用户1的交易信息,分离userid2,typeid1.typeid2,traresource
		List<Trade> lstUsers = tradeDao.selectUserId(userid1);
		for (Trade trade : lstUsers) {
			
			TradeOrder tradeOrder = new TradeOrder();
			tradeOrder.setUserid2(trade.getUserid2());
			tradeOrder.setTradetime(trade.getTratime());
			tradeOrder.setTraresource(trade.getTraresource());
			tradeOrder.setType1id1(trade.getType1id1());
			tradeOrder.setType1id2(trade.getType1id2());
			tradeOrder.setType2id1(trade.getType2id1());
			tradeOrder.setType2id2(trade.getType2id2());
			
			int type1id1 = trade.getType1id1();
			int type1id2 = trade.getType1id2();
			int type2id1 = trade.getType2id1();
			int type2id2 = trade.getType2id2();
			
			switch (type1id1) {
			//audios
			case 1:
				IAudiosDao audiosDao = new AudiosDaoImpl();
				Audios audios = audiosDao.selectById(type1id2);
				tradeOrder.setProname1(audios.getAudioname());
				break;
			//bags
			case 2:
				IBagsDao bagsDao = new BagsDaoImpl();
				Bags bags = bagsDao.selectById(type1id2);
				tradeOrder.setProname1(bags.getBagbrand());
				break;
			//cosmetics
			case 3:
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				Cosmetics cosmetics = cosmeticsDao.selectById(type1id2);
				tradeOrder.setProname1(cosmetics.getCosname());
				break;
			//dailypros
			case 4:
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				Dailypros dailypros = dailyprosDao.selectById(type1id2);
				tradeOrder.setProname1(dailypros.getDpname());
				break;
			//decorations
			case 5:
				IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				Decorations decorations = decorationsDao.selectById(type1id2);
				tradeOrder.setProname1(decorations.getDecname());
				break;
			//digits
			case 6:
				IDigitsDao digitsDao = new DigitsDaoImpl();
				Digits digits = digitsDao.selectById(type1id2);
				tradeOrder.setProname1(digits.getDigitmodel());
				break;
			//electrics
			case 7:
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				Electrics electrics = electricsDao.selectById(type1id2);
				tradeOrder.setProname1(electrics.getElename());
				break;
			//entertainments
			case 8:
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				Entertainments entertainments = entertainmentsDao.selectById(type1id2);
				tradeOrder.setProname1(entertainments.getEntername());
				break;
			//extrabooks
			case 9:
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				Extrabooks extrabooks = extrabooksDao.selectById(type1id2);
				tradeOrder.setProname1(extrabooks.getEbname());
				break;
			//females 
			case 10:
				IFemalesDao femalesDao = new FemalesDaoImpl();
				Females females = femalesDao.selectById(type1id2);
				tradeOrder.setProname1(females.getFemaletype());
				break;
			//instruments
			case 11:
				IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				Instruments instruments = instrumentsDao.selectById(type1id2);
				tradeOrder.setProname1(instruments.getInstrumentname());
				break;
			//males 
			case 12:
				IMalesDao malesDao = new MalesDaoImpl();
				Males males = malesDao.selectById(type1id2);
				tradeOrder.setProname1(males.getMaletype());
				break;
			//others 
			case 13:
				IOthersDao othersDao = new OthersDaoImpl();
				Others others = othersDao.selectById(type1id2);
				tradeOrder.setProname1(others.getOthersname());
				break;
			//pc
			case 14:
				IPcDao pcDao = new PcDaoImpl();
				Pc pc = pcDao.selectById(type1id2);
				tradeOrder.setProname1(pc.getPcmodel());
				break;
			//phones
			case 15:
				IPhonesDao phonesDao = new PhonesDaoImpl();
				Phones phones = phonesDao.selectById(type1id2);
				tradeOrder.setProname1(phones.getPhonemodel());
				break;
			//sppros 
			case 16:
				ISpprosDao spprosDao = new SpprosDaoImpl();
				Sppros sppros = spprosDao.selectById(type1id2);
				tradeOrder.setProname1(sppros.getSpname());
				break;
			//sptasts
			case 17:
				ISptastsDao sptastsDao = new SptastsDaoImpl();
				Sptasts sptasts = sptastsDao.selectById(type1id2);
				tradeOrder.setProname1(sptasts.getSaname());
				break;
			//spteqpts 
			case 18:
				ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				Spteqpts spteqpts = spteqptsDao.selectById(type1id2);
				tradeOrder.setProname1(spteqpts.getSename());
				break;
			//textbooks 
			case 19:
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				Textbooks textbooks = textbooksDao.selectById(type1id2);
				tradeOrder.setProname1(textbooks.getTbname());
				break;
			//virtuals 
			case 20:
				IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				Virtuals virtuals = virtualsDao.selectById(type1id2);
				tradeOrder.setProname1(virtuals.getVirtualname());
				break;
			//error
			default:
				break;
			}
			
			switch (type2id1) {
			//audios
			case 1:
				IAudiosDao audiosDao = new AudiosDaoImpl();
				Audios audios = audiosDao.selectById(type2id2);
				tradeOrder.setProname2(audios.getAudioname());
				break;
			//bags
			case 2:
				IBagsDao bagsDao = new BagsDaoImpl();
				Bags bags = bagsDao.selectById(type2id2);
				tradeOrder.setProname2(bags.getBagbrand());
				break;
			//cosmetics
			case 3:
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				Cosmetics cosmetics = cosmeticsDao.selectById(type2id2);
				tradeOrder.setProname2(cosmetics.getCosname());
				break;
			//dailypros
			case 4:
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				Dailypros dailypros = dailyprosDao.selectById(type2id2);
				tradeOrder.setProname2(dailypros.getDpname());
				break;
			//decorations
			case 5:
				IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				Decorations decorations = decorationsDao.selectById(type2id2);
				tradeOrder.setProname2(decorations.getDecname());
				break;
			//digits
			case 6:
				IDigitsDao digitsDao = new DigitsDaoImpl();
				Digits digits = digitsDao.selectById(type2id2);
				tradeOrder.setProname2(digits.getDigitmodel());
				break;
			//electrics
			case 7:
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				Electrics electrics = electricsDao.selectById(type2id2);
				tradeOrder.setProname2(electrics.getElename());
				break;
			//entertainments
			case 8:
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				Entertainments entertainments = entertainmentsDao.selectById(type2id2);
				tradeOrder.setProname2(entertainments.getEntername());
				break;
			//extrabooks
			case 9:
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				Extrabooks extrabooks = extrabooksDao.selectById(type2id2);
				tradeOrder.setProname2(extrabooks.getEbname());
				break;
			//females 
			case 10:
				IFemalesDao femalesDao = new FemalesDaoImpl();
				Females females = femalesDao.selectById(type2id2);
				tradeOrder.setProname2(females.getFemaletype());
				break;
			//instruments
			case 11:
				IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				Instruments instruments = instrumentsDao.selectById(type2id2);
				tradeOrder.setProname2(instruments.getInstrumentname());
				break;
			//males 
			case 12:
				IMalesDao malesDao = new MalesDaoImpl();
				Males males = malesDao.selectById(type2id2);
				tradeOrder.setProname2(males.getMaletype());
				break;
			//others 
			case 13:
				IOthersDao othersDao = new OthersDaoImpl();
				Others others = othersDao.selectById(type2id2);
				tradeOrder.setProname2(others.getOthersname());
				break;
			//pc
			case 14:
				IPcDao pcDao = new PcDaoImpl();
				Pc pc = pcDao.selectById(type2id2);
				tradeOrder.setProname2(pc.getPcmodel());
				break;
			//phones
			case 15:
				IPhonesDao phonesDao = new PhonesDaoImpl();
				Phones phones = phonesDao.selectById(type2id2);
				tradeOrder.setProname2(phones.getPhonemodel());
				break;
			//sppros 
			case 16:
				ISpprosDao spprosDao = new SpprosDaoImpl();
				Sppros sppros = spprosDao.selectById(type2id2);
				tradeOrder.setProname2(sppros.getSpname());
				break;
			//sptasts
			case 17:
				ISptastsDao sptastsDao = new SptastsDaoImpl();
				Sptasts sptasts = sptastsDao.selectById(type2id2);
				tradeOrder.setProname2(sptasts.getSaname());
				break;
			//spteqpts 
			case 18:
				ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				Spteqpts spteqpts = spteqptsDao.selectById(type2id2);
				tradeOrder.setProname2(spteqpts.getSename());
				break;
			//textbooks 
			case 19:
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				Textbooks textbooks = textbooksDao.selectById(type2id2);
				tradeOrder.setProname2(textbooks.getTbname());
				break;
			//virtuals 
			case 20:
				IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				Virtuals virtuals = virtualsDao.selectById(type2id2);
				tradeOrder.setProname2(virtuals.getVirtualname());
				break;
			//error
			default:
				break;
			}
			
			IUsersDao usersDao = new UsersDaoImpl();
			Users user = usersDao.selectById(trade.getUserid2());
			tradeOrder.setUsername2(user.getUsername());
			
			lstTradeOrder.add(tradeOrder);
			
		}
	
		return lstTradeOrder;
	}

}
