package com.nankai.exchange.biz.impl;

import com.nankai.exchange.biz.IDetailBiz;
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
import com.nankai.exchange.po.Users;

public class DetailBizImpl implements IDetailBiz {

	@Override
	public Object[] findItem(String type, int typeid) {
		// TODO Auto-generated method stub
		
		Object object = null;
		int uid = 0;
		
		switch (type) {
		case "textbooks":
			ITextbooksDao textbooksDao = new TextbooksDaoImpl();
			object = textbooksDao.selectById(typeid);
			uid = textbooksDao.selectById(typeid).getUid();
			break;
		case "extrabooks":
			IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
			object = extrabooksDao.selectById(typeid);
			uid = extrabooksDao.selectById(typeid).getUid();
			break;
		case "audios":
			IAudiosDao audiosDao = new AudiosDaoImpl();
			object = audiosDao.selectById(typeid);
			uid = audiosDao.selectById(typeid).getUid();
			break;
		case "bags":
			IBagsDao bagsDao = new BagsDaoImpl();
			object = bagsDao.selectById(typeid);
			uid = bagsDao.selectById(typeid).getUid();
			break;
		case "cosmetics":
			ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
			object = cosmeticsDao.selectById(typeid);
			uid = cosmeticsDao.selectById(typeid).getUid();
			break;
		case "dailypros":
			IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
			object = dailyprosDao.selectById(typeid);
			uid = dailyprosDao.selectById(typeid).getUid();
			break;
		case "decorations":
			IDecorationsDao decorationsDao = new DecorationsDaoImpl();
			object = decorationsDao.selectById(typeid);
			uid = decorationsDao.selectById(typeid).getUid();
			break;
		case "digits":
			IDigitsDao digitsDao = new DigitsDaoImpl();
			object = digitsDao.selectById(typeid);
			uid = digitsDao.selectById(typeid).getUid();
			break;
		case "electrics":
			IElectricsDao electricsDao = new ElectricsDaoImpl();
			object = electricsDao.selectById(typeid);
			uid = electricsDao.selectById(typeid).getUid();
			break;
		case "entertainments":
			IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
			object = entertainmentsDao.selectById(typeid);
			uid = entertainmentsDao.selectById(typeid).getUid();
			break;
		case "females":
			IFemalesDao femalesDao = new FemalesDaoImpl();
			object = femalesDao.selectById(typeid);
			uid = femalesDao.selectById(typeid).getUid();
			break;
		case "instruments":
			IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
			object = instrumentsDao.selectById(typeid);
			uid = instrumentsDao.selectById(typeid).getUid();
			break;
		case "males":
			IMalesDao malesDao = new MalesDaoImpl();
			object = malesDao.selectById(typeid);
			uid = malesDao.selectById(typeid).getUid();
			break;
		case "others":
			IOthersDao othersDao = new OthersDaoImpl();
			object = othersDao.selectById(typeid);
			uid = othersDao.selectById(typeid).getUid();
		case "pc":
			IPcDao pcDao = new PcDaoImpl();
			object = pcDao.selectById(typeid);
			uid = pcDao.selectById(typeid).getUid();
			break;
		case "phones":
			IPhonesDao phonesDao = new PhonesDaoImpl();
			object = phonesDao.selectById(typeid);
			uid = phonesDao.selectById(typeid).getUid();
			break;
		case "sppros":
			ISpprosDao spprosDao = new SpprosDaoImpl();
			object = spprosDao.selectById(typeid);
			uid = spprosDao.selectById(typeid).getUid();
			break;
		case "sptasts":
			ISptastsDao sptastsDao = new SptastsDaoImpl();
			object = sptastsDao.selectById(typeid);
			uid = sptastsDao.selectById(typeid).getUid();
			break;
		case "spteqpts":
			ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
			object = spteqptsDao.selectById(typeid);
			uid = spteqptsDao.selectById(typeid).getUid();
			break;
		case "virtuals":
			IVirtualsDao virtualsDao = new VirtualsDaoImpl();
			object = virtualsDao.selectById(typeid);
			uid = virtualsDao.selectById(typeid).getUid();
			break;
		}
		
		IUsersDao usersDao = new UsersDaoImpl();
		
		Users user = usersDao.selectById(uid);
		
		Object[] aobj = new Object[] {object, user};
		
		return aobj;
	}

}
