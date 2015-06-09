package com.nankai.exchange.biz.impl;

import java.util.List;

import com.nankai.exchange.biz.IPostBiz;
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

public class PostBizImpl implements IPostBiz {
	
	public PostBizImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean addPost(String table, Object object, Users user) {
		// TODO Auto-generated method stub
		boolean flag = false;
		List<?> lst;
		String msg = "";
		switch (table) {
		case "textbooks":
			Textbooks textbooks = (Textbooks)object;
			ITextbooksDao textbooksDao = new TextbooksDaoImpl();
			flag = textbooksDao.insert(textbooks) > 0 ? true : false;
			lst = textbooksDao.selectAll();
			msg = "textbooks<&>" + lst.size() + "<//>";
			break;
		case "extrabooks":
			Extrabooks extrabooks = (Extrabooks)object;
			IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
			flag =  extrabooksDao.insert(extrabooks) > 0 ? true : false;
			lst = extrabooksDao.selectAll();
			msg = "extrabooks<&>" + lst.size() + "<//>";
			break;
		case "audios":
			Audios audios = (Audios)object;
			IAudiosDao audiosDao = new AudiosDaoImpl();
			flag =  audiosDao.insert(audios) > 0 ? true : false;
			lst = audiosDao.selectAll();
			msg = "audios<&>" + lst.size() + "<//>";
			break;
		case "bags":
			Bags bags = (Bags)object;
			IBagsDao bagsDao = new BagsDaoImpl();
			flag =  bagsDao.insert(bags) > 0 ? true : false;
			lst = bagsDao.selectAll();
			msg = "bags<&>" + lst.size() + "<//>";
			break;
		case "cosmetics":
			Cosmetics cosmetics = (Cosmetics)object;
			ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
			flag = cosmeticsDao.insert(cosmetics) > 0 ? true : false;
			lst = cosmeticsDao.selectAll();
			msg = "cosmetics<&>" + lst.size() + "<//>";
			break;
		case "dailypros":
			Dailypros dailypros = (Dailypros)object;
			IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
			flag = dailyprosDao.insert(dailypros) > 0 ? true : false;
			lst = dailyprosDao.selectAll();
			msg = "dailypros<&>" + lst.size() + "<//>";
			break;
		case "decorations":
			Decorations decorations = (Decorations)object;
			IDecorationsDao decorationsDao = new DecorationsDaoImpl();
			flag = decorationsDao.insert(decorations) > 0 ? true : false;
			lst = decorationsDao.selectAll();
			msg = "decorations<&>" + lst.size() + "<//>";
			break;
		case "digits":
			Digits digits = (Digits)object;
			IDigitsDao digitsDao = new DigitsDaoImpl();
			flag = digitsDao.insert(digits) > 0 ? true : false;
			lst = digitsDao.selectAll();
			msg = "digits<&>" + lst.size() + "<//>";
			break;
		case "electrics":
			Electrics electrics = (Electrics)object;
			IElectricsDao electricsDao = new ElectricsDaoImpl();
			flag = electricsDao.insert(electrics) > 0 ? true : false;
			lst = electricsDao.selectAll();
			msg = "electrics<&>" + lst.size() + "<//>";
			break;
		case "entertainments":
			Entertainments entertainments = (Entertainments)object;
			IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
			flag =  entertainmentsDao.insert(entertainments) > 0 ? true :false;
			lst = entertainmentsDao.selectAll();
			msg = "entertainments<&>" + lst.size() + "<//>";
			break;
		case "females":
			Females females = (Females)object;
			IFemalesDao femalesDao = new FemalesDaoImpl();
			flag =  femalesDao.insert(females) > 0 ? true :false;
			lst = femalesDao.selectAll();
			msg = "females<&>" + lst.size() + "<//>";
			break;
		case "instruments":
			Instruments instruments = (Instruments)object;
			IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
			flag =  instrumentsDao.insert(instruments) > 0 ? true :false;
			lst = instrumentsDao.selectAll();
			msg = "instruments<&>" + lst.size() + "<//>";
			break;
		case "males":
			Males males = (Males)object;
			IMalesDao malesDao = new MalesDaoImpl();
			flag =  malesDao.insert(males) > 0 ? true :false;
			lst = malesDao.selectAll();
			msg = "males<&>" + lst.size() + "<//>";
			break;
		case "others":
			Others others = (Others)object;
			IOthersDao othersDao = new OthersDaoImpl();
			flag =  othersDao.insert(others) > 0 ? true :false;
			lst = othersDao.selectAll();
			msg = "others<&>" + lst.size() + "<//>";
			break;
		case "pc":
			Pc pc = (Pc)object;
			IPcDao pcDao = new PcDaoImpl();
			flag =  pcDao.insert(pc) > 0 ? true :false;
			lst = pcDao.selectAll();
			msg = "pc<&>" + lst.size() + "<//>";
		case "phones":
			Phones phones = (Phones)object;
			IPhonesDao phonesDao = new PhonesDaoImpl();
			flag =  phonesDao.insert(phones) > 0 ? true :false;
			lst = phonesDao.selectAll();
			msg = "phones<&>" + lst.size() + "<//>";
			break;
		case "sppros":
			Sppros sppros = (Sppros)object;
			ISpprosDao spprosDao = new SpprosDaoImpl();
			flag =  spprosDao.insert(sppros) > 0 ? true :false;
			lst = spprosDao.selectAll();
			msg = "sppros<&>" + lst.size() + "<//>";
			break;
		case "sptasts":
			Sptasts sptasts = (Sptasts)object;
			ISptastsDao sptastsDao = new SptastsDaoImpl();
			flag =  sptastsDao.insert(sptasts) > 0 ? true :false;
			lst = sptastsDao.selectAll();
			msg = "sptasts<&>" + lst.size() + "<//>";
			break;
		case "spteqpts":
			Spteqpts spteqpts = (Spteqpts)object;
			ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
			flag =  spteqptsDao.insert(spteqpts) > 0 ? true :false;
			lst = spteqptsDao.selectAll();
			msg = "spteqpts<&>" + lst.size() + "<//>";
			break;
		case "virtuals":
			Virtuals virtuals = (Virtuals)object;
			IVirtualsDao virtualsDao = new VirtualsDaoImpl();
			flag =  virtualsDao.insert(virtuals) > 0 ? true :false;
			lst = virtualsDao.selectAll();
			msg = "virtuals<&>" + lst.size() + "<//>";
			break;
		}
		
		String resource = user.getResource();
		if(resource != null) {
			user.setResource(resource + msg);
		} else {
			user.setResource(msg);
		}
		
		IUsersDao usersDao = new UsersDaoImpl();
		usersDao.update(user);
		return flag;
	}

}
