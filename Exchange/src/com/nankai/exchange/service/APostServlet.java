package com.nankai.exchange.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IPostBiz;
import com.nankai.exchange.biz.IUsersBiz;
import com.nankai.exchange.biz.impl.PostBizImpl;
import com.nankai.exchange.biz.impl.UsersBizImpl;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class APostServlet
 */
public class APostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public APostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("UTF-8");
		
		String arr_data = request.getParameter("arr_data");
		System.out.println("arr_data:>" + arr_data);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
		
		String[] arr = gson.fromJson(arr_data, String[].class);
		
		int protype = Integer.parseInt(arr[0]);
		int psttype = Integer.parseInt(arr[1]);
		String name = arr[2];
		String mark = arr[3];
		String username = arr[4];
		
		IUsersBiz usersBiz = new UsersBizImpl();
		
		Users user = usersBiz.findByName(username);
		
		IPostBiz postBiz = new PostBizImpl();
		
		String type = "";
		
		switch (protype) {
		case 0:
			type = "audios";
			Audios audios = new Audios();
			audios.setAudioname(name);
			audios.setAudiomark(mark);
			audios.setUid(user.getUserid());
			audios.setAudiostate(0);
			audios.setAudiopublish("");
			audios.setAudioresource("");
			postBiz.addPost(type, audios, user);
			break;
		case 1:
			type = "bags";
			Bags bags = new Bags();
			bags.setBagbrand("");
			bags.setBagtype(name);
			bags.setBagmark(mark);
			
			bags.setUid(user.getUserid());
			bags.setBagstate(0);
			bags.setBagresource("");
			postBiz.addPost(type, bags, user);
			
			break;
		case 2:
			type = "cosmetics";
			Cosmetics cosmetics = new Cosmetics();
			cosmetics.setCosname(name);
			cosmetics.setCosmark(mark);
			
			cosmetics.setUid(user.getUserid());
			cosmetics.setCosstate(0);
			cosmetics.setCosbrand("");
			cosmetics.setCostype("");
			cosmetics.setCosresource("");
			postBiz.addPost(type, cosmetics, user);
			
			break;

		case 3:
			type = "dailypros";
			Dailypros dailypros = new Dailypros();
			dailypros.setDpname(name);
			dailypros.setDpmark(mark);
			
			dailypros.setUid(user.getUserid());
			dailypros.setDpstate(0);
			dailypros.setDptype("");
			dailypros.setDpresource("");
			postBiz.addPost(type, dailypros, user);
			break;

		case 4:
			type = "decorations";
			Decorations decorations = new Decorations();
			decorations.setDecname(name);
			decorations.setDecmark(mark);
			
			decorations.setUid(user.getUserid());
			decorations.setDecstate(0);
			decorations.setDectype("");
			decorations.setDecresource("");
			postBiz.addPost(type, decorations, user);
			break;

		case 5:
			type = "digits";
			Digits digits = new Digits();
			digits.setDigitmodel(name);
			digits.setDigitmark(mark);
			
			digits.setUid(user.getUserid());
			digits.setDigitstate(0);
			digits.setDigitbrand("");
			digits.setDigittype("");
			digits.setDigitresource("");
			postBiz.addPost(type, digits, user);
			break;

		case 6:
			type = "electrics";
			Electrics electrics = new Electrics();
			electrics.setElename(name);
			electrics.setElemark(mark);
			
			electrics.setUid(user.getUserid());
			electrics.setElestate(0);
			electrics.setEletype("");
			electrics.setEleresource("");
			postBiz.addPost(type, electrics, user);
			break;

		case 7:
			type = "entertainments";
			Entertainments entertainments = new Entertainments();
			entertainments.setEntername(name);
			entertainments.setEntermark(mark);
			
			entertainments.setUid(user.getUserid());
			entertainments.setEnterstate(0);
			entertainments.setEntertype("");
			entertainments.setEnterresource("");
			postBiz.addPost(type, entertainments, user);
			break;

		case 8:
			type = "extrabooks";
			Extrabooks extrabooks = new Extrabooks();
			extrabooks.setEbname(name);
			extrabooks.setEbmark(mark);
			
			extrabooks.setUid(user.getUserid());
			extrabooks.setEbstate(0);
			extrabooks.setEbauthor("");
			extrabooks.setEbpublish("");
			extrabooks.setEbresource("");
			postBiz.addPost(type, extrabooks, user);
			break;

		case 9:
			type = "females";
			Females females = new Females();
			females.setFemaletype(name);
			females.setFemalemark(mark);
			
			females.setUid(user.getUserid());
			females.setFemalestate(0);
			females.setFemalesize("");
			females.setFemaleresource("");
			postBiz.addPost(type, females, user);
			break;

		case 10:
			type = "instruments";
			Instruments instruments = new Instruments();
			instruments.setInstrumentname(name);
			instruments.setInstrumentmark(mark);
			
			instruments.setUid(user.getUserid());
			instruments.setInstrumentstate(0);
			instruments.setInstrumentbrand("");
			instruments.setInstrumenttype("");
			instruments.setInstrumentresource("");
			postBiz.addPost(type, instruments, user);
			break;
		case 11:
			type = "males";
			Males males = new Males();
			males.setMaletype(name);
			males.setMalemark(mark);
			
			males.setUid(user.getUserid());
			males.setMalestate(0);
			males.setMalesize("");
			males.setMaleresource("");
			postBiz.addPost(type, males, user);
			break;
		case 12:
			type = "others";
			Others others = new Others();
			others.setOthersname(name);
			others.setOthermark(mark);
			
			others.setUid(user.getUserid());
			others.setOthersstate(0);
			others.setOthertype("");
			others.setOtherresource("");
			postBiz.addPost(type, others, user);
			break;
		case 13:
			type = "pc";
			Pc pc = new Pc();
			pc.setPcmodel(name);
			pc.setPcmark(mark);
			
			pc.setUid(user.getUserid());
			pc.setPcstate(0);
			pc.setPcbrand("");
			pc.setPctype("");
			pc.setPcresource("");
			postBiz.addPost(type, pc, user);
			break;
		case 14:
			type = "phones";
			Phones phones = new Phones();
			phones.setPhonemodel(name);
			phones.setPhonemark(mark);
			
			phones.setUid(user.getUserid());
			phones.setPhonestate(0);
			phones.setPhonebrand("");
			phones.setPhonetype("");
			phones.setPhoneresource("");
			postBiz.addPost(type, phones, user);
			break;
		case 15:
			type = "sppros";
			Sppros sppros = new Sppros();
			sppros.setSpname(name);
			sppros.setSpmark(mark);
			
			sppros.setUid(user.getUserid());
			sppros.setSpstate(0);
			sppros.setSplocation("");
			sppros.setSptype("");
			sppros.setSpresource("");
			postBiz.addPost(type, sppros, user);
			break;
		case 16:
			type = "sptasts";
			Sptasts sptasts = new Sptasts();
			sptasts.setSaname(name);
			sptasts.setSamark(mark);
			
			sptasts.setUid(user.getUserid());
			sptasts.setSastate(0);
			sptasts.setSatype("");
			sptasts.setSaresource("");
			postBiz.addPost(type, sptasts, user);
			break;
		case 17:
			type = "spteqpts";
			Spteqpts spteqpts = new Spteqpts();
			spteqpts.setSename(name);
			spteqpts.setSemark(mark);
			
			spteqpts.setUid(user.getUserid());
			spteqpts.setSestate(0);
			spteqpts.setSetype("");
			spteqpts.setSeresource("");
			postBiz.addPost(type, spteqpts, user);
			break;
		case 18:
			type = "textbooks";
			Textbooks textbooks = new Textbooks();
			textbooks.setTbname(name);
			textbooks.setTbmark(mark);
			
			textbooks.setUid(user.getUserid());
			textbooks.setTbstate(0);
			textbooks.setTbauthor("");
			textbooks.setTbpublish("");
			textbooks.setTbversion("");
			textbooks.setTbresource("");
			postBiz.addPost(type, textbooks, user);
			break;
		case 19:
			type = "virtuals";
			Virtuals virtuals = new Virtuals();
			virtuals.setVirtualname(name);
			virtuals.setVirtualmark(mark);
			
			virtuals.setUid(user.getUserid());
			virtuals.setVirtualstate(0);
			virtuals.setVirtualresource("");
			postBiz.addPost(type, virtuals, user);
			break;
		}
		
		String msg = "success";
		String msg_data = gson.toJson(msg);
		PrintWriter out = response.getWriter();
		out.println(msg_data);
		
		out.flush();
		out.close();
	}

}
