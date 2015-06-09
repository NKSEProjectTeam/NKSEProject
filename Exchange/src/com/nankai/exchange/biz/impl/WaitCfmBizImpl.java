package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;

import com.nankai.exchange.biz.IWaitCfmBiz;
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
import com.nankai.exchange.po.WaitOrder;

public class WaitCfmBizImpl implements IWaitCfmBiz {

	@Override
	public List<WaitOrder> findWaitCfm(Users user) {
		// TODO Auto-generated method stub
		
		//待确认订单
		
		String mark = user.getMark();
		
		System.out.println("mark:>" + mark);
		
		String[] lstStr = null;
		List<WaitOrder> lstPro = new ArrayList<WaitOrder>();
		
		if(mark != null && !mark.isEmpty()) {
			lstStr = user.getMark().split("<//>");
			
			//System.out.println("lstStr.length:>" + lstStr.length);
			
			//lstId 包含5个数组   数组 = typeId1 id1 + typeid2 id2 + userid2 + mark中的位置
			List<String[]> lstId = new ArrayList<String[]>();
			for (int i = 0; i < lstStr.length; i++) {
				String[] temp = lstStr[i].split("<&>");
				lstId.add(temp);
			}
			
			//待确认交易数量
			int lstSize = lstId.size();
			System.out.println("lstSize is : " + lstSize );
			
			//发送session，待确认消息数量
			//session.setAttribute("lstSize", lstSize);
			
			//二维数组存放所有id
			Integer[][] intId = new Integer[lstSize][6];
			int j = 0;
			for (String[] strings : lstId) {
				for (int i = 0; i < strings.length; i++) {
					intId[j][i] = Integer.parseInt(strings[i]);
				}
				j++;
			}
			
			//WaitOrder对象封装
						
			for (int i = 0; i < lstSize; i++) {
				WaitOrder waitOrder = new WaitOrder();
				//商品1
				switch (intId[i][0]) {
				case 1:
					IAudiosDao audiosDao = new AudiosDaoImpl();
					Audios audios = audiosDao.selectById(intId[i][1]);
					waitOrder.setTypeid1(1);
					waitOrder.setId1(audios.getAudioid());
					waitOrder.setName1(audios.getAudioname());
					waitOrder.setResource1(audios.getAudioresource());
					break;
				case  2:  
					IBagsDao bagsDao = new BagsDaoImpl();
					Bags bags = bagsDao.selectById(intId[i][1]);
					waitOrder.setTypeid1(2);
					waitOrder.setId1(bags.getBagid());
					waitOrder.setName1(bags.getBagbrand());
					waitOrder.setResource1(bags.getBagresource());
				    break;
				case  3:
				    ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				    Cosmetics cosmetics = cosmeticsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(3);
					waitOrder.setId1(cosmetics.getCosid());
					waitOrder.setName1(cosmetics.getCosname());
					waitOrder.setResource1(cosmetics.getCosresource());
				    break;
				    
				case  5:
				    IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				    Decorations decorations = decorationsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(5);
					waitOrder.setId1(decorations.getDecid());
					waitOrder.setName1(decorations.getDecname());
					waitOrder.setResource1(decorations.getDecresource());
				    break;
				case  6:
				    IDigitsDao digitsDao = new DigitsDaoImpl();
				    Digits digits = digitsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(6);
					waitOrder.setId1(digits.getDigitid());
					waitOrder.setName1(digits.getDigitbrand() + digits.getDigitmodel());
					waitOrder.setResource1(digits.getDigitresource());
				    break;
				case  9:
					IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
					Extrabooks extrabooks = extrabooksDao.selectById(intId[i][1]);
					waitOrder.setTypeid1(9);
					waitOrder.setId1(extrabooks.getEbid());
					waitOrder.setName1(extrabooks.getEbname());
					waitOrder.setResource1(extrabooks.getEbresource());
				    break;
				    
				case  10:
				    IFemalesDao femalesDao = new FemalesDaoImpl();
				    Females females = femalesDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(10);
					waitOrder.setId1(females.getFemaleid());
					waitOrder.setName1(females.getFemaletype() + females.getFemalesize());
					waitOrder.setResource1(females.getFemaleresource());
				    break;
				case  11:
				    IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				    Instruments instruments = instrumentsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(11);
					waitOrder.setId1(instruments.getInstrumentid());
					waitOrder.setName1(instruments.getInstrumentname());
					waitOrder.setResource1(instruments.getInstrumentresource());
				    break;
				case  12:
				    IMalesDao malesDao = new MalesDaoImpl();
				    Males males = malesDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(12);
					waitOrder.setId1(males.getMaleid());
					waitOrder.setName1(males.getMaletype() + males.getMalesize());
					waitOrder.setResource1(males.getMaleresource());
				    break;
				case  13:
				    IOthersDao othersDao = new OthersDaoImpl();
				    Others others = othersDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(13);
					waitOrder.setId1(others.getOtherid());
					waitOrder.setName1(others.getOthersname());
					waitOrder.setResource1(others.getOtherresource());
				    break;
				case  14:
				    IPcDao pcDao = new PcDaoImpl();
				    Pc pc = pcDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(14);
					waitOrder.setId1(pc.getPcid());
					waitOrder.setName1(pc.getPcbrand() + pc.getPcmodel());
					waitOrder.setResource1(pc.getPcresource());
				    break;
				case  15:
				    IPhonesDao phonesDao = new PhonesDaoImpl();
				    Phones phones = phonesDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(15);
					waitOrder.setId1(phones.getPhoneid());
					waitOrder.setName1(phones.getPhonebrand() + phones.getPhonemodel());
					waitOrder.setResource1(phones.getPhoneresource());
				    break;
				case  17:
				    ISptastsDao sptastsDao = new SptastsDaoImpl();
				    Sptasts sptasts = sptastsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(17);
					waitOrder.setId1(sptasts.getSaid());
					waitOrder.setName1(sptasts.getSaname());
					waitOrder.setResource1(sptasts.getSaresource());
				    break;
				case  18:
				    ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				    Spteqpts spteqpts = spteqptsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(18);
					waitOrder.setId1(spteqpts.getSeid());
					waitOrder.setName1(spteqpts.getSename());
					waitOrder.setResource1(spteqpts.getSeresource());
				    break;
				case  19:
				    ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				    Textbooks textbooks = textbooksDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(19);
					waitOrder.setId1(textbooks.getTbid());
					waitOrder.setName1(textbooks.getTbname());
					waitOrder.setResource1(textbooks.getTbresource());
				    break;
				case  20:
				    IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				    Virtuals virtuals = virtualsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(20);
					waitOrder.setId1(virtuals.getVirtualid());
					waitOrder.setName1(virtuals.getVirtualname());
					waitOrder.setResource1(virtuals.getVirtualresource());
				    break;
				case  4:
				    IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				    Dailypros dailypros = dailyprosDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(4);
					waitOrder.setId1(dailypros.getDpid());
					waitOrder.setName1(dailypros.getDpname());
					waitOrder.setResource1(dailypros.getDpresource());
				    break;
				case  7:
				    IElectricsDao electricsDao = new ElectricsDaoImpl();
				    Electrics electrics = electricsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(7);
					waitOrder.setId1(electrics.getEleid());
					waitOrder.setName1(electrics.getElename());
					waitOrder.setResource1(electrics.getEleresource());
				    break;
				case  8:
				    IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				    Entertainments entertainments = entertainmentsDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(8);
					waitOrder.setId1(entertainments.getEnterid());
					waitOrder.setName1(entertainments.getEntername());
					waitOrder.setResource1(entertainments.getEnterresource());
				    break;
				case  16:
				    ISpprosDao spprosDao = new SpprosDaoImpl();
				    Sppros sppros = spprosDao.selectById(intId[i][1]);
				    waitOrder.setTypeid1(16);
					waitOrder.setId1(sppros.getSpid());
					waitOrder.setName1(sppros.getSpname());
					waitOrder.setResource1(sppros.getSpresource());
				    break;
				default:
					System.out.println("error intId[i][1]");
					break;
				}
				//商品2
				switch (intId[i][2]) {
				case 1:
					IAudiosDao audiosDao = new AudiosDaoImpl();
					Audios audios = audiosDao.selectById(intId[i][3]);
					waitOrder.setTypeid2(1);
					waitOrder.setId2(audios.getAudioid());
					waitOrder.setName2(audios.getAudioname());
					waitOrder.setResource2(audios.getAudioresource());
					waitOrder.setPosttime(audios.getPosttime());
					break;
				case  2:  
					IBagsDao bagsDao = new BagsDaoImpl();
					Bags bags = bagsDao.selectById(intId[i][3]);
					waitOrder.setTypeid2(2);
					waitOrder.setId2(bags.getBagid());
					waitOrder.setName2(bags.getBagbrand());
					waitOrder.setResource2(bags.getBagresource());
					waitOrder.setPosttime(bags.getPosttime());
				    break;
				case  3:
				    ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				    Cosmetics cosmetics = cosmeticsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(3);
					waitOrder.setId2(cosmetics.getCosid());
					waitOrder.setName2(cosmetics.getCosname());
					waitOrder.setResource2(cosmetics.getCosresource());
					waitOrder.setPosttime(cosmetics.getPosttime());
				    break;
				    
				case  5:
				    IDecorationsDao decorationsDao = new DecorationsDaoImpl();
				    Decorations decorations = decorationsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(5);
					waitOrder.setId2(decorations.getDecid());
					waitOrder.setName2(decorations.getDecname());
					waitOrder.setResource2(decorations.getDecresource());
					waitOrder.setPosttime(decorations.getPosttime());
				    break;
				case  6:
				    IDigitsDao digitsDao = new DigitsDaoImpl();
				    Digits digits = digitsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(6);
					waitOrder.setId2(digits.getDigitid());
					waitOrder.setName2(digits.getDigitbrand() + digits.getDigitmodel());
					waitOrder.setResource2(digits.getDigitresource());
					waitOrder.setPosttime(digits.getPosttime());
				    break;
				case  9:
					IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
					Extrabooks extrabooks = extrabooksDao.selectById(intId[i][3]);
					waitOrder.setTypeid2(9);
					waitOrder.setId2(extrabooks.getEbid());
					waitOrder.setName2(extrabooks.getEbname());
					waitOrder.setResource2(extrabooks.getEbresource());
					waitOrder.setPosttime(extrabooks.getPosttime());
				    break;
				    
				case  10:
				    IFemalesDao femalesDao = new FemalesDaoImpl();
				    Females females = femalesDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(10);
					waitOrder.setId2(females.getFemaleid());
					waitOrder.setName2(females.getFemaletype() + females.getFemalesize());
					waitOrder.setResource2(females.getFemaleresource());
					waitOrder.setPosttime(females.getPosttime());
				    break;
				case  11:
				    IInstrumentsDao instrumentsDao = new InstrumentsDaoImpl();
				    Instruments instruments = instrumentsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(11);
					waitOrder.setId2(instruments.getInstrumentid());
					waitOrder.setName2(instruments.getInstrumentname());
					waitOrder.setResource2(instruments.getInstrumentresource());
					waitOrder.setPosttime(instruments.getPosttime());
				    break;
				case  12:
				    IMalesDao malesDao = new MalesDaoImpl();
				    Males males = malesDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(12);
					waitOrder.setId2(males.getMaleid());
					waitOrder.setName2(males.getMaletype() + males.getMalesize());
					waitOrder.setResource2(males.getMaleresource());
					waitOrder.setPosttime(males.getPosttime());
				    break;
				case  13:
				    IOthersDao othersDao = new OthersDaoImpl();
				    Others others = othersDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(13);
					waitOrder.setId2(others.getOtherid());
					waitOrder.setName2(others.getOthersname());
					waitOrder.setResource2(others.getOtherresource());
					waitOrder.setPosttime(others.getPosttime());
				    break;
				case  14:
				    IPcDao pcDao = new PcDaoImpl();
				    Pc pc = pcDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(14);
					waitOrder.setId2(pc.getPcid());
					waitOrder.setName2(pc.getPcbrand() + pc.getPcmodel());
					waitOrder.setResource2(pc.getPcresource());
					waitOrder.setPosttime(pc.getPosttime());
				    break;
				case  15:
				    IPhonesDao phonesDao = new PhonesDaoImpl();
				    Phones phones = phonesDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(15);
					waitOrder.setId2(phones.getPhoneid());
					waitOrder.setName2(phones.getPhonebrand() + phones.getPhonemodel());
					waitOrder.setResource2(phones.getPhoneresource());
					waitOrder.setPosttime(phones.getPosttime());
				    break;
				case  17:
				    ISptastsDao sptastsDao = new SptastsDaoImpl();
				    Sptasts sptasts = sptastsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(17);
					waitOrder.setId2(sptasts.getSaid());
					waitOrder.setName2(sptasts.getSaname());
					waitOrder.setResource2(sptasts.getSaresource());
					waitOrder.setPosttime(sptasts.getPosttime());
				    break;
				case  18:
				    ISpteqptsDao spteqptsDao = new SpteqptsDaoImpl();
				    Spteqpts spteqpts = spteqptsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(18);
					waitOrder.setId2(spteqpts.getSeid());
					waitOrder.setName2(spteqpts.getSename());
					waitOrder.setResource2(spteqpts.getSeresource());
					waitOrder.setPosttime(spteqpts.getPosttime());
				    break;
				case  19:
				    ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				    Textbooks textbooks = textbooksDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(19);
					waitOrder.setId2(textbooks.getTbid());
					waitOrder.setName2(textbooks.getTbname());
					waitOrder.setResource2(textbooks.getTbresource());
					waitOrder.setPosttime(textbooks.getPosttime());
				    break;
				case  20:
				    IVirtualsDao virtualsDao = new VirtualsDaoImpl();
				    Virtuals virtuals = virtualsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(20);
					waitOrder.setId2(virtuals.getVirtualid());
					waitOrder.setName2(virtuals.getVirtualname());
					waitOrder.setResource2(virtuals.getVirtualresource());
					waitOrder.setPosttime(virtuals.getPosttime());
				    break;
				case  4:
				    IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				    Dailypros dailypros = dailyprosDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(4);
					waitOrder.setId2(dailypros.getDpid());
					waitOrder.setName2(dailypros.getDpname());
					waitOrder.setResource2(dailypros.getDpresource());
					waitOrder.setPosttime(dailypros.getPosttime());
				    break;
				case  7:
				    IElectricsDao electricsDao = new ElectricsDaoImpl();
				    Electrics electrics = electricsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(7);
					waitOrder.setId2(electrics.getEleid());
					waitOrder.setName2(electrics.getElename());
					waitOrder.setResource2(electrics.getEleresource());
					waitOrder.setPosttime(electrics.getPosttime());
				    break;
				case  8:
				    IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				    Entertainments entertainments = entertainmentsDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(8);
					waitOrder.setId2(entertainments.getEnterid());
					waitOrder.setName2(entertainments.getEntername());
					waitOrder.setResource2(entertainments.getEnterresource());
					waitOrder.setPosttime(entertainments.getPosttime());
				    break;
				case  16:
				    ISpprosDao spprosDao = new SpprosDaoImpl();
				    Sppros sppros = spprosDao.selectById(intId[i][3]);
				    waitOrder.setTypeid2(16);
					waitOrder.setId2(sppros.getSpid());
					waitOrder.setName2(sppros.getSpname());
					waitOrder.setResource2(sppros.getSpresource());
					waitOrder.setPosttime(sppros.getPosttime());
				    break;
				default:
					System.out.println("error intId[i][3]");
					break;
				}
				//交易用户2
				IUsersDao usersDao = new UsersDaoImpl();
				Users users = usersDao.selectById(intId[i][4]);
				waitOrder.setUserid(intId[i][4]);
				waitOrder.setUsername(users.getUsername());
				//记录交易编号 从0开始
				waitOrder.setBid(i);
				//将waitOrder对象放入lstPro
				lstPro.add(waitOrder);
			}	
		}
		System.out.println("待确认订单  :---------------------------------------------------------");
		System.out.println(lstPro);
		
		
		return lstPro;
	}

}
