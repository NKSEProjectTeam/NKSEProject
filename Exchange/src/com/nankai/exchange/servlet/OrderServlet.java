	package com.nankai.exchange.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.nankai.exchange.biz.IQueryHireBiz;
import com.nankai.exchange.biz.IQueryOrderBiz;
import com.nankai.exchange.biz.impl.QueryHireBizImpl;
import com.nankai.exchange.biz.impl.QueryOrderBizImpl;
import com.nankai.exchange.po.HireOrder;
import com.nankai.exchange.po.TradeOrder;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
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
		//HttpSession session = request.getSession();
		//int userid = Integer.parseInt(session.getAttribute("userid").toString());
		
		int userid = 2;
		
		IQueryHireBiz queryHireBiz = new QueryHireBizImpl();
		List<HireOrder> lstHireOrders = queryHireBiz.findHireOrder(userid);
		
		for(HireOrder order : lstHireOrders) {
			System.out.println(order);
		}
		
		
		IQueryOrderBiz queryOrderBiz = new QueryOrderBizImpl();
		List<TradeOrder> lstTradeOrders = queryOrderBiz.queryOrder(userid);
		
		
		request.setAttribute("msg", "yes");
		request.setAttribute("lstTradeOrders", lstTradeOrders);
		request.setAttribute("lstHireOrders", lstHireOrders);
		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/showOrders.jsp");
		dispatcher.forward(request, response);
	}
	
}
