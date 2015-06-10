package com.nankai.exchange.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.nankai.exchange.biz.ITradingBiz;
import com.nankai.exchange.biz.impl.TradingBizImpl;
import com.nankai.exchange.po.Users;

/**
 * Servlet implementation class TradeServlet
 */
public class TradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TradeServlet() {
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
		
		String type1 = request.getParameter("type");
		String type2 = request.getParameter("typeid1");
		int type1id = Integer.parseInt(request.getParameter("id"));
		int type2id = Integer.parseInt(request.getParameter("typeid2"));
		int uid = Integer.parseInt(request.getParameter("uid"));
		
		System.out.println("type1:>" + type1);
		System.out.println("type2:>" + type2);
		System.out.println("type1id:>" + type1id);
		System.out.println("type2id:>" + type2id);
		System.out.println("uid:>" + uid);
		
		HttpSession session = request.getSession();
		
		Users user = (Users) session.getAttribute("user");
		
		ITradingBiz tradingBiz = new TradingBizImpl();
		tradingBiz.trading(type1, type1id, type2, type2id, uid, user.getUserid());
		
		int woLen = (int) session.getAttribute("woLen");
		woLen--;
		session.setAttribute("woLen", woLen);
		
		response.sendRedirect("jsp/newpros.jsp");
	}

}
