package com.nankai.exchange.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.INewBiz;
import com.nankai.exchange.biz.impl.NewBizImpl;
import com.nankai.exchange.po.Extrabooks;
import com.nankai.exchange.po.Females;
import com.nankai.exchange.po.Pc;
import com.nankai.exchange.po.Phones;
import com.nankai.exchange.po.Textbooks;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class AHomeServlet
 */
public class AHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AHomeServlet() {
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
	List<Object> lstData = new ArrayList<Object>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String msg = "textbooks//extrabooks//pc//phones//females";
		INewBiz newBiz = new NewBizImpl();
		List<List<?>> lstGoods = newBiz.findNew(msg, 1);
		
		List<String[]> lst = new ArrayList<String[]>();
		
		
		
		for(List<?> l : lstGoods) {
			if(!l.isEmpty()) {
				lstData.add(l.get(0));
			} else {
				lstData.add(null);
			}
		}
		
		for(int cnt = 0; cnt < 5; cnt++) {
			lst.add(getTag(cnt));
		}
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
		
		String lst_data = gson.toJson(lst);
		
		System.out.println(lst_data);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(lst_data);
		
		out.flush();out.close();
	}
	
	
	private String[] getTag(int pos) {
		String[] arr = new String[9];
		switch (pos) {
		case 0:
			Textbooks textbooks = (Textbooks) lstData.get(pos);
			arr[0] = textbooks.getTbname();
			arr[1] = textbooks.getTbauthor();
			arr[2] = textbooks.getTbpublish();
			arr[3] = textbooks.getTbversion();
			arr[4] = "图书";
			arr[5] = "课外书";
			arr[6] = "音像";
			arr[7] = "textbooks";
			arr[8] = String.valueOf(textbooks.getTbid());
			break;
		case 1:
			Extrabooks extrabooks = (Extrabooks) lstData.get(pos);
			arr[0] = extrabooks.getEbname();
			arr[1] = extrabooks.getEbauthor();
			arr[2] = extrabooks.getEbpublish();
			arr[3] = "课外书";
			arr[4] = "图书";
			arr[5] = "教科书";
			arr[6] = "音像";
			arr[7] = "extrabooks";
			arr[8] = String.valueOf(extrabooks.getEbid());
			break;
		case 2:
			Pc pc = (Pc) lstData.get(pos);
			arr[0] = pc.getPcbrand();
			arr[1] = pc.getPcmodel();
			arr[2] = pc.getPctype();
			arr[3] = "电子";
			arr[4] = "电脑";
			arr[5] = "手机";
			arr[6] = "数码";
			arr[7] = "pc";
			arr[8] = String.valueOf(pc.getPcid());
			break;
		case 3:
			Phones phones = (Phones) lstData.get(pos);
			arr[0] = phones.getPhonebrand();
			arr[1] = phones.getPhonemodel();
			arr[2] = phones.getPhonetype();
			arr[3] = "电子";
			arr[4] = "手机";
			arr[5] = "电脑";
			arr[6] = "数码";
			arr[7] = "phones";
			arr[8] = String.valueOf(phones.getPhoneid());
			break;
		case 4:
			Females females = (Females) lstData.get(pos);
			arr[0] = females.getFemaletype();
			arr[1] = females.getFemalesize();
			arr[2] = "服饰";
			arr[3] = "衣服";
			arr[4] = "女装";
			arr[5] = "男装";
			arr[6] = "箱包";
			arr[7] = "females";
			arr[8] = String.valueOf(females.getFemaleid());
			break;
		default:
			break;
		}
		return arr;
	}

}
