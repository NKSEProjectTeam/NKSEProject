package com.nankai.exchange.biz.impl;

import java.util.ArrayList;
import java.util.List;




import com.nankai.exchange.biz.IFindExchangeBiz;
//import com.nankai.exchange.biz.INewBiz;
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
import com.nankai.exchange.po.Bags;
import com.nankai.exchange.po.Cosmetics;
import com.nankai.exchange.po.Dailypros;
import com.nankai.exchange.po.Digits;
import com.nankai.exchange.po.Electrics;
import com.nankai.exchange.po.Entertainments;
import com.nankai.exchange.po.Extrabooks;
import com.nankai.exchange.po.Females;
import com.nankai.exchange.po.Males;
import com.nankai.exchange.po.Pc;
import com.nankai.exchange.po.Phones;
import com.nankai.exchange.po.Sppros;
import com.nankai.exchange.po.Textbooks;

public class FindExchangeBizImpl implements IFindExchangeBiz {
	
	public List<List<?>> findExchangeState(String msg){
		// TODO Auto-generated method stub
		//List<List<?>> lstGoods = new ArrayList<List<?>>();
		List<List<?>> lstStateZero = new ArrayList<List<?>>();
		
		List<?> lst;
		
		// msg鐨勬牸寮忎负锛氱被鍒悕1//绫诲埆鍚�//鈥︹�
		String[] types = msg.split("//");
     	for(int i = 0; i < types.length; i++) {
     		//System.out.println(types[i]);
			switch(types[i]) {
			case "textbooks":
				ITextbooksDao textbooksDao = new TextbooksDaoImpl();
				lst = textbooksDao.selectAll();
				List<Object> lstex1=new ArrayList<Object>();
				//System.out.println(lst);
				Textbooks textbooks=new Textbooks();

				for(int j=0;j<lst.size();j++)
				{
					textbooks=(Textbooks) lst.get(j);
					//System.out.println(textbooks);
					//System.out.println(textbooks.getTbstate());
					if(textbooks.getTbstate()==0){
						lstex1.add(textbooks);
					}
				}
					
				if(lstex1.size() < 8) {
					lstStateZero.add(lstex1);
				} else {
					lstex1 = lstex1.subList(lstex1.size() - 8, lstex1.size());
					lstStateZero.add(lstex1);
				}
				
				//System.out.println(lstStateZero);
				break;
			case "extrabooks":
				IExtrabooksDao extrabooksDao = new ExtralbooksDaoImpl();
				lst = extrabooksDao.selectAll();		
				//System.out.println(lst);
				Extrabooks extrabooks=new Extrabooks();
				List<Object> lstex2=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					extrabooks=(Extrabooks) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(extrabooks.getEbstate()==0){
						lstex2.add(extrabooks);
					}
					
				}
				
				if(lstex2.size() < 8) {
					lstStateZero.add(lstex2);
				} else {
					lstex2 = lstex2.subList(lstex2.size() - 8, lstex2.size());
					lstStateZero.add(lstex2);
				}
				//System.out.println(lstStateZero);
				break;
			case "pc":
				IPcDao pcDao = new PcDaoImpl();
				lst = pcDao.selectAll();
				Pc pc=new Pc();
				List<Object> lstex3=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					pc=(Pc) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(pc.getPcstate()==0){
						lstex3.add(pc);
					}
					
				}
				
				if(lstex3.size() < 8) {
					lstStateZero.add(lstex3);
				} else {
					lstex3 = lstex3.subList(lstex3.size() - 8, lstex3.size());
					lstStateZero.add(lstex3);
				}
				break;
			case "phones":
				IPhonesDao phonesDao = new PhonesDaoImpl();
				lst = phonesDao.selectAll();
				Phones phones=new Phones();
				List<Object> lstex4=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					phones=(Phones) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(phones.getPhonestate()==0){
						lstex4.add(phones);
					}
					
				}
				
				if(lstex4.size() < 8) {
					lstStateZero.add(lstex4);
				} else {
					lstex4 = lstex4.subList(lstex4.size() - 8, lstex4.size());
					lstStateZero.add(lstex4);
				}
				break;
			case "digits":
				IDigitsDao digitsDao = new DigitsDaoImpl();
				lst = digitsDao.selectAll();
				Digits digits=new Digits();
				List<Object> lstex5=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					digits=(Digits) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(digits.getDigitstate()==0){
						lstex5.add(digits);
						
					}
					
				}
				
				if(lstex5.size() < 8) {
					lstStateZero.add(lstex5);
				} else {
					lstex5 = lstex5.subList(lstex5.size() - 8, lstex5.size());
					lstStateZero.add(lstex5);
				}
				break;
			case "dailypros":
				IDailyprosDao dailyprosDao = new DailyprosDaoImpl();
				lst = dailyprosDao.selectAll();
				Dailypros dailypros=new Dailypros();
				List<Object> lstex6=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					dailypros=(Dailypros) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(dailypros.getDpstate()==0){
						lstex6.add(dailypros);
						
					}
					
				}
				
				if(lstex6.size() < 8) {
					lstStateZero.add(lstex6);
				} else {
					lstex6 = lstex6.subList(lstex6.size() - 8, lstex6.size());
					lstStateZero.add(lstex6);
				}
				break;
			case "entertainments":
				IEntertainmentsDao entertainmentsDao = new EntertainmentsDaoImpl();
				lst = entertainmentsDao.selectAll();
				Entertainments entertainments=new Entertainments();
				List<Object> lstex7=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					entertainments=(Entertainments) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(entertainments.getEnterstate()==0){
						lstex7.add(entertainments);
						
					}
					
				}
				
				if(lstex7.size() < 8) {
					lstStateZero.add(lstex7);
				} else {
					lstex7 = lstex7.subList(lstex7.size() - 8, lstex7.size());
					lstStateZero.add(lstex7);
				}
				break;
			case "electrics":
				IElectricsDao electricsDao = new ElectricsDaoImpl();
				lst = electricsDao.selectAll();
				Electrics electrics=new Electrics();
				List<Object> lstex8=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					electrics=(Electrics) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(electrics.getElestate()==0){
						lstex8.add(electrics);
						
					}
					
				}
				
				if(lstex8.size() < 8) {
					lstStateZero.add(lstex8);
				} else {
					lstex8 = lstex8.subList(lstex8.size() - 8, lstex8.size());
					lstStateZero.add(lstex8);
				}
				break;
			case "cosmetics":
				ICosmeticsDao cosmeticsDao = new CosmeticsDaoImpl();
				lst = cosmeticsDao.selectAll();
				Cosmetics cosmetics=new Cosmetics();
				List<Object> lstex9=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					cosmetics=(Cosmetics) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(cosmetics.getCosstate()==0){
						lstex9.add(cosmetics);
						
					}
					
				}
				
				if(lstex9.size() < 8) {
					lstStateZero.add(lstex9);
				} else {
					lstex9 = lstex9.subList(lstex9.size() - 8, lstex9.size());
					lstStateZero.add(lstex9);
				}
				break;
			case "sppros":
				ISpprosDao spprosDao = new SpprosDaoImpl();
				lst = spprosDao.selectAll();
				Sppros sppros=new Sppros();
				List<Object> lstex10=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					sppros=(Sppros) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(sppros.getSpstate()==0){
						lstex10.add(sppros);
						
					}
					
				}
				
				if(lstex10.size() < 8) {
					lstStateZero.add(lstex10);
				} else {
					lstex10 = lstex10.subList(lstex10.size() - 8, lstex10.size());
					lstStateZero.add(lstex10);
				}
				break;
			case "females":
				IFemalesDao femalesDao = new FemalesDaoImpl();
				lst = femalesDao.selectAll();
				Females females=new Females();
				List<Object> lstex11=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					females=(Females) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(females.getFemalestate()==0){
						lstex11.add(females);
						
					}
					
				}
				
				if(lstex11.size() < 8) {
					lstStateZero.add(lstex11);
				} else {
					lstex11 = lstex11.subList(lstex11.size() - 8, lstex11.size());
					lstStateZero.add(lstex11);
				}
				break;
			case "males":
				IMalesDao malesDao = new MalesDaoImpl();
				lst = malesDao.selectAll();
				Males males=new Males();
				List<Object> lstex12=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					males=(Males) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(males.getMalestate()==0){
						lstex12.add(males);
						
					}
					
				}
				
				if(lstex12.size() < 8) {
					lstStateZero.add(lstex12);
				} else {
					lstex12 = lstex12.subList(lstex12.size() - 8, lstex12.size());
					lstStateZero.add(lstex12);
				}
				break;
			case "bags":
				IBagsDao bagsDao = new BagsDaoImpl();
				lst = bagsDao.selectAll();
				Bags bags=new Bags();
				List<Object> lstex13=new ArrayList<Object>();
				for(int j=0;j<lst.size();j++)
				{
					bags=(Bags) lst.get(j);
					//System.out.println(extrabooks);
					//System.out.println(extrabooks.getEbstate());
					
					if(bags.getBagstate()==0){
						lstex13.add(bags);
						
					}
					
				}
				if(lstex13.size() < 8) {
					lstStateZero.add(lstex13);
				} else {
					lstex13 = lstex13.subList(lstex13.size() - 8, lstex13.size());
					lstStateZero.add(lstex13);
				}
				break;
			}
//		}
		
//		IAudiosDao audiosDao = new AudiosDaoImpl();
//		lst = audiosDao.selectAll();
//		lstGoods.add(lst.get(lst.size() - 1));
     	}
		return lstStateZero;
	}
	
//	public static void main(String[] args){
//		
//		List<List<?>> lstStateZero=findState("textbooks//extrabooks//pc//phones//bags//female//male//sppros//cosmetics//electrics//entertainments//dailypros//digits");
//		System.out.println(lstStateZero);
//	}

}
