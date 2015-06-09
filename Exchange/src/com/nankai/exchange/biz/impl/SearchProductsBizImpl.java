package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.ISearchProductsBiz;
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

public class SearchProductsBizImpl implements ISearchProductsBiz {
	
	
	private IAudiosDao audiosDao;
	private IBagsDao bagsDao;
	private ICosmeticsDao cosmeticsDao;
	private IDailyprosDao dailyprosDao;
	private IDecorationsDao decorationsDao;
	private IDigitsDao digitsDao;
	private IElectricsDao electricsDao;
	private IEntertainmentsDao entertainmentsDao;
	private IExtrabooksDao extrabooksDao;
	private IFemalesDao femalesDaoImpl;
	private IInstrumentsDao instrumentsDao;
	private IMalesDao malesDao;
	private IOthersDao othersDao;
	private IPcDao pcDao;
	private IPhonesDao phonesDao;
	private ISpprosDao spprosDao;
	private ISptastsDao sptastsDao;
	private ISpteqptsDao spteqptsDao;
	private ITextbooksDao textbooksDao;
	private IVirtualsDao virtualsDao;
	
	public SearchProductsBizImpl() {
		super();
		// TODO Auto-generated constructor stub
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
	public List<?> searchProductsByName(String name, int id) {
		// TODO Auto-generated method stub
		switch (id) {
		//audios
		case 1:
			return this.audiosDao.selectByName(name);
		//bags
		case 2:
			return this.bagsDao.selectByName(name);
		//cosmetics
		case 3:
			return this.cosmeticsDao.selectByName(name);
		//dailypros
		case 4:
			return this.dailyprosDao.selectByName(name);
		//decorations
		case 5:
			return this.decorationsDao.selectByName(name);
		//digits
		case 6:
			return this.digitsDao.selectByName(name);
		//electrics
		case 7:
			return this.electricsDao.selectByName(name);
		//entertainments
		case 8:
			return this.entertainmentsDao.selectByName(name);
		//extrabooks
		case 9:
			return this.extrabooksDao.selectByName(name);
		//females 
		case 10:
			return this.femalesDaoImpl.selectByName(name);
		//instruments
		case 11:
			return this.instrumentsDao.selectByName(name);
		//males 
		case 12:
			return this.malesDao.selectByName(name);
		//others 
		case 13:
			return this.othersDao.selectByName(name);
		//pc
		case 14:
			return this.pcDao.selectByName(name);
		//phones
		case 15:
			return this.phonesDao.selectByName(name);
		//sppros 
		case 16:
			return this.spprosDao.selectByName(name);
		//sptasts
		case 17:
			return this.sptastsDao.selectByName(name);
		//spteqpts 
		case 18:
			return this.spteqptsDao.selectByName(name);
		//textbooks 
		case 19:
			return this.textbooksDao.selectByName(name);
		//virtuals 
		case 20:
			return this.virtualsDao.selectByName(name);
		//error
		default:
			return null;
		}
	}

}
