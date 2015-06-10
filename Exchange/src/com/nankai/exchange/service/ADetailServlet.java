package com.nankai.exchange.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nankai.exchange.biz.IDetailBiz;
import com.nankai.exchange.biz.impl.DetailBizImpl;
import com.nankai.exchange.po.Audios;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class ADetailServlet
 */
public class ADetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ADetailServlet() {
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
		String typeid1 = "audios";
		int typeid2 = 2;
		
		//String typeid1 = (String) session.getAttribute("typeid1");
		//int typeid2 = Integer.parseInt(session.getAttribute("typeid2").toString());
		
		request.setCharacterEncoding("UTF-8");
		String data = request.getParameter("data");
		
		System.out.println("data:>" + data);
		
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-ddhh:mm:ss").create();
		
		data = gson.fromJson(data, String.class);
		System.out.println("data:>" + data);
		
		String[] arr = data.split("//");
		
		typeid1 = arr[0];
		typeid2 = Integer.parseInt(arr[1]);
		
		IDetailBiz detailBiz = new DetailBizImpl();
		
		Object[] aobj = detailBiz.findItem(typeid1, typeid2);
		
		
		String gson_data = gson.toJson(aobj[0]);
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		out.println(gson_data);
		
		gson_data = gson.toJson(aobj[1]);
		out.println(gson_data);
		
		out.flush();
		out.close();

	}

}
